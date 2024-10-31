package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzd implements Parcelable.Creator<ParcelableEventList> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, parcelableEventList.f1179a);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, parcelableEventList.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) parcelableEventList.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, parcelableEventList.d);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 5, parcelableEventList.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) parcelableEventList.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        boolean z = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList<String> arrayList = null;
        DataHolder dataHolder = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ParcelableEventList(i, arrayList2, dataHolder, z, arrayList, parcelableChangeInfo);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
