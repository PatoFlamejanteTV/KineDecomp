package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiliaoInfo createFromParcel(Parcel parcel) {
        MiliaoInfo miliaoInfo = new MiliaoInfo();
        miliaoInfo.appid = parcel.readString();
        miliaoInfo.gameid = parcel.readString();
        miliaoInfo.appname = parcel.readString();
        miliaoInfo.mlownerid = parcel.readString();
        miliaoInfo.mlownername = parcel.readString();
        miliaoInfo.mltitle = parcel.readString();
        miliaoInfo.mlcontent = parcel.readString();
        miliaoInfo.mlsourcename = parcel.readString();
        miliaoInfo.mlsourceurl = parcel.readString();
        miliaoInfo.mlaltmsg = parcel.readString();
        miliaoInfo.rootMiliaoInfo = parcel.readString();
        return miliaoInfo;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiliaoInfo[] newArray(int i) {
        return new MiliaoInfo[i];
    }
}
