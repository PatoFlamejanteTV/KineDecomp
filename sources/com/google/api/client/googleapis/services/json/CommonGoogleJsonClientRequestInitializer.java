package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CommonGoogleJsonClientRequestInitializer extends CommonGoogleClientRequestInitializer {
    public CommonGoogleJsonClientRequestInitializer() {
    }

    @Override // com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer, com.google.api.client.googleapis.services.GoogleClientRequestInitializer
    public final void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
        initializeJsonRequest((AbstractGoogleJsonClientRequest) abstractGoogleClientRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
    }

    public CommonGoogleJsonClientRequestInitializer(String str) {
        super(str);
    }

    public CommonGoogleJsonClientRequestInitializer(String str, String str2) {
        super(str, str2);
    }
}
