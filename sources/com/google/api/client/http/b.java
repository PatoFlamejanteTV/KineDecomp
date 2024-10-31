package com.google.api.client.http;

import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;

/* compiled from: HttpBackOffUnsuccessfulResponseHandler.java */
/* loaded from: classes.dex */
final class b implements HttpBackOffUnsuccessfulResponseHandler.BackOffRequired {
    @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
    public boolean a(HttpResponse httpResponse) {
        return true;
    }
}
