package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzf implements Parcelable.Creator<ChangeResourceParentsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, changeResourceParentsRequest.f1078a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) changeResourceParentsRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 3, changeResourceParentsRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, changeResourceParentsRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeResourceParentsRequest createFromParcel(Parcel parcel) {
        ArrayList c;
        ArrayList arrayList;
        DriveId driveId;
        int i;
        ArrayList arrayList2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        ArrayList arrayList3 = null;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    ArrayList arrayList4 = arrayList2;
                    arrayList = arrayList3;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    c = arrayList4;
                    break;
                case 2:
                    i = i2;
                    ArrayList arrayList5 = arrayList3;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    c = arrayList2;
                    arrayList = arrayList5;
                    break;
                case 3:
                    driveId = driveId2;
                    i = i2;
                    ArrayList arrayList6 = arrayList2;
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveId.CREATOR);
                    c = arrayList6;
                    break;
                case 4:
                    c = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveId.CREATOR);
                    arrayList = arrayList3;
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    c = arrayList2;
                    arrayList = arrayList3;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            arrayList3 = arrayList;
            arrayList2 = c;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChangeResourceParentsRequest(i2, driveId2, arrayList3, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeResourceParentsRequest[] newArray(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
