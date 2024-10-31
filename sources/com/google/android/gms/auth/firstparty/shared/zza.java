package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<FACLConfig> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FACLConfig fACLConfig, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, fACLConfig.f814a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, fACLConfig.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, fACLConfig.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, fACLConfig.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, fACLConfig.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, fACLConfig.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, fACLConfig.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FACLConfig createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
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
        return new FACLConfig(i, z5, str, z4, z3, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FACLConfig[] newArray(int i) {
        return new FACLConfig[i];
    }
}
