package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiBuyInfoOffline createFromParcel(Parcel parcel) {
        MiBuyInfoOffline miBuyInfoOffline = new MiBuyInfoOffline();
        miBuyInfoOffline.setCpOrderId(parcel.readString());
        miBuyInfoOffline.setProductCode(parcel.readString());
        miBuyInfoOffline.setCount(parcel.readInt());
        return miBuyInfoOffline;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiBuyInfoOffline[] newArray(int i) {
        return new MiBuyInfoOffline[i];
    }
}
