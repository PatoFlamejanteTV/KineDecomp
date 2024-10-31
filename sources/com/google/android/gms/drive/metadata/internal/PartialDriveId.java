package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class PartialDriveId implements SafeParcelable {
    public static final Parcelable.Creator<PartialDriveId> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    final int f1149a;
    final String b;
    final long c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PartialDriveId(int i, String str, long j, int i2) {
        this.f1149a = i;
        this.b = str;
        this.c = j;
        this.d = i2;
    }

    public PartialDriveId(String str, long j, int i) {
        this(1, str, j, i);
    }

    public DriveId a(long j) {
        return new DriveId(this.b, this.c, j, this.d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.a(this, parcel, i);
    }
}
