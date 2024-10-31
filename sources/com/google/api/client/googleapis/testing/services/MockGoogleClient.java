package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes.dex */
public class MockGoogleClient extends AbstractGoogleClient {
    protected MockGoogleClient(Builder builder) {
        super(builder);
    }

    @Beta
    /* loaded from: classes.dex */
    public static class Builder extends AbstractGoogleClient.Builder {
        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MockGoogleClient build() {
            return new MockGoogleClient(this);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }
    }
}
