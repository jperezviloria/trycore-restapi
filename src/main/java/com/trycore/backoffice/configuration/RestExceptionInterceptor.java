package com.trycore.backoffice.configuration;

import com.google.common.collect.ImmutableMap;
import com.trycore.backoffice.exceptions.SupportedExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Optional;

public class RestExceptionInterceptor {


    @ExceptionHandler
    public ResponseEntity<ImmutableMap<Object, Object>> processSupportedExceptions(Throwable throwable){
        Optional<ResponseEntity> supportedException = Arrays.stream(SupportedExceptions.values())
                .filter(particularSupportedException -> hasSameClass(particularSupportedException, throwable))
                .map(this::createResponseEntityFromException)
                .findFirst();

        return supportedException.isPresent()
                ? supportedException.get() :
                new ResponseEntity<ImmutableMap<Object, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Boolean hasSameClass(SupportedExceptions exception, Throwable throwable){
        return throwable.getClass().equals(exception.getExceptionClass());
    }

    private ResponseEntity createResponseEntityFromException(SupportedExceptions exception){
        return new ResponseEntity(ImmutableMap.builder()
                .put("status", exception.getStatus().value())
                .put("error", exception.getStatus().getReasonPhrase())
                .build(),
                exception.getStatus());
    }
}
