package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbo();

    /* renamed from: a, reason: collision with root package name */
    final int f1117a;
    final DriveId b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoveEventListenerRequest(int i, DriveId driveId, int i2) {
        this.f1117a = i;
        this.b = driveId;
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbo.a(this, parcel, i);
    }
}
