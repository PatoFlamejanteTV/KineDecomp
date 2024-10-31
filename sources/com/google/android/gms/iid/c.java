package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class c implements Parcelable.Creator<MessengerCompat> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessengerCompat createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new MessengerCompat(readStrongBinder);
        }
        return null;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessengerCompat[] newArray(int i) {
        return new MessengerCompat[i];
    }
}
