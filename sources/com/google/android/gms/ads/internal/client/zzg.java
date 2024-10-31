package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<AdRequestParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adRequestParcel.f533a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, adRequestParcel.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, adRequestParcel.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, adRequestParcel.d);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 5, adRequestParcel.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, adRequestParcel.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, adRequestParcel.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, adRequestParcel.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, adRequestParcel.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, (Parcelable) adRequestParcel.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) adRequestParcel.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, adRequestParcel.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, adRequestParcel.m, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, adRequestParcel.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 15, adRequestParcel.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, adRequestParcel.q, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, adRequestParcel.p, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Location.CREATOR);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 13:
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 14:
                    bundle3 = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 15:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 16:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 17:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdRequestParcel(i, j, bundle, i2, arrayList, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, arrayList2, str3, str4);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdRequestParcel[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
