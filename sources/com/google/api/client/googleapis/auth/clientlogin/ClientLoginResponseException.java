package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes.dex */
public class ClientLoginResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4974317674023010928L;

    /* renamed from: a, reason: collision with root package name */
    private final transient ClientLogin.ErrorInfo f2428a;

    ClientLoginResponseException(HttpResponseException.Builder builder, ClientLogin.ErrorInfo errorInfo) {
        super(builder);
        this.f2428a = errorInfo;
    }

    public final ClientLogin.ErrorInfo getDetails() {
        return this.f2428a;
    }
}
