package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WXAccessToken.java */
/* loaded from: classes.dex */
final class a implements Parcelable.Creator<WXAccessToken> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WXAccessToken createFromParcel(Parcel parcel) {
        return new WXAccessToken(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WXAccessToken[] newArray(int i) {
        return new WXAccessToken[i];
    }
}
