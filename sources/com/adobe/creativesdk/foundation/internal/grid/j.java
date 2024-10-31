package com.adobe.creativesdk.foundation.internal.grid;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.grid.StaggeredGridView;

/* compiled from: StaggeredGridView.java */
/* loaded from: classes.dex */
class j implements Parcelable.Creator<StaggeredGridView.c> {
    @Override // android.os.Parcelable.Creator
    public StaggeredGridView.c createFromParcel(Parcel parcel) {
        return new StaggeredGridView.c(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public StaggeredGridView.c[] newArray(int i) {
        return new StaggeredGridView.c[i];
    }
}
