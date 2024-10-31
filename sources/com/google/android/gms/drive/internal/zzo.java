package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class zzo implements Parcelable.Creator<CreateFolderRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, createFolderRequest.f1086a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) createFolderRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) createFolderRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFolderRequest createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        DriveId driveId;
        int i;
        MetadataBundle metadataBundle2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    metadataBundle = metadataBundle3;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    i = i2;
                    metadataBundle = metadataBundle2;
                    driveId = driveId3;
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MetadataBundle.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CreateFolderRequest(i2, driveId2, metadataBundle2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFolderRequest[] newArray(int i) {
        return new CreateFolderRequest[i];
    }
}
