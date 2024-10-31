package com.adobe.creativesdk.foundation.internal.twowayview;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.ItemSelectionSupport;

/* compiled from: ItemSelectionSupport.java */
/* loaded from: classes.dex */
class c implements Parcelable.Creator<ItemSelectionSupport.b> {
    @Override // android.os.Parcelable.Creator
    public ItemSelectionSupport.b createFromParcel(Parcel parcel) {
        return new ItemSelectionSupport.b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ItemSelectionSupport.b[] newArray(int i) {
        return new ItemSelectionSupport.b[i];
    }
}
