package com.nexstreaming.kinemaster.mediastore.item;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: MediaStoreItemId.java */
/* loaded from: classes.dex */
class d implements Parcelable.Creator<MediaStoreItemId> {
    @Override // android.os.Parcelable.Creator
    public MediaStoreItemId createFromParcel(Parcel parcel) {
        return new MediaStoreItemId(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public MediaStoreItemId[] newArray(int i) {
        return new MediaStoreItemId[i];
    }
}
