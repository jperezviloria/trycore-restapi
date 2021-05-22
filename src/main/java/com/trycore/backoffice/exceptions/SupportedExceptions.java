package com.trycore.backoffice.exceptions;

import com.trycore.backoffice.exceptions.planet.PlanetTopDontHaveThreeRecordsException;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    PLANET_TOP_DONT_HAVE_THREE_RECORDS(PlanetTopDontHaveThreeRecordsException.class, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

    private Class<? extends Throwable> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends Throwable>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends Throwable> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
