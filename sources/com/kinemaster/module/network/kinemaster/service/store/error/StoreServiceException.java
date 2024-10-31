package com.kinemaster.module.network.kinemaster.service.store.error;

import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.error.ServiceException;

/* loaded from: classes2.dex */
public class StoreServiceException extends ServiceException {
    public StoreServiceException(ServiceError serviceError, Throwable th) {
        super(serviceError, th);
    }

    @Override // com.kinemaster.module.network.kinemaster.error.ServiceException, java.lang.Throwable
    public String toString() {
        return "StoreServiceException {ServiceError=" + super.getServiceError() + ", Cause=" + super.getCause() + '}';
    }
}
