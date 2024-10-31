package com.google.api.client.json.webtoken;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class JsonWebToken {

    /* renamed from: a, reason: collision with root package name */
    private final Header f2500a;
    private final Payload b;

    public JsonWebToken(Header header, Payload payload) {
        this.f2500a = (Header) Preconditions.a(header);
        this.b = (Payload) Preconditions.a(payload);
    }

    /* loaded from: classes.dex */
    public static class Header extends GenericJson {

        @Key(a = "cty")
        private String contentType;

        @Key(a = "typ")
        private String type;

        public final String getType() {
            return this.type;
        }

        public Header setType(String str) {
            this.type = str;
            return this;
        }

        public final String getContentType() {
            return this.contentType;
        }

        public Header setContentType(String str) {
            this.contentType = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Header clone() {
            return (Header) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static class Payload extends GenericJson {

        @Key(a = "aud")
        private Object audience;

        @Key(a = "exp")
        private Long expirationTimeSeconds;

        @Key(a = "iat")
        private Long issuedAtTimeSeconds;

        @Key(a = "iss")
        private String issuer;

        @Key(a = "jti")
        private String jwtId;

        @Key(a = "nbf")
        private Long notBeforeTimeSeconds;

        @Key(a = "sub")
        private String subject;

        @Key(a = "typ")
        private String type;

        public final Long getExpirationTimeSeconds() {
            return this.expirationTimeSeconds;
        }

        public Payload setExpirationTimeSeconds(Long l) {
            this.expirationTimeSeconds = l;
            return this;
        }

        public final Long getNotBeforeTimeSeconds() {
            return this.notBeforeTimeSeconds;
        }

        public Payload setNotBeforeTimeSeconds(Long l) {
            this.notBeforeTimeSeconds = l;
            return this;
        }

        public final Long getIssuedAtTimeSeconds() {
            return this.issuedAtTimeSeconds;
        }

        public Payload setIssuedAtTimeSeconds(Long l) {
            this.issuedAtTimeSeconds = l;
            return this;
        }

        public final String getIssuer() {
            return this.issuer;
        }

        public Payload setIssuer(String str) {
            this.issuer = str;
            return this;
        }

        public final Object getAudience() {
            return this.audience;
        }

        public final List<String> getAudienceAsList() {
            if (this.audience == null) {
                return Collections.emptyList();
            }
            if (this.audience instanceof String) {
                return Collections.singletonList((String) this.audience);
            }
            return (List) this.audience;
        }

        public Payload setAudience(Object obj) {
            this.audience = obj;
            return this;
        }

        public final String getJwtId() {
            return this.jwtId;
        }

        public Payload setJwtId(String str) {
            this.jwtId = str;
            return this;
        }

        public final String getType() {
            return this.type;
        }

        public Payload setType(String str) {
            this.type = str;
            return this;
        }

        public final String getSubject() {
            return this.subject;
        }

        public Payload setSubject(String str) {
            this.subject = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Payload clone() {
            return (Payload) super.clone();
        }
    }

    public String toString() {
        return Objects.a(this).a("header", this.f2500a).a("payload", this.b).toString();
    }

    public Header g() {
        return this.f2500a;
    }

    public Payload b() {
        return this.b;
    }
}
