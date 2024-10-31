package com.xiaomi.gamecenter.sdk.entry;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class MiBuyInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new g();
    private int count;
    private String cpOrderId;
    private String cpUserInfo;
    private Bundle extraInfo;
    private String productCode;
    private int miBuyInfoVersion = 0;
    private int amount = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCount() {
        return this.count;
    }

    public String getCpOrderId() {
        return this.cpOrderId;
    }

    public String getCpUserInfo() {
        return this.cpUserInfo;
    }

    public Bundle getExtraInfo() {
        return this.extraInfo;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cpOrderId) && this.count <= 9999 && this.amount <= 20000;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCpOrderId(String str) {
        this.cpOrderId = str;
    }

    public void setCpUserInfo(String str) {
        this.cpUserInfo = str;
    }

    public void setExtraInfo(Bundle bundle) {
        this.extraInfo = bundle;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.miBuyInfoVersion);
        parcel.writeString(this.cpOrderId);
        parcel.writeString(this.productCode);
        parcel.writeInt(this.count);
        parcel.writeString(this.cpUserInfo);
        parcel.writeInt(this.amount);
        parcel.writeBundle(this.extraInfo);
    }
}
