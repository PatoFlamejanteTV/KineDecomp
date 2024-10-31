package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes.dex */
public interface HttpUnsuccessfulResponseHandler {
    boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException;
}
