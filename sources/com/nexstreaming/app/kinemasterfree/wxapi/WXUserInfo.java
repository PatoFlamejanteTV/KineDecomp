package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class WXUserInfo implements Parcelable {
    public static final Parcelable.Creator<WXUserInfo> CREATOR = new i();
    private String city;
    private String country;
    private String headimgurl;
    private String nickname;
    private String openid;
    private ArrayList<String> privilege;
    private String province;
    private int sex;

    public WXUserInfo() {
        this.openid = null;
        this.nickname = null;
        this.sex = 0;
        this.province = null;
        this.city = null;
        this.country = null;
        this.headimgurl = null;
        this.privilege = new ArrayList<>();
    }

    public String a() {
        return this.city;
    }

    public String b() {
        return this.country;
    }

    public String c() {
        return this.headimgurl;
    }

    public String d() {
        return this.nickname;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.openid;
    }

    public String f() {
        return this.province;
    }

    public int g() {
        return this.sex;
    }

    public String toString() {
        return "UserInfo{openid='" + this.openid + "', nickname='" + this.nickname + "', sex=" + this.sex + ", province='" + this.province + "', city='" + this.city + "', country='" + this.country + "', headimgurl='" + this.headimgurl + "', privilege=" + this.privilege + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.openid);
        parcel.writeString(this.nickname);
        parcel.writeInt(this.sex);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.country);
        parcel.writeString(this.headimgurl);
        parcel.writeStringList(this.privilege);
    }

    public WXUserInfo(Parcel parcel) {
        this.openid = null;
        this.nickname = null;
        this.sex = 0;
        this.province = null;
        this.city = null;
        this.country = null;
        this.headimgurl = null;
        this.privilege = new ArrayList<>();
        this.openid = parcel.readString();
        this.nickname = parcel.readString();
        this.sex = parcel.readInt();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.country = parcel.readString();
        this.headimgurl = parcel.readString();
        this.privilege = parcel.createStringArrayList();
    }
}
