package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@PublicApi
/* loaded from: classes2.dex */
public class FirebaseAuthException extends FirebaseException {
    private final String errorCode;

    @PublicApi
    public FirebaseAuthException(String str, String str2) {
        super(str2);
        Preconditions.b(str);
        this.errorCode = str;
    }

    @PublicApi
    public String getErrorCode() {
        return this.errorCode;
    }
}
