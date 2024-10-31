package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.util.List;

@Beta
/* loaded from: classes.dex */
public class GoogleIdToken extends IdToken {
    public static GoogleIdToken b(JsonFactory jsonFactory, String str) throws IOException {
        JsonWebSignature a2 = JsonWebSignature.a(jsonFactory).a(Payload.class).a(str);
        return new GoogleIdToken(a2.g(), (Payload) a2.b(), a2.e(), a2.f());
    }

    public GoogleIdToken(JsonWebSignature.Header header, Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload, bArr, bArr2);
    }

    @Override // com.google.api.client.auth.openidconnect.IdToken, com.google.api.client.json.webtoken.JsonWebToken
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Payload b() {
        return (Payload) super.b();
    }

    @Beta
    /* loaded from: classes.dex */
    public static class Payload extends IdToken.Payload {

        @Key(a = "email")
        private String email;

        @Key(a = "email_verified")
        private Object emailVerified;

        @Key(a = "hd")
        private String hostedDomain;

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public /* bridge */ /* synthetic */ IdToken.Payload setMethodsReferences(List list) {
            return setMethodsReferences((List<String>) list);
        }

        @Deprecated
        public String getUserId() {
            return getSubject();
        }

        @Deprecated
        public Payload setUserId(String str) {
            return setSubject(str);
        }

        @Deprecated
        public String getIssuee() {
            return getAuthorizedParty();
        }

        @Deprecated
        public Payload setIssuee(String str) {
            return setAuthorizedParty(str);
        }

        public String getHostedDomain() {
            return this.hostedDomain;
        }

        public Payload setHostedDomain(String str) {
            this.hostedDomain = str;
            return this;
        }

        public String getEmail() {
            return this.email;
        }

        public Payload setEmail(String str) {
            this.email = str;
            return this;
        }

        public Boolean getEmailVerified() {
            if (this.emailVerified == null) {
                return null;
            }
            if (this.emailVerified instanceof Boolean) {
                return (Boolean) this.emailVerified;
            }
            return Boolean.valueOf((String) this.emailVerified);
        }

        public Payload setEmailVerified(Boolean bool) {
            this.emailVerified = bool;
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAuthorizationTimeSeconds(Long l) {
            return (Payload) super.setAuthorizationTimeSeconds(l);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAuthorizedParty(String str) {
            return (Payload) super.setAuthorizedParty(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setNonce(String str) {
            return (Payload) super.setNonce(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAccessTokenHash(String str) {
            return (Payload) super.setAccessTokenHash(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setClassReference(String str) {
            return (Payload) super.setClassReference(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setMethodsReferences(List<String> list) {
            return (Payload) super.setMethodsReferences(list);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setExpirationTimeSeconds(Long l) {
            return (Payload) super.setExpirationTimeSeconds(l);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setNotBeforeTimeSeconds(Long l) {
            return (Payload) super.setNotBeforeTimeSeconds(l);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuedAtTimeSeconds(Long l) {
            return (Payload) super.setIssuedAtTimeSeconds(l);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuer(String str) {
            return (Payload) super.setIssuer(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setAudience(Object obj) {
            return (Payload) super.setAudience(obj);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setJwtId(String str) {
            return (Payload) super.setJwtId(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setType(String str) {
            return (Payload) super.setType(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setSubject(String str) {
            return (Payload) super.setSubject(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Payload clone() {
            return (Payload) super.clone();
        }
    }
}
