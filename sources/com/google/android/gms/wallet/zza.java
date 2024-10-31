package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<Address> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Address address, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, address.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, address.f2277a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, address.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, address.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, address.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, address.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, address.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, address.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, address.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, address.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, address.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, address.k, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Address createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        boolean z = false;
        String str10 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 12:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
