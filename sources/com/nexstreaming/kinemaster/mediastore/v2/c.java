package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: MSID.java */
/* loaded from: classes.dex */
final class c implements Parcelable.Creator<MSID> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MSID createFromParcel(Parcel parcel) {
        return new MSID(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MSID[] newArray(int i) {
        return new MSID[i];
    }
}
