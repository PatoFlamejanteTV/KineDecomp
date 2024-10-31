package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

/* loaded from: classes2.dex */
public class AddEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1074a;
    final DriveId b;
    final int c;
    final ChangesAvailableOptions d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddEventListenerRequest(int i, DriveId driveId, int i2, ChangesAvailableOptions changesAvailableOptions) {
        this.f1074a = i;
        this.b = driveId;
        this.c = i2;
        this.d = changesAvailableOptions;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
