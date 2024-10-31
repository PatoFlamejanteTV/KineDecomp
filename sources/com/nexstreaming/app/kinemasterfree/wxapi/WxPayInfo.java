package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class WxPayInfo implements Parcelable {
    public static final Parcelable.Creator<WxPayInfo> CREATOR = new j();
    private String cporderId;
    private String payLoad;
    private String prepayId;
    private String productId;

    public WxPayInfo() {
        this.prepayId = null;
        this.cporderId = null;
        this.productId = null;
        this.payLoad = null;
    }

    public String a() {
        return this.cporderId;
    }

    public String b() {
        return this.payLoad;
    }

    public String c() {
        return this.productId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxPayInfo{prepayId='" + this.prepayId + "', cporderId='" + this.cporderId + "', productId='" + this.productId + "', payLoad='" + this.payLoad + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.prepayId);
        parcel.writeString(this.cporderId);
        parcel.writeString(this.productId);
        parcel.writeString(this.payLoad);
    }

    public WxPayInfo(String str, String str2, String str3, String str4) {
        this.prepayId = null;
        this.cporderId = null;
        this.productId = null;
        this.payLoad = null;
        this.prepayId = str;
        this.cporderId = str2;
        this.productId = str3;
        this.payLoad = str4;
    }

    public WxPayInfo(Parcel parcel) {
        this.prepayId = null;
        this.cporderId = null;
        this.productId = null;
        this.payLoad = null;
        this.prepayId = parcel.readString();
        this.cporderId = parcel.readString();
        this.productId = parcel.readString();
        this.payLoad = parcel.readString();
    }
}
