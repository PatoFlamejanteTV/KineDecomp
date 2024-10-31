package com.google.api.client.googleapis.services.json;

import com.facebook.share.internal.ShareConstants;
import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class AbstractGoogleJsonClient extends AbstractGoogleClient {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleJsonClient(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public JsonObjectParser getObjectParser() {
        return (JsonObjectParser) super.getObjectParser();
    }

    public final JsonFactory getJsonFactory() {
        return getObjectParser().a();
    }

    /* loaded from: classes.dex */
    public static abstract class Builder extends AbstractGoogleClient.Builder {
        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public abstract AbstractGoogleJsonClient build();

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, String str, String str2, HttpRequestInitializer httpRequestInitializer, boolean z) {
            super(httpTransport, str, str2, new JsonObjectParser.Builder(jsonFactory).a(z ? Arrays.asList(ShareConstants.WEB_DIALOG_PARAM_DATA, "error") : Collections.emptySet()).a(), httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public final JsonObjectParser getObjectParser() {
            return (JsonObjectParser) super.getObjectParser();
        }

        public final JsonFactory getJsonFactory() {
            return getObjectParser().a();
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }
    }
}
