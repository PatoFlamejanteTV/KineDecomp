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

/* loaded from: classes2.dex */
public class GoogleCredential extends Credential {

    @Beta
    private static DefaultCredentialProvider n = new DefaultCredentialProvider();
    private String o;
    private String p;
    private Collection<String> q;
    private PrivateKey r;
    private String s;
    private String t;

    /* loaded from: classes2.dex */
    public static class Builder extends Credential.Builder {
        String i;
        Collection<String> j;
        PrivateKey k;
        String l;
        String m;
        String n;

        public Builder() {
            super(BearerToken.a());
            a("https://oauth2.googleapis.com/token");
        }

        @Override // com.google.api.client.auth.oauth2.Credential.Builder
        public Builder a(String str) {
            super.a(str);
            return this;
        }
    }

    public GoogleCredential() {
        this(new Builder());
    }

    protected GoogleCredential(Builder builder) {
        super(builder);
        Collection<String> unmodifiableCollection;
        if (builder.k == null) {
            Preconditions.a(builder.i == null && builder.j == null && builder.n == null);
            return;
        }
        String str = builder.i;
        Preconditions.a(str);
        this.o = str;
        this.p = builder.m;
        Collection<String> collection = builder.j;
        if (collection == null) {
            unmodifiableCollection = Collections.emptyList();
        } else {
            unmodifiableCollection = Collections.unmodifiableCollection(collection);
        }
        this.q = unmodifiableCollection;
        this.r = builder.k;
        this.s = builder.l;
        this.t = builder.n;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential b(String str) {
        if (str != null) {
            Preconditions.a((g() == null || j() == null || c() == null) ? false : true, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
        }
        super.b(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential a(Long l) {
        super.a(l);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential a(TokenResponse tokenResponse) {
        super.a(tokenResponse);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    public GoogleCredential b(Long l) {
        return (GoogleCredential) super.b(l);
    }

    @Override // com.google.api.client.auth.oauth2.Credential
    @Beta
    public TokenResponse a() throws IOException {
        if (this.r == null) {
            return super.a();
        }
        JsonWebSignature.Header header = new JsonWebSignature.Header();
        header.setAlgorithm("RS256");
        header.setType("JWT");
        header.setKeyId(this.s);
        JsonWebToken.Payload payload = new JsonWebToken.Payload();
        long a2 = d().a();
        payload.setIssuer(this.o);
        payload.setAudience(i());
        long j = a2 / 1000;
        payload.setIssuedAtTimeSeconds(Long.valueOf(j));
        payload.setExpirationTimeSeconds(Long.valueOf(j + 3600));
        payload.setSubject(this.t);
        payload.put("scope", (Object) Joiner.a(' ').a(this.q));
        try {
            String a3 = JsonWebSignature.a(this.r, g(), header, payload);
            TokenRequest tokenRequest = new TokenRequest(j(), g(), new GenericUrl(i()), "urn:ietf:params:oauth:grant-type:jwt-bearer");
            tokenRequest.put("assertion", (Object) a3);
            return tokenRequest.execute();
        } catch (GeneralSecurityException e2) {
            IOException iOException = new IOException();
            iOException.initCause(e2);
            throw iOException;
        }
    }
}
