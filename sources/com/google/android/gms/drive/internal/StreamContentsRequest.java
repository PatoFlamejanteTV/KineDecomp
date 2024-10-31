package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class StreamContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<StreamContentsRequest> CREATOR = new zzbu();

    /* renamed from: a, reason: collision with root package name */
    final int f1122a;
    final DriveId b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamContentsRequest(int i, DriveId driveId) {
        this.f1122a = i;
        this.b = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbu.a(this, parcel, i);
    }
}
