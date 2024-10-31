package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class DriveServiceResponse implements SafeParcelable {
    public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzad();

    /* renamed from: a, reason: collision with root package name */
    final int f1089a;
    final IBinder b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriveServiceResponse(int i, IBinder iBinder) {
        this.f1089a = i;
        this.b = iBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.a(this, parcel, i);
    }
}
