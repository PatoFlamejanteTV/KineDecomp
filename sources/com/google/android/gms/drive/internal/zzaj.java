package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class zzaj implements Parcelable.Creator<GetMetadataRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getMetadataRequest.f1094a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) getMetadataRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getMetadataRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetMetadataRequest createFromParcel(Parcel parcel) {
        boolean c;
        DriveId driveId;
        int i;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    boolean z2 = z;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = z2;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    i = i2;
                    c = z;
                    driveId = driveId3;
                    break;
                case 3:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = z;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            z = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetMetadataRequest(i2, driveId2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetMetadataRequest[] newArray(int i) {
        return new GetMetadataRequest[i];
    }
}
