package com.google.api.services.oauth2.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class Userinfoplus extends GenericJson {

    @Key
    private String email;

    @Key(a = "family_name")
    private String familyName;

    @Key
    private String gender;

    @Key(a = "given_name")
    private String givenName;

    @Key
    private String hd;

    @Key
    private String id;

    @Key
    private String link;

    @Key
    private String locale;

    @Key
    private String name;

    @Key
    private String picture;

    @Key(a = "verified_email")
    private Boolean verifiedEmail;

    public String getEmail() {
        return this.email;
    }

    public Userinfoplus setEmail(String str) {
        this.email = str;
        return this;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public Userinfoplus setFamilyName(String str) {
        this.familyName = str;
        return this;
    }

    public String getGender() {
        return this.gender;
    }

    public Userinfoplus setGender(String str) {
        this.gender = str;
        return this;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public Userinfoplus setGivenName(String str) {
        this.givenName = str;
        return this;
    }

    public String getHd() {
        return this.hd;
    }

    public Userinfoplus setHd(String str) {
        this.hd = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Userinfoplus setId(String str) {
        this.id = str;
        return this;
    }

    public String getLink() {
        return this.link;
    }

    public Userinfoplus setLink(String str) {
        this.link = str;
        return this;
    }

    public String getLocale() {
        return this.locale;
    }

    public Userinfoplus setLocale(String str) {
        this.locale = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Userinfoplus setName(String str) {
        this.name = str;
        return this;
    }

    public String getPicture() {
        return this.picture;
    }

    public Userinfoplus setPicture(String str) {
        this.picture = str;
        return this;
    }

    public Boolean getVerifiedEmail() {
        return this.verifiedEmail;
    }

    public Userinfoplus setVerifiedEmail(Boolean bool) {
        this.verifiedEmail = bool;
        return this;
    }

    public boolean isVerifiedEmail() {
        if (this.verifiedEmail == null || this.verifiedEmail == Data.f2533a) {
            return true;
        }
        return this.verifiedEmail.booleanValue();
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Userinfoplus set(String str, Object obj) {
        return (Userinfoplus) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Userinfoplus clone() {
        return (Userinfoplus) super.clone();
    }
}
