package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzb implements Parcelable.Creator<Contents> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Contents contents, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, contents.f1050a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) contents.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, contents.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, contents.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) contents.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, contents.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, contents.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Contents createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 6:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Contents[] newArray(int i) {
        return new Contents[i];
    }
}
