package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WebViewLoginMethodHandler.java */
/* loaded from: classes.dex */
class J implements Parcelable.Creator<K> {
    @Override // android.os.Parcelable.Creator
    public K createFromParcel(Parcel parcel) {
        return new K(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public K[] newArray(int i) {
        return new K[i];
    }
}
