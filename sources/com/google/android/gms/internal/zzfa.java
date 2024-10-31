package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;

@zzgr
/* loaded from: classes.dex */
public final class zzfa {

    /* renamed from: com.google.android.gms.internal.zzfa$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1712a;

        static {
            try {
                b[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f1712a = new int[AdRequest.Gender.values().length];
            try {
                f1712a[AdRequest.Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1712a[AdRequest.Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f1712a[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int zza(AdRequest.ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(AdSizeParcel adSizeParcel) {
        AdSize[] adSizeArr = {AdSize.f501a, AdSize.b, AdSize.c, AdSize.d, AdSize.e, AdSize.f};
        for (int i = 0; i < adSizeArr.length; i++) {
            if (adSizeArr[i].a() == adSizeParcel.f && adSizeArr[i].b() == adSizeParcel.c) {
                return adSizeArr[i];
            }
        }
        return new AdSize(com.google.android.gms.ads.zza.a(adSizeParcel.f, adSizeParcel.c, adSizeParcel.b));
    }

    public static MediationAdRequest zzh(AdRequestParcel adRequestParcel) {
        return new MediationAdRequest(new Date(adRequestParcel.b), zzr(adRequestParcel.d), adRequestParcel.e != null ? new HashSet(adRequestParcel.e) : null, adRequestParcel.f, adRequestParcel.k);
    }

    public static AdRequest.Gender zzr(int i) {
        switch (i) {
            case 1:
                return AdRequest.Gender.MALE;
            case 2:
                return AdRequest.Gender.FEMALE;
            default:
                return AdRequest.Gender.UNKNOWN;
        }
    }
}
