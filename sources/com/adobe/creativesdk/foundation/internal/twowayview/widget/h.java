package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.StaggeredGridLayoutManager;

/* compiled from: StaggeredGridLayoutManager.java */
/* loaded from: classes.dex */
class h implements Parcelable.Creator<StaggeredGridLayoutManager.b> {
    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.b createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public StaggeredGridLayoutManager.b[] newArray(int i) {
        return new StaggeredGridLayoutManager.b[i];
    }
}
