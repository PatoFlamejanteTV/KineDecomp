package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzav implements Parcelable.Creator<OnChangesResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnChangesResponse onChangesResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onChangesResponse.f1099a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) onChangesResponse.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, onChangesResponse.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) onChangesResponse.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, onChangesResponse.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnChangesResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        ChangeSequenceNumber changeSequenceNumber = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveId.CREATOR);
                    break;
                case 4:
                    changeSequenceNumber = (ChangeSequenceNumber) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangeSequenceNumber.CREATOR);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnChangesResponse(i, dataHolder, arrayList, changeSequenceNumber, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnChangesResponse[] newArray(int i) {
        return new OnChangesResponse[i];
    }
}
