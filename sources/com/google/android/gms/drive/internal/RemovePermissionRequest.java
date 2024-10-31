package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class RemovePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemovePermissionRequest> CREATOR = new zzbp();

    /* renamed from: a, reason: collision with root package name */
    final int f1118a;
    final DriveId b;
    final String c;
    final boolean d;
    final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemovePermissionRequest(int i, DriveId driveId, String str, boolean z, String str2) {
        this.f1118a = i;
        this.b = driveId;
        this.c = str;
        this.d = z;
        this.e = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbp.a(this, parcel, i);
    }
}
