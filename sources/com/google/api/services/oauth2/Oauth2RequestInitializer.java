package com.google.api.services.oauth2;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Oauth2RequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        a((Oauth2Request) abstractGoogleJsonClientRequest);
    }

    protected void a(Oauth2Request<?> oauth2Request) throws IOException {
    }
}
