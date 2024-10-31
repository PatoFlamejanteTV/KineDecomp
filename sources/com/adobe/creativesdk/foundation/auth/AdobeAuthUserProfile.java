package com.adobe.creativesdk.foundation.auth;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AdobeAuthUserProfile implements Serializable {
    protected String adobeID = null;
    protected String displayName = null;
    protected String firstName = null;
    protected String lastName = null;
    protected String email = null;
    protected boolean emailVerified = false;
    protected String description = null;
    protected String countryCode = null;
    protected boolean isEnterprise = false;

    public String getAdobeID() {
        return this.adobeID;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    public boolean isEnterpriseUser() {
        return this.isEnterprise;
    }
}
