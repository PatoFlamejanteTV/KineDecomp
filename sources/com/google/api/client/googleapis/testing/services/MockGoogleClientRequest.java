package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes2.dex */
public class MockGoogleClientRequest<T> extends AbstractGoogleClientRequest<T> {
    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public MockGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        super.setDisableGZipContent(z);
        return this;
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public MockGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        super.setRequestHeaders(httpHeaders);
        return this;
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public MockGoogleClientRequest<T> set(String str, Object obj) {
        return (MockGoogleClientRequest) super.set(str, obj);
    }
}
