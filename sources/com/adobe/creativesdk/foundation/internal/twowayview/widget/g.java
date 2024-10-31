package com.adobe.creativesdk.foundation.internal.twowayview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.SpannableGridLayoutManager;

/* compiled from: SpannableGridLayoutManager.java */
/* loaded from: classes.dex */
class g implements Parcelable.Creator<SpannableGridLayoutManager.b> {
    @Override // android.os.Parcelable.Creator
    public SpannableGridLayoutManager.b createFromParcel(Parcel parcel) {
        return new SpannableGridLayoutManager.b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public SpannableGridLayoutManager.b[] newArray(int i) {
        return new SpannableGridLayoutManager.b[i];
    }
}
