package com.xiaomi.gamecenter.sdk.entry;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.gamecenter.sdk.IServiceCallback;

/* loaded from: classes.dex */
final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiAppEntry createFromParcel(Parcel parcel) {
        MiAppEntry miAppEntry = new MiAppEntry(null);
        miAppEntry.appId = parcel.readInt();
        miAppEntry.appKey = parcel.readString();
        miAppEntry.appType = MiAppType.valueOf(parcel.readString());
        miAppEntry.cpMark = parcel.readString();
        miAppEntry.orientation = ScreenOrientation.valueOf(parcel.readString());
        miAppEntry.weakAccount = Boolean.getBoolean(parcel.readString());
        miAppEntry.payMode = PayMode.valueOf(parcel.readString());
        miAppEntry.account = (MiAccountInfo) parcel.readParcelable(MiAppEntry.class.getClassLoader());
        miAppEntry.pkgName = parcel.readString();
        miAppEntry.pkgLabel = parcel.readString();
        miAppEntry.pid = parcel.readInt();
        miAppEntry.uid = parcel.readInt();
        try {
            miAppEntry.callback = IServiceCallback.Stub.asInterface(parcel.readStrongBinder());
        } catch (Exception e) {
        }
        miAppEntry.SDK_INDEX = parcel.readInt();
        miAppEntry.newAppId = parcel.readString();
        miAppEntry.debugMode = DebugMode.valueOf(parcel.readString());
        miAppEntry.isSocialGame = Boolean.valueOf(parcel.readString()).booleanValue();
        miAppEntry.miGravity = MiGravity.valueOf(parcel.readString());
        return miAppEntry;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MiAppEntry[] newArray(int i) {
        return new MiAppEntry[i];
    }
}
