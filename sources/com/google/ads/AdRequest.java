package com.google.ads;

@Deprecated
/* loaded from: classes.dex */
public final class AdRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final String f500a = com.google.android.gms.ads.AdRequest.f514a;

    /* loaded from: classes.dex */
    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");

        private final String description;

        ErrorCode(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* loaded from: classes.dex */
    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    private AdRequest() {
    }
}
