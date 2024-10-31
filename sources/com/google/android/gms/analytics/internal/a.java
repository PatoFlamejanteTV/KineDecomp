package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class a implements Parcelable.Creator<Command> {
    @Override // android.os.Parcelable.Creator
    @Deprecated
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Command createFromParcel(Parcel parcel) {
        return new Command(parcel);
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Command[] newArray(int i) {
        return new Command[i];
    }
}
