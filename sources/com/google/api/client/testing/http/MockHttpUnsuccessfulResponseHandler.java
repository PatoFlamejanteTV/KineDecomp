package com.google.api.client.testing.http;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class MockHttpUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2509a;
    private boolean b;

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        this.f2509a = true;
        return this.b;
    }
}
