package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class zzn implements Parcelable.Creator<CreateFileRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, createFileRequest.f1085a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) createFileRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) createFileRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) createFileRequest.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, createFileRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, createFileRequest.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, createFileRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, createFileRequest.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, createFileRequest.i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFileRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
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
                    num = com.google.android.gms.common.internal.safeparcel.zza.h(parcel, a2);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 9:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFileRequest[] newArray(int i) {
        return new CreateFileRequest[i];
    }
}
