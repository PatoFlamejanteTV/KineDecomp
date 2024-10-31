package com.xiaomi.gamecenter.sdk.entry;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MiAppInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new f();
    private MiAccountInfo account;
    private String appKey;
    private Context ctx;
    private String newAppId;
    private int appId = 0;
    private String cpMark = "XXX";
    private PayMode payMode = PayMode.custom;
    private int SDK_INDEX = Integer.parseInt("44033");
    private DebugMode debugMode = DebugMode.ONLINE;
    private boolean isSocialGame = false;
    private MiGravity miGravity = MiGravity.MI_TOP_RIGHT;
    private ScreenOrientation orientation = ScreenOrientation.vertical;
    private boolean weakAccount = false;
    private MiAppType appType = MiAppType.offline;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MiAccountInfo getAccount() {
        return this.account;
    }

    public String getAppId() {
        return this.newAppId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public MiAppType getAppType() {
        return this.appType;
    }

    public String getCpMark() {
        return this.cpMark;
    }

    public Context getCtx() {
        return this.ctx;
    }

    public DebugMode getDebugMode() {
        return this.debugMode;
    }

    public ScreenOrientation getOrientation() {
        return this.orientation;
    }

    public boolean isSocialGame() {
        return this.isSocialGame;
    }

    public void setAccount(MiAccountInfo miAccountInfo) {
        this.account = miAccountInfo;
    }

    public void setAppId(String str) {
        this.newAppId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppType(MiAppType miAppType) {
        this.appType = miAppType;
    }

    public void setCtx(Context context) {
        this.ctx = context;
    }

    public void setOrientation(ScreenOrientation screenOrientation) {
        this.orientation = screenOrientation;
    }

    public void setSocialGame(boolean z) {
        this.isSocialGame = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeString(this.appType.toString());
        parcel.writeString(this.cpMark);
        parcel.writeString(this.orientation.toString());
        parcel.writeString(Boolean.toString(this.weakAccount));
        parcel.writeString(this.payMode.toString());
        parcel.writeParcelable(this.account, 0);
        parcel.writeInt(this.SDK_INDEX);
        parcel.writeString(this.newAppId);
        parcel.writeString(this.debugMode.toString());
        parcel.writeString(Boolean.toString(this.isSocialGame));
        parcel.writeString(this.miGravity.toString());
    }
}
