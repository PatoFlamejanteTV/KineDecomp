package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public class GoogleCredential extends Credential {

    @Beta
    private static a b = new a();
    private String c;
    private Collection<String> d;
    private PrivateKey e;
    private String f;
    private String g;

    public GoogleCredential() {
        this(new Builder());
    }

    protected GoogleCredential(Builder builder) {
        super(builder);
        if (builder.k == null) {
            Preconditions.a(builder.i == null && builder.j == null && builder.m == null);
            return;
        }
        this.c = (String) Preconditions.a(builder.i);
        this.d = Collections.unmodifiableCollection(builder.j);
        this.e = builder.k;
        this.f = builder.l;
        this.g = builder.m;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleCredential a(String str) {
        return (GoogleCredential) super.a(str);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public GoogleCredential b(String str) {
        if (str != null) {
            Preconditions.a((d() == null || c() == null || i() == null) ? false : true, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
        }
        return (GoogleCredential) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleCredential a(Long l) {
        return (GoogleCredential) super.a(l);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public GoogleCredential b(Long l) {
        return (GoogleCredential) super.b(l);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GoogleCredential a(TokenResponse tokenResponse) {
        return (GoogleCredential) super.a(tokenResponse);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    @Beta
    protected TokenResponse k() throws IOException {
        if (this.e == null) {
            return super.k();
        }
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.f);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        long a2 = b().a();
        payload.setIssuer(this.c);
        payload.setAudience(e());
        payload.setIssuedAtTimeSeconds(Long.valueOf(a2 / 1000));
        payload.setExpirationTimeSeconds(Long.valueOf((a2 / 1000) + 3600));
        payload.setSubject(this.g);
        payload.put("scope", (Object) Joiner.a(' ').a(this.d));
        try {
            String a3 = JsonWebSignature.a(this.e, d(), header, payload);
            TokenRequest tokenRequest = new TokenRequest(c(), d(), new GenericUrl(e()), "urn:ietf:params:oauth:grant-type:jwt-bearer");
            tokenRequest.put("assertion", (Object) a3);
            return tokenRequest.b();
        } catch (GeneralSecurityException e) {
            IOException iOException = new IOException();
            iOException.initCause(e);
            throw iOException;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder extends Credential.Builder {
        String i;
        Collection<String> j;
        PrivateKey k;
        String l;
        String m;

        public Builder() {
            super(BearerToken.a());
            a("https://accounts.google.com/o/oauth2/token");
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder a(String str) {
            return (Builder) super.a(str);
        }
    }
}
