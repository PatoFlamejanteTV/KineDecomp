package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<PlayLoggerContext> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, playLoggerContext.f2145a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, playLoggerContext.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, playLoggerContext.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, playLoggerContext.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, playLoggerContext.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, playLoggerContext.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, playLoggerContext.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, playLoggerContext.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, playLoggerContext.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, playLoggerContext.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 9:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 10:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
