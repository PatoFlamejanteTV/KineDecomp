package com.adobe.creativesdk.foundation.internal.grid;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.grid.StaggeredGridView;

/* compiled from: StaggeredGridView.java */
/* loaded from: classes.dex */
class i implements Parcelable.Creator<StaggeredGridView.a> {
    @Override // android.os.Parcelable.Creator
    public StaggeredGridView.a createFromParcel(Parcel parcel) {
        return new StaggeredGridView.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public StaggeredGridView.a[] newArray(int i) {
        return new StaggeredGridView.a[i];
    }
}
