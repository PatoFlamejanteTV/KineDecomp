package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class zza implements Parcelable.Creator<ChangeEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, changeEvent.f1067a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) changeEvent.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, changeEvent.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int g;
        DriveId driveId;
        int i;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    i = i3;
                    g = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    driveId = driveId2;
                    i = i3;
                    break;
            }
            i3 = i;
            driveId2 = driveId;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ChangeEvent(i3, driveId2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
