package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzl implements Parcelable.Creator<InterstitialAdParameterParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, interstitialAdParameterParcel.f529a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, interstitialAdParameterParcel.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, interstitialAdParameterParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, interstitialAdParameterParcel.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, interstitialAdParameterParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, interstitialAdParameterParcel.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new InterstitialAdParameterParcel(i, z3, z2, str, z, f);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
