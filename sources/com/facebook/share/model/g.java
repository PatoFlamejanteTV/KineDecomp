package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareOpenGraphObject.java */
/* loaded from: classes.dex */
final class g implements Parcelable.Creator<ShareOpenGraphObject> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphObject createFromParcel(Parcel parcel) {
        return new ShareOpenGraphObject(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphObject[] newArray(int i) {
        return new ShareOpenGraphObject[i];
    }
}
