package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
class u implements Parcelable.Creator<LoginClient> {
    @Override // android.os.Parcelable.Creator
    public LoginClient createFromParcel(Parcel parcel) {
        return new LoginClient(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public LoginClient[] newArray(int i) {
        return new LoginClient[i];
    }
}
