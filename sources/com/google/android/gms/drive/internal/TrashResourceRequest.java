package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class TrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new zzbw();

    /* renamed from: a, reason: collision with root package name */
    final int f1124a;
    final DriveId b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrashResourceRequest(int i, DriveId driveId) {
        this.f1124a = i;
        this.b = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbw.a(this, parcel, i);
    }
}
