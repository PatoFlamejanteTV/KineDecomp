package com.xiaomi.gamecenter.sdk.entry;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.gamecenter.sdk.IServiceCallback;

/* loaded from: classes.dex */
public class MiAppEntry implements Parcelable {
    public static final Parcelable.Creator CREATOR = new e();
    private int SDK_INDEX;
    private MiAccountInfo account;
    private int appId;
    private String appKey;
    private MiAppType appType;
    private IServiceCallback callback;
    private String cpMark;
    private Context ctx;
    private DebugMode debugMode;
    private boolean isSocialGame;
    private MiGravity miGravity;
    private String newAppId;
    private ScreenOrientation orientation;
    private PayMode payMode;
    private int pid;
    private String pkgLabel;
    private String pkgName;
    private int uid;
    private boolean weakAccount;

    private MiAppEntry() {
        this.cpMark = "XXX";
        this.payMode = PayMode.custom;
        this.SDK_INDEX = Integer.parseInt("44033");
        this.debugMode = DebugMode.ONLINE;
        this.isSocialGame = false;
        this.miGravity = MiGravity.MI_TOP_RIGHT;
        this.orientation = ScreenOrientation.vertical;
        this.weakAccount = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ MiAppEntry(e eVar) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        parcel.writeString(this.pkgName);
        parcel.writeString(this.pkgLabel);
        parcel.writeInt(this.pid);
        parcel.writeInt(this.uid);
        parcel.writeStrongInterface(this.callback);
        parcel.writeInt(this.SDK_INDEX);
        parcel.writeString(this.newAppId);
        parcel.writeString(this.debugMode.toString());
        parcel.writeString(Boolean.toString(this.isSocialGame));
        parcel.writeString(this.miGravity.toString());
    }
}
