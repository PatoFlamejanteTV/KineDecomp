package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FacebookRequestError.java */
/* loaded from: classes.dex */
class l implements Parcelable.Creator<FacebookRequestError> {
    @Override // android.os.Parcelable.Creator
    public FacebookRequestError createFromParcel(Parcel parcel) {
        return new FacebookRequestError(parcel, (l) null);
    }

    @Override // android.os.Parcelable.Creator
    public FacebookRequestError[] newArray(int i) {
        return new FacebookRequestError[i];
    }
}
