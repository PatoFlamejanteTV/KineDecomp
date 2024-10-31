package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzp implements Parcelable.Creator<ParcelableChangeInfo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ParcelableChangeInfo parcelableChangeInfo, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, parcelableChangeInfo.f1173a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, parcelableChangeInfo.b);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, parcelableChangeInfo.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableChangeInfo createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        ArrayList arrayList = null;
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
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ParcelableEvent.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ParcelableChangeInfo(i, j, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableChangeInfo[] newArray(int i) {
        return new ParcelableChangeInfo[i];
    }
}
