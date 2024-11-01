package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiGamMessageResponse createFromParcel(Parcel parcel) {
        MiGamMessageResponse miGamMessageResponse = new MiGamMessageResponse();
        miGamMessageResponse.index = parcel.readInt();
        miGamMessageResponse.sdkStatus = parcel.readInt();
        miGamMessageResponse.msgResult = parcel.readString();
        miGamMessageResponse.heartToken = parcel.readString();
        miGamMessageResponse.miliaoInfo = (MiliaoInfo) parcel.readParcelable(MiliaoInfo.class.getClassLoader());
        return miGamMessageResponse;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiGamMessageResponse[] newArray(int i) {
        return new MiGamMessageResponse[i];
    }
}
