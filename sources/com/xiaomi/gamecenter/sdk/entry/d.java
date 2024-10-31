package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiAccountInfo createFromParcel(Parcel parcel) {
        MiAccountInfo miAccountInfo = new MiAccountInfo();
        miAccountInfo.uid = parcel.readLong();
        miAccountInfo.sessionId = parcel.readString();
        miAccountInfo.nikename = parcel.readString();
        return miAccountInfo;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MiAccountInfo[] newArray(int i) {
        return new MiAccountInfo[i];
    }
}
