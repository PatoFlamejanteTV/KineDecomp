package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.LoginClient;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient.Request createFromParcel(Parcel parcel) {
        return new LoginClient.Request(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient.Request[] newArray(int i) {
        return new LoginClient.Request[i];
    }
}
