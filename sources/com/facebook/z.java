package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Profile.java */
/* loaded from: classes.dex */
class z implements Parcelable.Creator<Profile> {
    @Override // android.os.Parcelable.Creator
    public Profile createFromParcel(Parcel parcel) {
        return new Profile(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public Profile[] newArray(int i) {
        return new Profile[i];
    }
}
