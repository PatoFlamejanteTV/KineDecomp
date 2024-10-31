package com.adobe.creativesdk.foundation.internal.twowayview;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;

/* compiled from: TwoWayLayoutManager.java */
/* loaded from: classes.dex */
class e implements Parcelable.Creator<TwoWayLayoutManager.a> {
    @Override // android.os.Parcelable.Creator
    public TwoWayLayoutManager.a createFromParcel(Parcel parcel) {
        return new TwoWayLayoutManager.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public TwoWayLayoutManager.a[] newArray(int i) {
        return new TwoWayLayoutManager.a[i];
    }
}
