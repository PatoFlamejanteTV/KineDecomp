package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FacebookLiteLoginMethodHandler.java */
/* loaded from: classes.dex */
class l implements Parcelable.Creator<m> {
    @Override // android.os.Parcelable.Creator
    public m createFromParcel(Parcel parcel) {
        return new m(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public m[] newArray(int i) {
        return new m[i];
    }
}
