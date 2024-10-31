package com.google.api.client.auth.openidconnect;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import java.io.IOException;
import java.util.List;

@Beta
/* loaded from: classes.dex */
public class IdToken extends JsonWebSignature {
    public IdToken(JsonWebSignature.Header header, Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload, bArr, bArr2);
    }

    @Override // com.google.api.client.json.webtoken.JsonWebToken
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Payload b() {
        return (Payload) super.b();
    }

    public static IdToken a(JsonFactory jsonFactory, String str) throws IOException {
        JsonWebSignature a2 = JsonWebSignature.a(jsonFactory).a(Payload.class).a(str);
        return new IdToken(a2.g(), (Payload) a2.b(), a2.e(), a2.f());
    }

    @Beta
    /* loaded from: classes.dex */
    public static class Payload extends JsonWebToken.Payload {

        @Key(a = "at_hash")
        private String accessTokenHash;

        @Key(a = "auth_time")
        private Long authorizationTimeSeconds;

        @Key(a = "azp")
        private String authorizedParty;

        @Key(a = "acr")
        private String classReference;

        @Key(a = "amr")
        private List<String> methodsReferences;

        @Key
        private String nonce;

        public final Long getAuthorizationTimeSeconds() {
            return this.authorizationTimeSeconds;
        }

        public Payload setAuthorizationTimeSeconds(Long l) {
            this.authorizationTimeSeconds = l;
            return this;
        }

        public final String getAuthorizedParty() {
            return this.authorizedParty;
        }

        public Payload setAuthorizedParty(String str) {
            this.authorizedParty = str;
            return this;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public Payload setNonce(String str) {
            this.nonce = str;
            return this;
        }

        public final String getAccessTokenHash() {
            return this.accessTokenHash;
        }

        public Payload setAccessTokenHash(String str) {
            this.accessTokenHash = str;
            return this;
        }

        public final String getClassReference() {
            return this.classReference;
        }

        public Payload setClassReference(String str) {
            this.classReference = str;
            return this;
        }

        public final List<String> getMethodsReferences() {
            return this.methodsReferences;
        }

        public Payload setMethodsReferences(List<String> list) {
            this.methodsReferences = list;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setExpirationTimeSeconds(Long l) {
            return (Payload) super.setExpirationTimeSeconds(l);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setNotBeforeTimeSeconds(Long l) {
            return (Payload) super.setNotBeforeTimeSeconds(l);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuedAtTimeSeconds(Long l) {
            return (Payload) super.setIssuedAtTimeSeconds(l);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setIssuer(String str) {
            return (Payload) super.setIssuer(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setAudience(Object obj) {
            return (Payload) super.setAudience(obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setJwtId(String str) {
            return (Payload) super.setJwtId(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setType(String str) {
            return (Payload) super.setType(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload
        public Payload setSubject(String str) {
            return (Payload) super.setSubject(str);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Payload set(String str, Object obj) {
            return (Payload) super.set(str, obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Payload, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Payload clone() {
            return (Payload) super.clone();
        }
    }
}
