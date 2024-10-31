package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<AppMetadata> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, appMetadata.f2018a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, appMetadata.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, appMetadata.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, appMetadata.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, appMetadata.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, appMetadata.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, appMetadata.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppMetadata createFromParcel(Parcel parcel) {
        long j = 0;
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        long j2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    str4 = zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = zza.p(parcel, a2);
                    break;
                case 5:
                    str = zza.p(parcel, a2);
                    break;
                case 6:
                    j2 = zza.i(parcel, a2);
                    break;
                case 7:
                    j = zza.i(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AppMetadata(i, str4, str3, str2, str, j2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
