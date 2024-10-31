package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.LoginClient;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
class v implements Parcelable.Creator<LoginClient.Request> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LoginClient.Request createFromParcel(Parcel parcel) {
        return new LoginClient.Request(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LoginClient.Request[] newArray(int i) {
        return new LoginClient.Request[i];
    }
}
