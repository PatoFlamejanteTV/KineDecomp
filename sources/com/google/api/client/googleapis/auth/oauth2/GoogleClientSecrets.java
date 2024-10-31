package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/* loaded from: classes.dex */
public final class GoogleClientSecrets extends GenericJson {

    @Key
    private Details installed;

    @Key
    private Details web;

    public Details getInstalled() {
        return this.installed;
    }

    public GoogleClientSecrets setInstalled(Details details) {
        this.installed = details;
        return this;
    }

    public Details getWeb() {
        return this.web;
    }

    public GoogleClientSecrets setWeb(Details details) {
        this.web = details;
        return this;
    }

    public Details getDetails() {
        Preconditions.a((this.web == null) != (this.installed == null));
        return this.web == null ? this.installed : this.web;
    }

    /* loaded from: classes.dex */
    public static final class Details extends GenericJson {

        @Key(a = "auth_uri")
        private String authUri;

        @Key(a = "client_id")
        private String clientId;

        @Key(a = "client_secret")
        private String clientSecret;

        @Key(a = "redirect_uris")
        private List<String> redirectUris;

        @Key(a = "token_uri")
        private String tokenUri;

        public String getClientId() {
            return this.clientId;
        }

        public Details setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public String getClientSecret() {
            return this.clientSecret;
        }

        public Details setClientSecret(String str) {
            this.clientSecret = str;
            return this;
        }

        public List<String> getRedirectUris() {
            return this.redirectUris;
        }

        public Details setRedirectUris(List<String> list) {
            this.redirectUris = list;
            return this;
        }

        public String getAuthUri() {
            return this.authUri;
        }

        public Details setAuthUri(String str) {
            this.authUri = str;
            return this;
        }

        public String getTokenUri() {
            return this.tokenUri;
        }

        public Details setTokenUri(String str) {
            this.tokenUri = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Details set(String str, Object obj) {
            return (Details) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Details clone() {
            return (Details) super.clone();
        }
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public GoogleClientSecrets set(String str, Object obj) {
        return (GoogleClientSecrets) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GoogleClientSecrets clone() {
        return (GoogleClientSecrets) super.clone();
    }

    public static GoogleClientSecrets load(JsonFactory jsonFactory, Reader reader) throws IOException {
        return (GoogleClientSecrets) jsonFactory.a(reader, GoogleClientSecrets.class);
    }
}
