package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiAppInfo createFromParcel(Parcel parcel) {
        MiAppInfo miAppInfo = new MiAppInfo();
        miAppInfo.appId = parcel.readInt();
        miAppInfo.appKey = parcel.readString();
        miAppInfo.appType = MiAppType.valueOf(parcel.readString());
        miAppInfo.cpMark = parcel.readString();
        miAppInfo.orientation = ScreenOrientation.valueOf(parcel.readString());
        miAppInfo.weakAccount = Boolean.getBoolean(parcel.readString());
        miAppInfo.payMode = PayMode.valueOf(parcel.readString());
        miAppInfo.account = (MiAccountInfo) parcel.readParcelable(MiAccountInfo.class.getClassLoader());
        miAppInfo.SDK_INDEX = parcel.readInt();
        miAppInfo.newAppId = parcel.readString();
        miAppInfo.debugMode = DebugMode.valueOf(parcel.readString());
        miAppInfo.isSocialGame = Boolean.valueOf(parcel.readString()).booleanValue();
        miAppInfo.miGravity = MiGravity.valueOf(parcel.readString());
        return miAppInfo;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiAppInfo[] newArray(int i) {
        return new MiAppInfo[i];
    }
}
