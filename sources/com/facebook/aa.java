package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Profile.java */
/* loaded from: classes.dex */
final class aa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Profile createFromParcel(Parcel parcel) {
        return new Profile(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Profile[] newArray(int i) {
        return new Profile[i];
    }
}
