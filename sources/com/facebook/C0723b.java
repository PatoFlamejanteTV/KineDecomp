package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AccessToken.java */
/* renamed from: com.facebook.b */
/* loaded from: classes.dex */
class C0723b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public AccessToken createFromParcel(Parcel parcel) {
        return new AccessToken(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public AccessToken[] newArray(int i) {
        return new AccessToken[i];
    }
}
