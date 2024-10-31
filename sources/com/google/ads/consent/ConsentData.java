package com.google.ads.consent;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;

/* loaded from: classes.dex */
class ConsentData {
    private static final String SDK_PLATFORM = "android";
    private static final String SDK_VERSION = "1.0.7";

    @SerializedName("consent_source")
    private String consentSource;

    @SerializedName("providers")
    private HashSet<AdProvider> adProviders = new HashSet<>();

    @SerializedName("consented_providers")
    private HashSet<AdProvider> consentedAdProviders = new HashSet<>();

    @SerializedName("pub_ids")
    private HashSet<String> publisherIds = new HashSet<>();

    @SerializedName("tag_for_under_age_of_consent")
    private Boolean underAgeOfConsent = false;

    @SerializedName("consent_state")
    private ConsentStatus consentStatus = ConsentStatus.UNKNOWN;

    @SerializedName("is_request_in_eea_or_unknown")
    private boolean isRequestLocationInEeaOrUnknown = false;

    @SerializedName("has_any_npa_pub_id")
    private boolean hasNonPersonalizedPublisherId = false;

    @SerializedName(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)
    private final String sdkVersionString = SDK_VERSION;

    @SerializedName("plat")
    private final String sdkPlatformString = "android";

    @SerializedName("raw_response")
    private String rawResponse = "";

    public HashSet<AdProvider> a() {
        return this.adProviders;
    }

    public ConsentStatus b() {
        return this.consentStatus;
    }

    public void c(HashSet<String> hashSet) {
        this.publisherIds = hashSet;
    }

    public String d() {
        return this.sdkPlatformString;
    }

    public String e() {
        return this.sdkVersionString;
    }

    public boolean f() {
        return this.hasNonPersonalizedPublisherId;
    }

    public boolean g() {
        return this.isRequestLocationInEeaOrUnknown;
    }

    public void a(HashSet<AdProvider> hashSet) {
        this.adProviders = hashSet;
    }

    public void b(boolean z) {
        this.isRequestLocationInEeaOrUnknown = z;
    }

    public HashSet<AdProvider> c() {
        return this.consentedAdProviders;
    }

    public void a(ConsentStatus consentStatus) {
        this.consentStatus = consentStatus;
    }

    public void b(HashSet<AdProvider> hashSet) {
        this.consentedAdProviders = hashSet;
    }

    public void a(boolean z) {
        this.hasNonPersonalizedPublisherId = z;
    }

    public void b(String str) {
        this.rawResponse = str;
    }

    public void a(String str) {
        this.consentSource = str;
    }
}
