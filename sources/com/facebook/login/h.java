package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.LoginClient;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient.Result createFromParcel(Parcel parcel) {
        return new LoginClient.Result(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient.Result[] newArray(int i) {
        return new LoginClient.Result[i];
    }
}
