package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.BaseLayoutManager;

/* compiled from: BaseLayoutManager.java */
/* loaded from: classes.dex */
class c implements Parcelable.Creator<BaseLayoutManager.b> {
    @Override // android.os.Parcelable.Creator
    public BaseLayoutManager.b createFromParcel(Parcel parcel) {
        return new BaseLayoutManager.b(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public BaseLayoutManager.b[] newArray(int i) {
        return new BaseLayoutManager.b[i];
    }
}
