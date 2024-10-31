package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SharePhotoContent.java */
/* loaded from: classes.dex */
final class i implements Parcelable.Creator<SharePhotoContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharePhotoContent createFromParcel(Parcel parcel) {
        return new SharePhotoContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharePhotoContent[] newArray(int i) {
        return new SharePhotoContent[i];
    }
}
