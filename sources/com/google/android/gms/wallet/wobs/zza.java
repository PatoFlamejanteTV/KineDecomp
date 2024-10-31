package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<CommonWalletObject> {
    public static void a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, commonWalletObject.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, commonWalletObject.f2314a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, commonWalletObject.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, commonWalletObject.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, commonWalletObject.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, commonWalletObject.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, commonWalletObject.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, commonWalletObject.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, commonWalletObject.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, commonWalletObject.i);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 11, commonWalletObject.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable) commonWalletObject.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 13, commonWalletObject.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, commonWalletObject.m, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, commonWalletObject.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, commonWalletObject.p);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 16, commonWalletObject.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 19, commonWalletObject.r, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 18, commonWalletObject.q, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 20, commonWalletObject.s, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CommonWalletObject createFromParcel(Parcel parcel) {
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
        int i2 = 0;
        ArrayList zzqs = zzmj.zzqs();
        TimeInterval timeInterval = null;
        ArrayList zzqs2 = zzmj.zzqs();
        String str9 = null;
        String str10 = null;
        ArrayList zzqs3 = zzmj.zzqs();
        boolean z = false;
        ArrayList zzqs4 = zzmj.zzqs();
        ArrayList zzqs5 = zzmj.zzqs();
        ArrayList zzqs6 = zzmj.zzqs();
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
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 11:
                    zzqs = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TimeInterval.CREATOR);
                    break;
                case 13:
                    zzqs2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 16:
                    zzqs3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 18:
                    zzqs4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UriData.CREATOR);
                    break;
                case 19:
                    zzqs5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, TextModuleData.CREATOR);
                    break;
                case 20:
                    zzqs6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, zzqs, timeInterval, zzqs2, str9, str10, zzqs3, z, zzqs4, zzqs5, zzqs6);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
