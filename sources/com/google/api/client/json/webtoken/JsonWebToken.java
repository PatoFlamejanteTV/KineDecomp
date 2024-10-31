package com.google.api.client.json.webtoken;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class JsonWebToken {

    /* renamed from: a */
    private final Header f14845a;

    /* renamed from: b */
    private final Payload f14846b;

    public JsonWebToken(Header header, Payload payload) {
        Preconditions.a(header);
        this.f14845a = header;
        Preconditions.a(payload);
        this.f14846b = payload;
    }

    public Header a() {
        return this.f14845a;
    }

    public Payload b() {
        return this.f14846b;
    }

    public String toString() {
        return Objects.a(this).a("header", this.f14845a).a(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, this.f14846b).toString();
    }

    /* loaded from: classes2.dex */
    public static class Header extends GenericJson {

        @Key("cty")
        private String contentType;

        @Key("typ")
        private String type;

        public final String getContentType() {
            return this.contentType;
        }

        public final String getType() {
            return this.type;
        }

        public Header setContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Header setType(String str) {
            this.type = str;
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

    /* loaded from: classes2.dex */
    public static class Payload extends GenericJson {

        @Key("aud")
        private Object audience;

        @Key("exp")
        private Long expirationTimeSeconds;

        @Key("iat")
        private Long issuedAtTimeSeconds;

        @Key("iss")
        private String issuer;

        @Key("jti")
        private String jwtId;

        @Key("nbf")
        private Long notBeforeTimeSeconds;

        @Key("sub")
        private String subject;

        @Key("typ")
        private String type;

        public final Object getAudience() {
            return this.audience;
        }

        public final List<String> getAudienceAsList() {
            Object obj = this.audience;
            if (obj == null) {
                return Collections.emptyList();
            }
            if (obj instanceof String) {
                return Collections.singletonList((String) obj);
            }
            return (List) obj;
        }

        public final Long getExpirationTimeSeconds() {
            return this.expirationTimeSeconds;
        }

        public final Long getIssuedAtTimeSeconds() {
            return this.issuedAtTimeSeconds;
        }

        public final String getIssuer() {
            return this.issuer;
        }

        public final String getJwtId() {
            return this.jwtId;
        }

        public final Long getNotBeforeTimeSeconds() {
            return this.notBeforeTimeSeconds;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final String getType() {
            return this.type;
        }

        public Payload setAudience(Object obj) {
            this.audience = obj;
            return this;
        }

        public Payload setExpirationTimeSeconds(Long l) {
            this.expirationTimeSeconds = l;
            return this;
        }

        public Payload setIssuedAtTimeSeconds(Long l) {
            this.issuedAtTimeSeconds = l;
            return this;
        }

        public Payload setIssuer(String str) {
            this.issuer = str;
            return this;
        }

        public Payload setJwtId(String str) {
            this.jwtId = str;
            return this;
        }

        public Payload setNotBeforeTimeSeconds(Long l) {
            this.notBeforeTimeSeconds = l;
            return this;
        }

        public Payload setSubject(String str) {
            this.subject = str;
            return this;
        }

        public Payload setType(String str) {
            this.type = str;
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
}
