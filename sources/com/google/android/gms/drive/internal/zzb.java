package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

/* loaded from: classes2.dex */
public class zzb implements Parcelable.Creator<AddPermissionRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, addPermissionRequest.f1075a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) addPermissionRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) addPermissionRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, addPermissionRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, addPermissionRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, addPermissionRequest.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, addPermissionRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddPermissionRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        String str2 = null;
        boolean z2 = false;
        Permission permission = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 3:
                    permission = (Permission) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Permission.CREATOR);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
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
        return new AddPermissionRequest(i, driveId, permission, z2, str2, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddPermissionRequest[] newArray(int i) {
        return new AddPermissionRequest[i];
    }
}
