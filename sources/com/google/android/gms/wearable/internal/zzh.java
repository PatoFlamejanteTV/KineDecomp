package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<AncsNotificationParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, ancsNotificationParcelable.f2333a);
        zzb.a(parcel, 2, ancsNotificationParcelable.a());
        zzb.a(parcel, 3, ancsNotificationParcelable.b(), false);
        zzb.a(parcel, 4, ancsNotificationParcelable.c(), false);
        zzb.a(parcel, 5, ancsNotificationParcelable.d(), false);
        zzb.a(parcel, 6, ancsNotificationParcelable.e(), false);
        zzb.a(parcel, 7, ancsNotificationParcelable.f(), false);
        zzb.a(parcel, 8, ancsNotificationParcelable.g(), false);
        zzb.a(parcel, 9, ancsNotificationParcelable.h());
        zzb.a(parcel, 10, ancsNotificationParcelable.i());
        zzb.a(parcel, 11, ancsNotificationParcelable.j());
        zzb.a(parcel, 12, ancsNotificationParcelable.k());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AncsNotificationParcelable createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 10:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 11:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case 12:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AncsNotificationParcelable(i, i2, str, str2, str3, str4, str5, str6, b2, b3, b4, b5);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AncsNotificationParcelable[] newArray(int i) {
        return new AncsNotificationParcelable[i];
    }
}
