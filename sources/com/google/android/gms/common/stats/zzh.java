package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<WakeLockEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, wakeLockEvent.f1039a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, wakeLockEvent.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, wakeLockEvent.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, wakeLockEvent.e());
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 6, wakeLockEvent.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, wakeLockEvent.h());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, wakeLockEvent.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, wakeLockEvent.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, wakeLockEvent.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, wakeLockEvent.k(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, wakeLockEvent.j());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, wakeLockEvent.m());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, wakeLockEvent.n());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        ArrayList<String> arrayList = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
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
                case 7:
                case 9:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 6:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 8:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 10:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 11:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 12:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 14:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 15:
                    f = com.google.android.gms.common.internal.safeparcel.zza.l(parcel, a2);
                    break;
                case 16:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
