package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiBuyInfoOnline createFromParcel(Parcel parcel) {
        MiBuyInfoOnline miBuyInfoOnline = new MiBuyInfoOnline();
        miBuyInfoOnline.setCpOrderId(parcel.readString());
        miBuyInfoOnline.setMiBi(parcel.readInt());
        miBuyInfoOnline.setCpUserInfo(parcel.readString());
        return miBuyInfoOnline;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiBuyInfoOnline[] newArray(int i) {
        return new MiBuyInfoOnline[i];
    }
}
