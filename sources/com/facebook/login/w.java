package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.LoginClient;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
class w implements Parcelable.Creator<LoginClient.Result> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LoginClient.Result createFromParcel(Parcel parcel) {
        return new LoginClient.Result(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LoginClient.Result[] newArray(int i) {
        return new LoginClient.Result[i];
    }
}
