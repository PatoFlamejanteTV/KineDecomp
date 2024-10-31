package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzj implements Parcelable.Creator<EventParcel> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(EventParcel eventParcel, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, eventParcel.f2020a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, eventParcel.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) eventParcel.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, eventParcel.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, eventParcel.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventParcel createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    i = zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = zza.p(parcel, a2);
                    break;
                case 3:
                    eventParams = (EventParams) zza.a(parcel, a2, EventParams.CREATOR);
                    break;
                case 4:
                    str = zza.p(parcel, a2);
                    break;
                case 5:
                    j = zza.i(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new EventParcel(i, str2, eventParams, str, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EventParcel[] newArray(int i) {
        return new EventParcel[i];
    }
}
