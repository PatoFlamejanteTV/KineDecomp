package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class f implements Parcelable.Creator<PeriodicTask> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PeriodicTask createFromParcel(Parcel parcel) {
        return new PeriodicTask(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PeriodicTask[] newArray(int i) {
        return new PeriodicTask[i];
    }
}
