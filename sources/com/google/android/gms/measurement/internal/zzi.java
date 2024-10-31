package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<EventParams> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(EventParams eventParams, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, eventParams.f2019a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, eventParams.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventParams createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    bundle = zza.r(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new EventParams(i, bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventParams[] newArray(int i) {
        return new EventParams[i];
    }
}
