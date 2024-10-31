package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<AdResponseParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, adResponseParcel.f622a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, adResponseParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, adResponseParcel.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 4, adResponseParcel.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, adResponseParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 6, adResponseParcel.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, adResponseParcel.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, adResponseParcel.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, adResponseParcel.i);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 10, adResponseParcel.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, adResponseParcel.k);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, adResponseParcel.l);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, adResponseParcel.m, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, adResponseParcel.n);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, adResponseParcel.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 19, adResponseParcel.q, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, adResponseParcel.p);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 21, adResponseParcel.r, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 23, adResponseParcel.t);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 22, adResponseParcel.s);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 25, adResponseParcel.v);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 24, adResponseParcel.u);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 27, adResponseParcel.x);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 26, adResponseParcel.w);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 29, adResponseParcel.z, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 28, (Parcelable) adResponseParcel.y, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 31, adResponseParcel.B);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 30, adResponseParcel.A, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdResponseParcel createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        ArrayList<String> arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList<String> arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
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
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 7:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 9:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 13:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 14:
                    j4 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 15:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 16:
                case 17:
                case 20:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 18:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 19:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 21:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 22:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 23:
                    z4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 24:
                    z5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 25:
                    z6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 26:
                    z7 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 27:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 30:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 31:
                    z8 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AdResponseParcel(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AdResponseParcel[] newArray(int i) {
        return new AdResponseParcel[i];
    }
}
