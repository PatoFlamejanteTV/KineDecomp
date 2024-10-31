package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class zzbk implements Parcelable.Creator<OpenContentsRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, openContentsRequest.f1114a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) openContentsRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, openContentsRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, openContentsRequest.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int g;
        int i;
        DriveId driveId;
        int i2;
        int i3 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    g = i3;
                    i = i7;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i5;
                    int i8 = i3;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i8;
                    break;
                case 4:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            driveId2 = driveId;
            i4 = i;
            i3 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OpenContentsRequest(i5, driveId2, i4, i3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
