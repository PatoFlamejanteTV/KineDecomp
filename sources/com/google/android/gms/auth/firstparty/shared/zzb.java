package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<FACLData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FACLData fACLData, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, fACLData.f815a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) fACLData.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, fACLData.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, fACLData.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, fACLData.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FACLData createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        FACLConfig fACLConfig = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    fACLConfig = (FACLConfig) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FACLConfig.CREATOR);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FACLData(i, fACLConfig, str2, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FACLData[] newArray(int i) {
        return new FACLData[i];
    }
}
