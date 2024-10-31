package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class GamMetaInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private String executeurl;
    private String os;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExecuteurl() {
        return this.executeurl;
    }

    public String getOs() {
        return this.os;
    }

    public void setExecuteurl(String str) {
        this.executeurl = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.os);
        parcel.writeString(this.executeurl);
    }
}
