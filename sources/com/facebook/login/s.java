package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: KatanaProxyLoginMethodHandler.java */
/* loaded from: classes.dex */
class s implements Parcelable.Creator<t> {
    @Override // android.os.Parcelable.Creator
    public t createFromParcel(Parcel parcel) {
        return new t(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public t[] newArray(int i) {
        return new t[i];
    }
}
