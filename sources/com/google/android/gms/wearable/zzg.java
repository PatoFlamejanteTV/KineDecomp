package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<ConnectionConfiguration> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, connectionConfiguration.f2325a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, connectionConfiguration.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, connectionConfiguration.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, connectionConfiguration.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, connectionConfiguration.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, connectionConfiguration.i());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, connectionConfiguration.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, connectionConfiguration.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, connectionConfiguration.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, connectionConfiguration.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionConfiguration createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
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
        return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionConfiguration[] newArray(int i) {
        return new ConnectionConfiguration[i];
    }
}
