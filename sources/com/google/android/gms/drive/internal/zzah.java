package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzah implements Parcelable.Creator<GetChangesRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getChangesRequest.f1092a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) getChangesRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getChangesRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, getChangesRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, getChangesRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetChangesRequest createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    changeSequenceNumber = (ChangeSequenceNumber) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangeSequenceNumber.CREATOR);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveSpace.CREATOR);
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
        return new GetChangesRequest(i2, changeSequenceNumber, i, arrayList, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetChangesRequest[] newArray(int i) {
        return new GetChangesRequest[i];
    }
}
