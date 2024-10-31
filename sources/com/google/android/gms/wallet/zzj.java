package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzj implements Parcelable.Creator<LoyaltyWalletObject> {
    public static void a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, loyaltyWalletObject.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, loyaltyWalletObject.f2286a, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, loyaltyWalletObject.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, loyaltyWalletObject.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, loyaltyWalletObject.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, loyaltyWalletObject.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, loyaltyWalletObject.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, loyaltyWalletObject.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, loyaltyWalletObject.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, loyaltyWalletObject.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, loyaltyWalletObject.j, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, loyaltyWalletObject.k);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 13, loyaltyWalletObject.l, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, (Parcelable) loyaltyWalletObject.m, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 15, loyaltyWalletObject.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, loyaltyWalletObject.p, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, loyaltyWalletObject.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 19, loyaltyWalletObject.r);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 18, loyaltyWalletObject.q, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 21, loyaltyWalletObject.t, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 20, loyaltyWalletObject.s, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 23, (Parcelable) loyaltyWalletObject.v, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 22, loyaltyWalletObject.u, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
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
        String str10 = null;
        int i2 = 0;
        ArrayList zzqs = zzmj.zzqs();
        TimeInterval timeInterval = null;
        ArrayList zzqs2 = zzmj.zzqs();
        String str11 = null;
        String str12 = null;
        ArrayList zzqs3 = zzmj.zzqs();
        boolean z = false;
        ArrayList zzqs4 = zzmj.zzqs();
        ArrayList zzqs5 = zzmj.zzqs();
        ArrayList zzqs6 = zzmj.zzqs();
        LoyaltyPoints loyaltyPoints = null;
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
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 13:
                    zzqs = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, WalletObjectMessage.CREATOR);
                    break;
                case 14:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TimeInterval.CREATOR);
                    break;
                case 15:
                    zzqs2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 17:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 18:
                    zzqs3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, LabelValueRow.CREATOR);
                    break;
                case 19:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 20:
                    zzqs4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UriData.CREATOR);
                    break;
                case 21:
                    zzqs5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, TextModuleData.CREATOR);
                    break;
                case 22:
                    zzqs6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UriData.CREATOR);
                    break;
                case 23:
                    loyaltyPoints = (LoyaltyPoints) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, LoyaltyPoints.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzqs, timeInterval, zzqs2, str11, str12, zzqs3, z, zzqs4, zzqs5, zzqs6, loyaltyPoints);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
