package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class WxPayInfo implements Parcelable {
    public static final Parcelable.Creator<WxPayInfo> CREATOR = new i();
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

    /* JADX INFO: Access modifiers changed from: protected */
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

    public String a() {
        return this.payLoad;
    }

    public String b() {
        return this.cporderId;
    }

    public String c() {
        return this.productId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.prepayId);
        parcel.writeString(this.cporderId);
        parcel.writeString(this.productId);
        parcel.writeString(this.payLoad);
    }

    public String toString() {
        return "WxPayInfo{prepayId='" + this.prepayId + "', cporderId='" + this.cporderId + "', productId='" + this.productId + "', payLoad='" + this.payLoad + "'}";
    }
}
