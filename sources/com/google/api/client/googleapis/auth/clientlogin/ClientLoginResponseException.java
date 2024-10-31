package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes2.dex */
public class ClientLoginResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4974317674023010928L;

    /* renamed from: b */
    private final transient ClientLogin.ErrorInfo f14648b;

    ClientLoginResponseException(HttpResponseException.Builder builder, ClientLogin.ErrorInfo errorInfo) {
        super(builder);
        this.f14648b = errorInfo;
    }

    public final ClientLogin.ErrorInfo getDetails() {
        return this.f14648b;
    }
}
