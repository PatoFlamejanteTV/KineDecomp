package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class JsonWebSignature extends JsonWebToken {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2498a;
    private final byte[] b;

    public JsonWebSignature(Header header, JsonWebToken.Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload);
        this.f2498a = (byte[]) Preconditions.a(bArr);
        this.b = (byte[]) Preconditions.a(bArr2);
    }

    /* loaded from: classes.dex */
    public static class Header extends JsonWebToken.Header {

        @Key(a = "alg")
        private String algorithm;

        @Key(a = "crit")
        private List<String> critical;

        @Key(a = "jwk")
        private String jwk;

        @Key(a = "jku")
        private String jwkUrl;

        @Key(a = "kid")
        private String keyId;

        @Key(a = "x5c")
        private List<String> x509Certificates;

        @Key(a = "x5t")
        private String x509Thumbprint;

        @Key(a = "x5u")
        private String x509Url;

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header
        public Header setType(String str) {
            super.setType(str);
            return this;
        }

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public Header setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public final String getJwkUrl() {
            return this.jwkUrl;
        }

        public Header setJwkUrl(String str) {
            this.jwkUrl = str;
            return this;
        }

        public final String getJwk() {
            return this.jwk;
        }

        public Header setJwk(String str) {
            this.jwk = str;
            return this;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        public Header setKeyId(String str) {
            this.keyId = str;
            return this;
        }

        public final String getX509Url() {
            return this.x509Url;
        }

        public Header setX509Url(String str) {
            this.x509Url = str;
            return this;
        }

        public final String getX509Thumbprint() {
            return this.x509Thumbprint;
        }

        public Header setX509Thumbprint(String str) {
            this.x509Thumbprint = str;
            return this;
        }

        @Deprecated
        public final String getX509Certificate() {
            if (this.x509Certificates == null || this.x509Certificates.isEmpty()) {
                return null;
            }
            return this.x509Certificates.get(0);
        }

        public final List<String> getX509Certificates() {
            return this.x509Certificates;
        }

        @Deprecated
        public Header setX509Certificate(String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.x509Certificates = arrayList;
            return this;
        }

        public Header setX509Certificates(List<String> list) {
            this.x509Certificates = list;
            return this;
        }

        public final List<String> getCritical() {
            return this.critical;
        }

        public Header setCritical(List<String> list) {
            this.critical = list;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Header clone() {
            return (Header) super.clone();
        }
    }

    @Override // com.google.api.client.json.webtoken.JsonWebToken
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Header g() {
        return (Header) super.g();
    }

    public final byte[] e() {
        return this.f2498a;
    }

    public final byte[] f() {
        return this.b;
    }

    public static JsonWebSignature c(JsonFactory jsonFactory, String str) throws IOException {
        return a(jsonFactory).a(str);
    }

    public static Parser a(JsonFactory jsonFactory) {
        return new Parser(jsonFactory);
    }

    /* loaded from: classes.dex */
    public static final class Parser {

        /* renamed from: a, reason: collision with root package name */
        private final JsonFactory f2499a;
        private Class<? extends Header> b = Header.class;
        private Class<? extends JsonWebToken.Payload> c = JsonWebToken.Payload.class;

        public Parser(JsonFactory jsonFactory) {
            this.f2499a = (JsonFactory) Preconditions.a(jsonFactory);
        }

        public Parser a(Class<? extends JsonWebToken.Payload> cls) {
            this.c = cls;
            return this;
        }

        public JsonWebSignature a(String str) throws IOException {
            int indexOf = str.indexOf(46);
            Preconditions.a(indexOf != -1);
            byte[] a2 = Base64.a(str.substring(0, indexOf));
            int indexOf2 = str.indexOf(46, indexOf + 1);
            Preconditions.a(indexOf2 != -1);
            Preconditions.a(str.indexOf(46, indexOf2 + 1) == -1);
            byte[] a3 = Base64.a(str.substring(indexOf + 1, indexOf2));
            byte[] a4 = Base64.a(str.substring(indexOf2 + 1));
            byte[] a5 = StringUtils.a(str.substring(0, indexOf2));
            Header header = (Header) this.f2499a.a(new ByteArrayInputStream(a2), this.b);
            Preconditions.a(header.getAlgorithm() != null);
            return new JsonWebSignature(header, (JsonWebToken.Payload) this.f2499a.a(new ByteArrayInputStream(a3), this.c), a4, a5);
        }
    }

    public static String a(PrivateKey privateKey, JsonFactory jsonFactory, Header header, JsonWebToken.Payload payload) throws GeneralSecurityException, IOException {
        String valueOf = String.valueOf(String.valueOf(Base64.c(jsonFactory.c(header))));
        String valueOf2 = String.valueOf(String.valueOf(Base64.c(jsonFactory.c(payload))));
        String sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length()).append(valueOf).append(".").append(valueOf2).toString();
        byte[] a2 = SecurityUtils.a(SecurityUtils.c(), privateKey, StringUtils.a(sb));
        String valueOf3 = String.valueOf(String.valueOf(sb));
        String valueOf4 = String.valueOf(String.valueOf(Base64.c(a2)));
        return new StringBuilder(valueOf3.length() + 1 + valueOf4.length()).append(valueOf3).append(".").append(valueOf4).toString();
    }
}
