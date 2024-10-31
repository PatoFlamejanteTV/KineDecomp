package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: LoginClient.java */
/* loaded from: classes.dex */
final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient createFromParcel(Parcel parcel) {
        return new LoginClient(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginClient[] newArray(int i) {
        return new LoginClient[i];
    }
}
