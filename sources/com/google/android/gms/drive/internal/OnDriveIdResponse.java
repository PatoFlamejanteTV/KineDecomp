package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class OnDriveIdResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDriveIdResponse> CREATOR = new zzaz();

    /* renamed from: a, reason: collision with root package name */
    final int f1103a;
    DriveId b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnDriveIdResponse(int i, DriveId driveId) {
        this.f1103a = i;
        this.b = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaz.a(this, parcel, i);
    }
}
