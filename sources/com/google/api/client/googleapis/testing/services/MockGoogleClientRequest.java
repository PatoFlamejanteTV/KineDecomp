package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes.dex */
public class MockGoogleClientRequest<T> extends AbstractGoogleClientRequest<T> {
    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MockGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        return (MockGoogleClientRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MockGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (MockGoogleClientRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MockGoogleClientRequest<T> set(String str, Object obj) {
        return (MockGoogleClientRequest) super.set(str, obj);
    }
}
