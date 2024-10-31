package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SharePhoto.java */
/* loaded from: classes.dex */
final class h implements Parcelable.Creator<SharePhoto> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharePhoto createFromParcel(Parcel parcel) {
        return new SharePhoto(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharePhoto[] newArray(int i) {
        return new SharePhoto[i];
    }
}
