package com.google.api.services.plus;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* loaded from: classes.dex */
public class PlusRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        a((PlusRequest) abstractGoogleJsonClientRequest);
    }

    protected void a(PlusRequest<?> plusRequest) throws IOException {
    }
}
