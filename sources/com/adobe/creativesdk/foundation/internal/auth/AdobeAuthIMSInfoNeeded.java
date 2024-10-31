package com.adobe.creativesdk.foundation.internal.auth;

/* loaded from: classes.dex */
public enum AdobeAuthIMSInfoNeeded {
    AdobeAuthIMSInfoNeededUnknownError("Unknown Error"),
    AdobeAuthIMSInfoNeededUsernameAndPassword("Username And Password Needed"),
    AdobeAuthIMSInfoNeededAgeVerification("Age Verification Needed"),
    AdobeAuthIMSInfoNeededTermsOfUse("Terms Of Use Needed"),
    AdobeAuthIMSInfoNeededEmailVerification("Email verification Needed"),
    AdobeAuthIMSInfoNeededMultipleInformation("Multiple Information Needed");

    private String description;

    AdobeAuthIMSInfoNeeded(String str) {
        this.description = str;
    }
}
