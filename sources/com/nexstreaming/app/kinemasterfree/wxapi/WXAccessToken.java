package com.nexstreaming.app.kinemasterfree.wxapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class WXAccessToken implements Parcelable {
    public static final Parcelable.Creator<WXAccessToken> CREATOR = new a();
    private String access_token;
    private int expires_in;
    private String openid;
    private String refresh_token;
    private long requestTime;
    private String scope;

    public WXAccessToken() {
        this.access_token = null;
        this.expires_in = 0;
        this.refresh_token = null;
        this.openid = null;
        this.scope = null;
        this.requestTime = 0L;
    }

    public String a() {
        return this.access_token;
    }

    public int b() {
        return this.expires_in;
    }

    public void c(String str) {
        this.refresh_token = str;
    }

    public String d() {
        return this.refresh_token;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.scope;
    }

    public boolean f() {
        return System.currentTimeMillis() > this.requestTime + ((long) (this.expires_in * 1000));
    }

    public String toString() {
        return "WXAccessToken{access_token='" + this.access_token + "', expires_in=" + this.expires_in + ", refresh_token='" + this.refresh_token + "', openid='" + this.openid + "', scope='" + this.scope + "', requestTime=" + this.requestTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.access_token);
        parcel.writeInt(this.expires_in);
        parcel.writeString(this.refresh_token);
        parcel.writeString(this.openid);
        parcel.writeString(this.scope);
        parcel.writeLong(this.requestTime);
    }

    public void a(String str) {
        this.access_token = str;
    }

    public void b(String str) {
        this.openid = str;
    }

    public String c() {
        return this.openid;
    }

    public void d(String str) {
        this.scope = str;
    }

    public void a(int i) {
        this.expires_in = i;
    }

    public void a(long j) {
        this.requestTime = j;
    }

    public WXAccessToken(Parcel parcel) {
        this.access_token = null;
        this.expires_in = 0;
        this.refresh_token = null;
        this.openid = null;
        this.scope = null;
        this.requestTime = 0L;
        this.access_token = parcel.readString();
        this.expires_in = parcel.readInt();
        this.refresh_token = parcel.readString();
        this.openid = parcel.readString();
        this.scope = parcel.readString();
        this.requestTime = parcel.readLong();
    }
}