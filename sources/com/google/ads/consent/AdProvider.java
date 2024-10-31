package com.google.ads.consent;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class AdProvider {

    @SerializedName("company_id")
    private String id;

    @SerializedName("company_name")
    private String name;

    @SerializedName("policy_url")
    private String privacyPolicyUrlString;

    public String a() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdProvider.class != obj.getClass()) {
            return false;
        }
        AdProvider adProvider = (AdProvider) obj;
        return this.id.equals(adProvider.id) && this.name.equals(adProvider.name) && this.privacyPolicyUrlString.equals(adProvider.privacyPolicyUrlString);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.privacyPolicyUrlString.hashCode();
    }
}
