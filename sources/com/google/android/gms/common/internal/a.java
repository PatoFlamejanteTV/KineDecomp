package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<BinderWrapper> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BinderWrapper[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
