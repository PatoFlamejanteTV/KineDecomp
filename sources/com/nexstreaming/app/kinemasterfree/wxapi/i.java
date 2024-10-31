package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WxPayInfo.java */
/* loaded from: classes.dex */
final class i implements Parcelable.Creator<WxPayInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WxPayInfo createFromParcel(Parcel parcel) {
        return new WxPayInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WxPayInfo[] newArray(int i) {
        return new WxPayInfo[i];
    }
}
