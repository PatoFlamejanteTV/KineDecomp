package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class zzca implements Parcelable.Creator<UpdatePermissionRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, updatePermissionRequest.f1128a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) updatePermissionRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, updatePermissionRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, updatePermissionRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, updatePermissionRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, updatePermissionRequest.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdatePermissionRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
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
        return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdatePermissionRequest[] newArray(int i) {
        return new UpdatePermissionRequest[i];
    }
}
