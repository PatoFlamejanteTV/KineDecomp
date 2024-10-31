package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class e implements Parcelable.Creator<PendingCallback> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PendingCallback createFromParcel(Parcel parcel) {
        return new PendingCallback(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PendingCallback[] newArray(int i) {
        return new PendingCallback[i];
    }
}
