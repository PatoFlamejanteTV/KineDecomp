package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzbs implements Parcelable.Creator<SetResourceParentsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, setResourceParentsRequest.f1121a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) setResourceParentsRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, setResourceParentsRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        ArrayList c;
        DriveId driveId;
        int i;
        ArrayList arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    ArrayList arrayList2 = arrayList;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = arrayList2;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    i = i2;
                    c = arrayList;
                    driveId = driveId3;
                    break;
                case 3:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveId.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = arrayList;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            arrayList = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SetResourceParentsRequest(i2, driveId2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
