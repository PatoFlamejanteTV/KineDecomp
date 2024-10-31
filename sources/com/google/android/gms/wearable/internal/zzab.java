package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzab implements Parcelable.Creator<DataItemAssetParcelable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, dataItemAssetParcelable.f2340a);
        zzb.a(parcel, 2, dataItemAssetParcelable.b(), false);
        zzb.a(parcel, 3, dataItemAssetParcelable.c(), false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataItemAssetParcelable createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new DataItemAssetParcelable(i, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DataItemAssetParcelable[] newArray(int i) {
        return new DataItemAssetParcelable[i];
    }
}
