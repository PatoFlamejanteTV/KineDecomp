package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class ControlProgressRequest implements SafeParcelable {
    public static final Parcelable.Creator<ControlProgressRequest> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    final int f1082a;
    final int b;
    final int c;
    final DriveId d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ControlProgressRequest(int i, int i2, int i3, DriveId driveId) {
        this.f1082a = i;
        this.b = i2;
        this.c = i3;
        this.d = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.a(this, parcel, i);
    }
}
