package com.kinemaster.module.network.kinemaster.service.dci.error;

import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.error.ServiceException;

/* loaded from: classes2.dex */
public class DciServiceException extends ServiceException {
    public DciServiceException(ServiceError serviceError, Throwable th) {
        super(serviceError, th);
    }

    @Override // com.kinemaster.module.network.kinemaster.error.ServiceException, java.lang.Throwable
    public String toString() {
        return "DciServiceException {ServiceError=" + super.getServiceError() + ", Cause=" + super.getCause() + '}';
    }
}
