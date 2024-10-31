package com.adobe.creativesdk.foundation.internal.twowayview;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.ItemSelectionSupport;

/* compiled from: ItemSelectionSupport.java */
/* loaded from: classes.dex */
class b implements Parcelable.Creator<ItemSelectionSupport.a> {
    @Override // android.os.Parcelable.Creator
    public ItemSelectionSupport.a createFromParcel(Parcel parcel) {
        return new ItemSelectionSupport.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ItemSelectionSupport.a[] newArray(int i) {
        return new ItemSelectionSupport.a[i];
    }
}
