package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PendingCallback implements Parcelable {
    public static final Parcelable.Creator<PendingCallback> CREATOR = new e();

    /* renamed from: a, reason: collision with root package name */
    final IBinder f1408a;

    public PendingCallback(Parcel parcel) {
        this.f1408a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f1408a);
    }
}
