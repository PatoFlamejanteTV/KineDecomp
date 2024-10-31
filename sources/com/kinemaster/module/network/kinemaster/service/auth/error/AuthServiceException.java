package com.kinemaster.module.network.kinemaster.service.auth.error;

import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.error.ServiceException;

/* loaded from: classes2.dex */
public class AuthServiceException extends ServiceException {
    public AuthServiceException(ServiceError serviceError, Throwable th) {
        super(serviceError, th);
    }

    @Override // com.kinemaster.module.network.kinemaster.error.ServiceException, java.lang.Throwable
    public String toString() {
        return "AuthServiceException {ServiceError=" + super.getServiceError() + ", Cause=" + super.getCause() + '}';
    }
}
