package com.kinemaster.module.network.kinemaster.error;

/* loaded from: classes2.dex */
public abstract class ServiceException extends RuntimeException {
    private final ServiceError serviceError;

    public ServiceException(ServiceError serviceError, Throwable th) {
        super(th);
        this.serviceError = serviceError;
    }

    public int getErrorCode() {
        return this.serviceError.getErrorCode();
    }

    public String getErrorMessage() {
        return "errorCode: " + this.serviceError.getErrorCode() + " " + this.serviceError.getErrorMessage();
    }

    public ServiceError getServiceError() {
        return this.serviceError;
    }

    @Override // java.lang.Throwable
    public abstract String toString();
}
