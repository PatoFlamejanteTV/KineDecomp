package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<TimeInterval> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TimeInterval timeInterval, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, timeInterval.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, timeInterval.f2321a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, timeInterval.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TimeInterval createFromParcel(Parcel parcel) {
        long j = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
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
        return new TimeInterval(i, j2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TimeInterval[] newArray(int i) {
        return new TimeInterval[i];
    }
}
