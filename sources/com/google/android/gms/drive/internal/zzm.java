package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class zzm implements Parcelable.Creator<CreateFileIntentSenderRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, createFileIntentSenderRequest.f1084a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) createFileIntentSenderRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, createFileIntentSenderRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, createFileIntentSenderRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) createFileIntentSenderRequest.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, createFileIntentSenderRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 6:
                    num = com.google.android.gms.common.internal.safeparcel.zza.h(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
