package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;

/* loaded from: classes.dex */
public class AdobeAuthUserProfileImpl extends AdobeAuthUserProfile {
    public void setAdobeID(String str) {
        this.adobeID = str;
    }

    public void setCountrycode(String str) {
        this.countryCode = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailVerified(boolean z) {
        this.emailVerified = z;
    }

    public void setEnterprise(boolean z) {
        this.isEnterprise = z;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }
}
