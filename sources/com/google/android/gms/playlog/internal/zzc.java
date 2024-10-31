package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<LogEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LogEvent logEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, logEvent.f2144a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, logEvent.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, logEvent.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, logEvent.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, logEvent.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, logEvent.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LogEvent createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new LogEvent(i, j2, j, str, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LogEvent[] newArray(int i) {
        return new LogEvent[i];
    }
}
