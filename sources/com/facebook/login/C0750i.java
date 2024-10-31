package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.DeviceAuthDialog;

/* compiled from: DeviceAuthDialog.java */
/* renamed from: com.facebook.login.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0750i implements Parcelable.Creator<DeviceAuthDialog.a> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DeviceAuthDialog.a createFromParcel(Parcel parcel) {
        return new DeviceAuthDialog.a(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public DeviceAuthDialog.a[] newArray(int i) {
        return new DeviceAuthDialog.a[i];
    }
}
