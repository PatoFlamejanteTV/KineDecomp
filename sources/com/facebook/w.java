package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.GraphRequest;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
class w implements Parcelable.Creator<GraphRequest.ParcelableResourceWithMimeType> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
        return new GraphRequest.ParcelableResourceWithMimeType(parcel, (q) null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GraphRequest.ParcelableResourceWithMimeType[] newArray(int i) {
        return new GraphRequest.ParcelableResourceWithMimeType[i];
    }
}
