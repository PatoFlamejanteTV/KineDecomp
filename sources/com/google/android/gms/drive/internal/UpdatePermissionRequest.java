package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class UpdatePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzca();

    /* renamed from: a, reason: collision with root package name */
    final int f1128a;
    final DriveId b;
    final String c;
    final int d;
    final boolean e;
    final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdatePermissionRequest(int i, DriveId driveId, String str, int i2, boolean z, String str2) {
        this.f1128a = i;
        this.b = driveId;
        this.c = str;
        this.d = i2;
        this.e = z;
        this.f = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzca.a(this, parcel, i);
    }
}
