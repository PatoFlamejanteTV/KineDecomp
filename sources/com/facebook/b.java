package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AccessToken.java */
/* loaded from: classes.dex */
final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessToken createFromParcel(Parcel parcel) {
        return new AccessToken(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AccessToken[] newArray(int i) {
        return new AccessToken[i];
    }
}
