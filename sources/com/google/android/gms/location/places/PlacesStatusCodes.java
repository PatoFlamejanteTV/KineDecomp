package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class PlacesStatusCodes extends CommonStatusCodes {
    private PlacesStatusCodes() {
    }

    public static Status a(int i, String str) {
        zzx.a(str);
        return new Status(i, str);
    }

    public static String b(int i) {
        switch (i) {
            case 9000:
                return "PLACES_API_QUOTA_FAILED";
            case 9001:
                return "PLACES_API_USAGE_LIMIT_EXCEEDED";
            case 9002:
                return "PLACES_API_KEY_INVALID";
            case 9003:
                return "PLACES_API_ACCESS_NOT_CONFIGURED";
            case 9004:
                return "PLACES_API_INVALID_ARGUMENT";
            case 9005:
                return "PLACES_API_RATE_LIMIT_EXCEEDED";
            case 9006:
                return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
            case 9007:
                return "PLACES_API_KEY_EXPIRED";
            case 9008:
                return "PLACES_API_INVALID_APP";
            case 9101:
                return "PLACE_PROXIMITY_UNKNOWN";
            case 9102:
                return "NEARBY_ALERTS_NOT_AVAILABLE";
            default:
                return CommonStatusCodes.a(i);
        }
    }

    public static Status c(int i) {
        return a(i, b(i));
    }
}
