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

/* loaded from: classes2.dex */
public class JsonWebSignature extends JsonWebToken {

    /* renamed from: c */
    private final byte[] f14840c;

    /* renamed from: d */
    private final byte[] f14841d;

    /* loaded from: classes2.dex */
    public static class Header extends JsonWebToken.Header {

        @Key("alg")
        private String algorithm;

        @Key("crit")
        private List<String> critical;

        @Key("jwk")
        private String jwk;

        @Key("jku")
        private String jwkUrl;

        @Key("kid")
        private String keyId;

        @Key("x5c")
        private List<String> x509Certificates;

        @Key("x5t")
        private String x509Thumbprint;

        @Key("x5u")
        private String x509Url;

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public final List<String> getCritical() {
            return this.critical;
        }

        public final String getJwk() {
            return this.jwk;
        }

        public final String getJwkUrl() {
            return this.jwkUrl;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        @Deprecated
        public final String getX509Certificate() {
            List<String> list = this.x509Certificates;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return this.x509Certificates.get(0);
        }

        public final List<String> getX509Certificates() {
            return this.x509Certificates;
        }

        public final String getX509Thumbprint() {
            return this.x509Thumbprint;
        }

        public final String getX509Url() {
            return this.x509Url;
        }

        public Header setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Header setCritical(List<String> list) {
            this.critical = list;
            return this;
        }

        public Header setJwk(String str) {
            this.jwk = str;
            return this;
        }

        public Header setJwkUrl(String str) {
            this.jwkUrl = str;
            return this;
        }

        public Header setKeyId(String str) {
            this.keyId = str;
            return this;
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

        public Header setX509Thumbprint(String str) {
            this.x509Thumbprint = str;
            return this;
        }

        public Header setX509Url(String str) {
            this.x509Url = str;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header
        public Header setType(String str) {
            super.setType(str);
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

    /* loaded from: classes2.dex */
    public static final class Parser {

        /* renamed from: a */
        private final JsonFactory f14842a;

        /* renamed from: b */
        private Class<? extends Header> f14843b = Header.class;

        /* renamed from: c */
        private Class<? extends JsonWebToken.Payload> f14844c = JsonWebToken.Payload.class;

        public Parser(JsonFactory jsonFactory) {
            Preconditions.a(jsonFactory);
            this.f14842a = jsonFactory;
        }

        public Parser a(Class<? extends JsonWebToken.Payload> cls) {
            this.f14844c = cls;
            return this;
        }

        public JsonWebSignature a(String str) throws IOException {
            int indexOf = str.indexOf(46);
            Preconditions.a(indexOf != -1);
            byte[] a2 = Base64.a(str.substring(0, indexOf));
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(46, i);
            Preconditions.a(indexOf2 != -1);
            int i2 = indexOf2 + 1;
            Preconditions.a(str.indexOf(46, i2) == -1);
            byte[] a3 = Base64.a(str.substring(i, indexOf2));
            byte[] a4 = Base64.a(str.substring(i2));
            byte[] a5 = StringUtils.a(str.substring(0, indexOf2));
            Header header = (Header) this.f14842a.a(new ByteArrayInputStream(a2), this.f14843b);
            Preconditions.a(header.getAlgorithm() != null);
            return new JsonWebSignature(header, (JsonWebToken.Payload) this.f14842a.a(new ByteArrayInputStream(a3), this.f14844c), a4, a5);
        }
    }

    public JsonWebSignature(Header header, JsonWebToken.Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload);
        Preconditions.a(bArr);
        this.f14840c = bArr;
        Preconditions.a(bArr2);
        this.f14841d = bArr2;
    }

    @Override // com.google.api.client.json.webtoken.JsonWebToken
    public Header a() {
        return (Header) super.a();
    }

    public final byte[] c() {
        return this.f14840c;
    }

    public final byte[] d() {
        return this.f14841d;
    }

    public static JsonWebSignature a(JsonFactory jsonFactory, String str) throws IOException {
        return a(jsonFactory).a(str);
    }

    public static Parser a(JsonFactory jsonFactory) {
        return new Parser(jsonFactory);
    }

    public static String a(PrivateKey privateKey, JsonFactory jsonFactory, Header header, JsonWebToken.Payload payload) throws GeneralSecurityException, IOException {
        String str = Base64.c(jsonFactory.a(header)) + "." + Base64.c(jsonFactory.a(payload));
        return str + "." + Base64.c(SecurityUtils.a(SecurityUtils.c(), privateKey, StringUtils.a(str)));
    }
}
