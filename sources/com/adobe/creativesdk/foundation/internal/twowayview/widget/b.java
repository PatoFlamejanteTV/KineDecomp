package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager;

/* compiled from: BaseLayoutManager.java */
/* loaded from: classes.dex */
class b implements Parcelable.Creator<BaseLayoutManager.a> {
    @Override // android.os.Parcelable.Creator
    public BaseLayoutManager.a createFromParcel(Parcel parcel) {
        return new BaseLayoutManager.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public BaseLayoutManager.a[] newArray(int i) {
        return new BaseLayoutManager.a[i];
    }
}
