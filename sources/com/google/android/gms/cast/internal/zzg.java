package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<DeviceStatus> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, deviceStatus.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, deviceStatus.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, deviceStatus.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, deviceStatus.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) deviceStatus.f(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, deviceStatus.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DeviceStatus createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ApplicationMetadata.CREATOR);
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
        return new DeviceStatus(i3, d, z, i2, applicationMetadata, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DeviceStatus[] newArray(int i) {
        return new DeviceStatus[i];
    }
}
