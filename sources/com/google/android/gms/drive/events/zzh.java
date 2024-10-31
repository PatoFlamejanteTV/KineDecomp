package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class zzh implements Parcelable.Creator<ProgressEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ProgressEvent progressEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, progressEvent.f1072a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) progressEvent.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, progressEvent.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, progressEvent.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, progressEvent.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, progressEvent.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProgressEvent createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
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
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 5:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 6:
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
        return new ProgressEvent(i3, driveId, i2, j2, j, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProgressEvent[] newArray(int i) {
        return new ProgressEvent[i];
    }
}
