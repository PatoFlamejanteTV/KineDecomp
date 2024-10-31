package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzaf implements Parcelable.Creator<UserAttributeParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, userAttributeParcel.f2021a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, userAttributeParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, userAttributeParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, userAttributeParcel.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, userAttributeParcel.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, userAttributeParcel.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, userAttributeParcel.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserAttributeParcel createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    str3 = zza.p(parcel, a2);
                    break;
                case 3:
                    j = zza.i(parcel, a2);
                    break;
                case 4:
                    l = zza.j(parcel, a2);
                    break;
                case 5:
                    f = zza.m(parcel, a2);
                    break;
                case 6:
                    str2 = zza.p(parcel, a2);
                    break;
                case 7:
                    str = zza.p(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new UserAttributeParcel(i, str3, j, l, f, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UserAttributeParcel[] newArray(int i) {
        return new UserAttributeParcel[i];
    }
}
