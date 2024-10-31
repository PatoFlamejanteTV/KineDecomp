package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class Place extends GenericJson {

    @Key
    private Address address;

    @Key
    private String displayName;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private Position position;

    public Address getAddress() {
        return this.address;
    }

    public Place setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Place setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Place setId(String str) {
        this.id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Place setKind(String str) {
        this.kind = str;
        return this;
    }

    public Position getPosition() {
        return this.position;
    }

    public Place setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Place set(String str, Object obj) {
        return (Place) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Place clone() {
        return (Place) super.clone();
    }

    /* loaded from: classes.dex */
    public static final class Address extends GenericJson {

        @Key
        private String formatted;

        public String getFormatted() {
            return this.formatted;
        }

        public Address setFormatted(String str) {
            this.formatted = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Address set(String str, Object obj) {
            return (Address) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Address clone() {
            return (Address) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Position extends GenericJson {

        @Key
        private Double latitude;

        @Key
        private Double longitude;

        public Double getLatitude() {
            return this.latitude;
        }

        public Position setLatitude(Double d) {
            this.latitude = d;
            return this;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public Position setLongitude(Double d) {
            this.longitude = d;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Position set(String str, Object obj) {
            return (Position) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Position clone() {
            return (Position) super.clone();
        }
    }
}
