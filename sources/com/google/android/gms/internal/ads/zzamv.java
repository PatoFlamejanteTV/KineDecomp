package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzamv {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = C1175zb.f12697b[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zzwb zzwbVar, boolean z) {
        AdRequest.Gender gender;
        List<String> list = zzwbVar.zzcjd;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzwbVar.zzcjb);
        int i = zzwbVar.zzcjc;
        if (i == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzwbVar.zzcjj);
    }
}
