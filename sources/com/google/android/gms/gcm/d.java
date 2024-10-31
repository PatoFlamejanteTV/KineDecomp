package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class d implements Parcelable.Creator<OneoffTask> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OneoffTask createFromParcel(Parcel parcel) {
        return new OneoffTask(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OneoffTask[] newArray(int i) {
        return new OneoffTask[i];
    }
}
