package com.google.api.client.googleapis.auth.oauth2;

import android.support.v4.app.NotificationCompat;
import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.util.List;

@Beta
/* loaded from: classes2.dex */
public class GoogleIdToken extends IdToken {

    @Beta
    /* loaded from: classes2.dex */
    public static class Payload extends IdToken.Payload {

        @Key(NotificationCompat.CATEGORY_EMAIL)
        private String email;

        @Key("email_verified")
        private Object emailVerified;

        @Key("hd")
        private String hostedDomain;

        public String getEmail() {
            return this.email;
        }

        public Boolean getEmailVerified() {
            Object obj = this.emailVerified;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return Boolean.valueOf((String) obj);
        }

        public String getHostedDomain() {
            return this.hostedDomain;
        }

        @Deprecated
        public String getIssuee() {
            return getAuthorizedParty();
        }

        @Deprecated
        public String getUserId() {
            return getSubject();
        }

        public Payload setEmail(String str) {
            this.email = str;
            return this;
        }

        public Payload setEmailVerified(Boolean bool) {
            this.emailVerified = bool;
            return this;
        }

        public Payload setHostedDomain(String str) {
            this.hostedDomain = str;
            return this;
        }

        @Deprecated
        public Payload setIssuee(String str) {
            return setAuthorizedParty(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public /* bridge */ /* synthetic */ IdToken.Payload setMethodsReferences(List list) {
            return setMethodsReferences((List<String>) list);
        }

        @Deprecated
        public Payload setUserId(String str) {
            return setSubject(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAccessTokenHash(String str) {
            super.setAccessTokenHash(str);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAuthorizationTimeSeconds(Long l) {
            super.setAuthorizationTimeSeconds(l);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setAuthorizedParty(String str) {
            super.setAuthorizedParty(str);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setClassReference(String str) {
            super.setClassReference(str);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setMethodsReferences(List<String> list) {
            super.setMethodsReferences(list);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload
        public Payload setNonce(String str) {
            super.setNonce(str);
            return this;
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setAudience(Object obj) {
            return (Payload) super.setAudience(obj);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setExpirationTimeSeconds(Long l) {
            return (Payload) super.setExpirationTimeSeconds(l);
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
        public Payload setJwtId(String str) {
            return (Payload) super.setJwtId(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setNotBeforeTimeSeconds(Long l) {
            return (Payload) super.setNotBeforeTimeSeconds(l);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setSubject(String str) {
            return (Payload) super.setSubject(str);
        }

        @Override // com.google.api.client.auth.openidconnect.IdToken.Payload, com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setType(String str) {
            return (Payload) super.setType(str);
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

    public GoogleIdToken(JsonWebSignature.Header header, Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload, bArr, bArr2);
    }

    public static GoogleIdToken a(JsonFactory jsonFactory, String str) throws IOException {
        JsonWebSignature a2 = JsonWebSignature.a(jsonFactory).a(Payload.class).a(str);
        return new GoogleIdToken(a2.a(), (Payload) a2.b(), a2.c(), a2.d());
    }

    @Override // com.google.api.client.auth.openidconnect.IdToken, com.google.api.client.json.webtoken.JsonWebToken
    public Payload b() {
        return (Payload) super.b();
    }
}
