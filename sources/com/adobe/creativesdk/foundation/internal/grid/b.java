package com.adobe.creativesdk.foundation.internal.grid;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ClassLoaderSavedState.java */
/* loaded from: classes.dex */
class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public c createFromParcel(Parcel parcel) {
        if (parcel.readParcelable(null) == null) {
            return c.f5015a;
        }
        throw new IllegalStateException("superState must be null");
    }

    @Override // android.os.Parcelable.Creator
    public c[] newArray(int i) {
        return new c[i];
    }
}
