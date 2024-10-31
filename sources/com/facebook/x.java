package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.GraphRequest;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
final class x implements Parcelable.Creator<GraphRequest.ParcelableResourceWithMimeType> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
        return new GraphRequest.ParcelableResourceWithMimeType(parcel, (p) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GraphRequest.ParcelableResourceWithMimeType[] newArray(int i) {
        return new GraphRequest.ParcelableResourceWithMimeType[i];
    }
}
