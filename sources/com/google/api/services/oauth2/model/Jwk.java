package com.google.api.services.oauth2.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class Jwk extends GenericJson {

    @Key
    private List<Keys> keys;

    static {
        Data.a((Class<?>) Keys.class);
    }

    public List<Keys> getKeys() {
        return this.keys;
    }

    public Jwk setKeys(List<Keys> list) {
        this.keys = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Jwk set(String str, Object obj) {
        return (Jwk) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Jwk clone() {
        return (Jwk) super.clone();
    }

    /* loaded from: classes.dex */
    public static final class Keys extends GenericJson {

        @Key
        private String alg;

        @Key
        private String e;

        @Key
        private String kid;

        @Key
        private String kty;

        @Key
        private String n;

        @Key
        private String use;

        public String getAlg() {
            return this.alg;
        }

        public Keys setAlg(String str) {
            this.alg = str;
            return this;
        }

        public String getE() {
            return this.e;
        }

        public Keys setE(String str) {
            this.e = str;
            return this;
        }

        public String getKid() {
            return this.kid;
        }

        public Keys setKid(String str) {
            this.kid = str;
            return this;
        }

        public String getKty() {
            return this.kty;
        }

        public Keys setKty(String str) {
            this.kty = str;
            return this;
        }

        public String getN() {
            return this.n;
        }

        public Keys setN(String str) {
            this.n = str;
            return this;
        }

        public String getUse() {
            return this.use;
        }

        public Keys setUse(String str) {
            this.use = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Keys set(String str, Object obj) {
            return (Keys) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Keys clone() {
            return (Keys) super.clone();
        }
    }
}
