package com.google.firebase;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

@KeepForSdk
/* loaded from: classes2.dex */
public class FirebaseExceptionMapper implements StatusExceptionMapper {
    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    public Exception a(Status status) {
        if (status.getStatusCode() == 8) {
            return new FirebaseException(status.R());
        }
        return new FirebaseApiNotAvailableException(status.R());
    }
}
