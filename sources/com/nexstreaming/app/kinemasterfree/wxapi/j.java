package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WxPayInfo.java */
/* loaded from: classes2.dex */
class j implements Parcelable.Creator<WxPayInfo> {
    @Override // android.os.Parcelable.Creator
    public WxPayInfo createFromParcel(Parcel parcel) {
        return new WxPayInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public WxPayInfo[] newArray(int i) {
        return new WxPayInfo[i];
    }
}
