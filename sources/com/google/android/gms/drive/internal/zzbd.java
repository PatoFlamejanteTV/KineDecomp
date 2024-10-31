package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzbd implements Parcelable.Creator<OnListEntriesResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onListEntriesResponse.f1107a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) onListEntriesResponse.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, onListEntriesResponse.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean c;
        DataHolder dataHolder;
        int i;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataHolder dataHolder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    boolean z2 = z;
                    dataHolder = dataHolder2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = z2;
                    break;
                case 2:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    i = i2;
                    c = z;
                    dataHolder = dataHolder3;
                    break;
                case 3:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = z;
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataHolder2 = dataHolder;
            z = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnListEntriesResponse(i2, dataHolder2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
