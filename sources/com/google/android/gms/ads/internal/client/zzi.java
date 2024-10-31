package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<AdSizeParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adSizeParcel.f534a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, adSizeParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, adSizeParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, adSizeParcel.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, adSizeParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, adSizeParcel.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, adSizeParcel.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable[]) adSizeParcel.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, adSizeParcel.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, adSizeParcel.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdSizeParcel createFromParcel(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdSizeParcel(i5, str, i4, i3, z3, i2, i, adSizeParcelArr, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdSizeParcel[] newArray(int i) {
        return new AdSizeParcel[i];
    }
}
