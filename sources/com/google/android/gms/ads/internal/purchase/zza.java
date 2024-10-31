package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, gInAppPurchaseManagerInfoParcel.f608a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, gInAppPurchaseManagerInfoParcel.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, gInAppPurchaseManagerInfoParcel.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, gInAppPurchaseManagerInfoParcel.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, gInAppPurchaseManagerInfoParcel.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GInAppPurchaseManagerInfoParcel createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 3:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GInAppPurchaseManagerInfoParcel[] newArray(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }
}
