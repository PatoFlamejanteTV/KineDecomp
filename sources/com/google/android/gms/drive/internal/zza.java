package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

/* loaded from: classes2.dex */
public class zza implements Parcelable.Creator<AddEventListenerRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, addEventListenerRequest.f1074a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) addEventListenerRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, addEventListenerRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) addEventListenerRequest.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddEventListenerRequest createFromParcel(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions;
        int i;
        DriveId driveId;
        int i2;
        ChangesAvailableOptions changesAvailableOptions2 = null;
        int i3 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    ChangesAvailableOptions changesAvailableOptions3 = changesAvailableOptions2;
                    i = i3;
                    driveId = driveId2;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    changesAvailableOptions = changesAvailableOptions3;
                    break;
                case 2:
                    i2 = i4;
                    int i5 = i3;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    changesAvailableOptions = changesAvailableOptions2;
                    i = i5;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i4;
                    ChangesAvailableOptions changesAvailableOptions4 = changesAvailableOptions2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    changesAvailableOptions = changesAvailableOptions4;
                    break;
                case 4:
                    changesAvailableOptions = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangesAvailableOptions.CREATOR);
                    i = i3;
                    driveId = driveId2;
                    i2 = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    changesAvailableOptions = changesAvailableOptions2;
                    i = i3;
                    driveId = driveId2;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            driveId2 = driveId;
            i3 = i;
            changesAvailableOptions2 = changesAvailableOptions;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AddEventListenerRequest(i4, driveId2, i3, changesAvailableOptions2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddEventListenerRequest[] newArray(int i) {
        return new AddEventListenerRequest[i];
    }
}
