package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public class GoogleAuthIOException extends IOException {
    private static final long serialVersionUID = 1;

    public GoogleAuthIOException(GoogleAuthException googleAuthException) {
        Preconditions.a(googleAuthException);
        initCause(googleAuthException);
    }

    @Override // java.lang.Throwable
    public GoogleAuthException getCause() {
        return (GoogleAuthException) super.getCause();
    }
}
