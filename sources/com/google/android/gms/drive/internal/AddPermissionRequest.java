package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

/* loaded from: classes2.dex */
public class AddPermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1075a;
    final DriveId b;
    final Permission c;
    final boolean d;
    final String e;
    final boolean f;
    final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddPermissionRequest(int i, DriveId driveId, Permission permission, boolean z, String str, boolean z2, String str2) {
        this.f1075a = i;
        this.b = driveId;
        this.c = permission;
        this.d = z;
        this.e = str;
        this.f = z2;
        this.g = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
