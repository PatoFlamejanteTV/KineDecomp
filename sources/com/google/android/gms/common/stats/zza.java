package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ConnectionEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, connectionEvent.f1038a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, connectionEvent.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, connectionEvent.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, connectionEvent.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, connectionEvent.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, connectionEvent.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, connectionEvent.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, connectionEvent.k());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, connectionEvent.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, connectionEvent.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, connectionEvent.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
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
                case 9:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
