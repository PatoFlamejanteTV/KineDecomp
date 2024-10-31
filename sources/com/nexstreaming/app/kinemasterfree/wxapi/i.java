package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WXUserInfo.java */
/* loaded from: classes2.dex */
class i implements Parcelable.Creator<WXUserInfo> {
    @Override // android.os.Parcelable.Creator
    public WXUserInfo createFromParcel(Parcel parcel) {
        return new WXUserInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public WXUserInfo[] newArray(int i) {
        return new WXUserInfo[i];
    }
}
