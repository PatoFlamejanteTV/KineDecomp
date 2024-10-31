package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ScoresEntry implements Parcelable {
    public static final Parcelable.Creator CREATOR = new e();
    private String scoreKey;
    private int scoreValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScoreKey() {
        return this.scoreKey;
    }

    public int getScoreValue() {
        return this.scoreValue;
    }

    public void setScoreKey(String str) {
        this.scoreKey = str;
    }

    public void setScoreValue(int i) {
        this.scoreValue = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scoreKey);
        parcel.writeInt(this.scoreValue);
    }
}
