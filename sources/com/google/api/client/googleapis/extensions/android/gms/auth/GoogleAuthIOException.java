package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class GoogleAuthIOException extends IOException {
    private static final long serialVersionUID = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleAuthIOException(GoogleAuthException googleAuthException) {
        initCause((Throwable) Preconditions.a(googleAuthException));
    }

    @Override // java.lang.Throwable
    public GoogleAuthException getCause() {
        return (GoogleAuthException) super.getCause();
    }
}
