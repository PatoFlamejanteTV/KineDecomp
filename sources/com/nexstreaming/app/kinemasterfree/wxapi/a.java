package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WXAccessToken.java */
/* loaded from: classes2.dex */
class a implements Parcelable.Creator<WXAccessToken> {
    @Override // android.os.Parcelable.Creator
    public WXAccessToken createFromParcel(Parcel parcel) {
        return new WXAccessToken(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public WXAccessToken[] newArray(int i) {
        return new WXAccessToken[i];
    }
}
