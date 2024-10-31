package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MiGamMessageResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new b();
    private MiliaoInfo miliaoInfo;
    private String msgResult;
    private int sdkStatus;
    private int index = 0;
    private String heartToken = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getHeartToken() {
        return this.heartToken;
    }

    public MiliaoInfo getMiliaoInfo() {
        return this.miliaoInfo;
    }

    public String getMsgResult() {
        return this.msgResult;
    }

    public int getSdkStatus() {
        return this.sdkStatus;
    }

    public void setMsgResult(String str) {
        this.msgResult = str;
    }

    public void setSdkStatus(int i) {
        this.sdkStatus = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.sdkStatus);
        parcel.writeString(this.msgResult);
        parcel.writeString(this.heartToken);
        parcel.writeParcelable(this.miliaoInfo, 0);
    }
}
