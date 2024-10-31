package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class zzh implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, closeContentsAndUpdateMetadataRequest.f1080a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, closeContentsAndUpdateMetadataRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, closeContentsAndUpdateMetadataRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, closeContentsAndUpdateMetadataRequest.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, closeContentsAndUpdateMetadataRequest.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, closeContentsAndUpdateMetadataRequest.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Contents.CREATOR);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 8:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 9:
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
        return new CloseContentsAndUpdateMetadataRequest(i3, driveId, metadataBundle, contents, z2, str, i2, i, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
