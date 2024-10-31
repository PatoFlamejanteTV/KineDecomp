package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DrivePreferences;

/* loaded from: classes2.dex */
public class zzbq implements Parcelable.Creator<SetDrivePreferencesRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, setDrivePreferencesRequest.f1119a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) setDrivePreferencesRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SetDrivePreferencesRequest createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DrivePreferences.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SetDrivePreferencesRequest(i, drivePreferences);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SetDrivePreferencesRequest[] newArray(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
