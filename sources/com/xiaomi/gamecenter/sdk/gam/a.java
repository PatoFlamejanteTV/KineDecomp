package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GamMetaInfo createFromParcel(Parcel parcel) {
        GamMetaInfo gamMetaInfo = new GamMetaInfo();
        gamMetaInfo.os = parcel.readString();
        gamMetaInfo.executeurl = parcel.readString();
        return gamMetaInfo;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GamMetaInfo[] newArray(int i) {
        return new GamMetaInfo[i];
    }
}
