package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareOpenGraphContent.java */
/* loaded from: classes.dex */
final class f implements Parcelable.Creator<ShareOpenGraphContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphContent createFromParcel(Parcel parcel) {
        return new ShareOpenGraphContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphContent[] newArray(int i) {
        return new ShareOpenGraphContent[i];
    }
}
