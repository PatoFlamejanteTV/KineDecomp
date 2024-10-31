package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareVideo.java */
/* loaded from: classes.dex */
final class j implements Parcelable.Creator<ShareVideo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareVideo createFromParcel(Parcel parcel) {
        return new ShareVideo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareVideo[] newArray(int i) {
        return new ShareVideo[i];
    }
}
