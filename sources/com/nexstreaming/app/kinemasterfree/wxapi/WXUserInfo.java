package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WXUserInfo implements Parcelable {
    public static final Parcelable.Creator<WXUserInfo> CREATOR = new h();
    private String city;
    private String country;
    private String headimgurl;
    private String nickname;
    private String openid;
    private ArrayList<String> privilege;
    private String province;
    private int sex;
    private String unionid;

    public WXUserInfo() {
        this.openid = null;
        this.nickname = null;
        this.sex = 0;
        this.province = null;
        this.city = null;
        this.country = null;
        this.headimgurl = null;
        this.privilege = new ArrayList<>();
        this.unionid = null;
    }

    public String toString() {
        return "UserInfo{openid='" + this.openid + "', nickname='" + this.nickname + "', sex=" + this.sex + ", province='" + this.province + "', city='" + this.city + "', country='" + this.country + "', headimgurl='" + this.headimgurl + "', privilege=" + this.privilege + ", unionid='" + this.unionid + "'}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WXUserInfo(Parcel parcel) {
        this.openid = null;
        this.nickname = null;
        this.sex = 0;
        this.province = null;
        this.city = null;
        this.country = null;
        this.headimgurl = null;
        this.privilege = new ArrayList<>();
        this.unionid = null;
        this.openid = parcel.readString();
        this.nickname = parcel.readString();
        this.sex = parcel.readInt();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.country = parcel.readString();
        this.headimgurl = parcel.readString();
        this.privilege = parcel.createStringArrayList();
        this.unionid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        parcel.writeString(this.unionid);
    }
}
