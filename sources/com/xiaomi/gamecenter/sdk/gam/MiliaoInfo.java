package com.xiaomi.gamecenter.sdk.gam;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class MiliaoInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new d();
    private String appid;
    private String appname;
    private String gameid;
    private String mlaltmsg;
    private String mlcontent;
    private String mlownerid;
    private String mlownername;
    private String mlsourcename;
    private String mlsourceurl;
    private String mltitle;
    private String rootMiliaoInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getAppname() {
        return this.appname;
    }

    public String getGameid() {
        return this.gameid;
    }

    public String getMlaltmsg() {
        return this.mlaltmsg;
    }

    public String getMlcontent() {
        return this.mlcontent;
    }

    public String getMlownerid() {
        return this.mlownerid;
    }

    public String getMlownername() {
        return this.mlownername;
    }

    public String getMlsourcename() {
        return this.mlsourcename;
    }

    public String getMlsourceurl() {
        return this.mlsourceurl;
    }

    public String getMltitle() {
        return this.mltitle;
    }

    public String getRootMiliaoInfo() {
        return this.rootMiliaoInfo;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setAppname(String str) {
        this.appname = str;
    }

    public void setGameid(String str) {
        this.gameid = str;
    }

    public void setMlaltmsg(String str) {
        this.mlaltmsg = str;
    }

    public void setMlcontent(String str) {
        this.mlcontent = str;
    }

    public void setMlownerid(String str) {
        this.mlownerid = str;
    }

    public void setMlownername(String str) {
        this.mlownername = str;
    }

    public void setMlsourcename(String str) {
        this.mlsourcename = str;
    }

    public void setMlsourceurl(String str) {
        this.mlsourceurl = str;
    }

    public void setMltitle(String str) {
        this.mltitle = str;
    }

    public void setRootMiliaoInfo(String str) {
        this.rootMiliaoInfo = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appid);
        parcel.writeString(this.gameid);
        parcel.writeString(this.appname);
        parcel.writeString(this.mlownerid);
        parcel.writeString(this.mlownername);
        parcel.writeString(this.mltitle);
        parcel.writeString(this.mlcontent);
        parcel.writeString(this.mlsourcename);
        parcel.writeString(this.mlsourceurl);
        parcel.writeString(this.mlaltmsg);
        parcel.writeString(this.rootMiliaoInfo);
    }
}
