package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiBuyInfo createFromParcel(Parcel parcel) {
        MiBuyInfo miBuyInfo = new MiBuyInfo();
        miBuyInfo.miBuyInfoVersion = parcel.readInt();
        miBuyInfo.setCpOrderId(parcel.readString());
        miBuyInfo.setProductCode(parcel.readString());
        miBuyInfo.setCount(parcel.readInt());
        miBuyInfo.setCpUserInfo(parcel.readString());
        miBuyInfo.setAmount(parcel.readInt());
        miBuyInfo.setExtraInfo(parcel.readBundle());
        return miBuyInfo;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiBuyInfo[] newArray(int i) {
        return new MiBuyInfo[i];
    }
}
