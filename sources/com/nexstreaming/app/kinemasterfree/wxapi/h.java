package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WXUserInfo.java */
/* loaded from: classes.dex */
final class h implements Parcelable.Creator<WXUserInfo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WXUserInfo createFromParcel(Parcel parcel) {
        return new WXUserInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WXUserInfo[] newArray(int i) {
        return new WXUserInfo[i];
    }
}
