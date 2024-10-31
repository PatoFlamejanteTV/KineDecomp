package com.adobe.creativesdk.foundation.internal.grid;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.grid.e;

/* compiled from: ExtendableListView.java */
/* loaded from: classes.dex */
class f implements Parcelable.Creator<e.C0025e> {
    @Override // android.os.Parcelable.Creator
    public e.C0025e createFromParcel(Parcel parcel) {
        return new e.C0025e(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public e.C0025e[] newArray(int i) {
        return new e.C0025e[i];
    }
}
