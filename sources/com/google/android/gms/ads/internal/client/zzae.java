package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzae implements Parcelable.Creator<SearchAdRequestParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, searchAdRequestParcel.f535a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, searchAdRequestParcel.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, searchAdRequestParcel.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, searchAdRequestParcel.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, searchAdRequestParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, searchAdRequestParcel.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, searchAdRequestParcel.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, searchAdRequestParcel.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, searchAdRequestParcel.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, searchAdRequestParcel.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, searchAdRequestParcel.k);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, searchAdRequestParcel.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, searchAdRequestParcel.m);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, searchAdRequestParcel.n);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, searchAdRequestParcel.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchAdRequestParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 7:
                    i7 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    i8 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 9:
                    i9 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 10:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 11:
                    i10 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 13:
                    i11 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 14:
                    i12 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 15:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchAdRequestParcel[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
