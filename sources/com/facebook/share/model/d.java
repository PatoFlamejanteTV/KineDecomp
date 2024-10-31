package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareLinkContent.java */
/* loaded from: classes.dex */
final class d implements Parcelable.Creator<ShareLinkContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareLinkContent createFromParcel(Parcel parcel) {
        return new ShareLinkContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareLinkContent[] newArray(int i) {
        return new ShareLinkContent[i];
    }
}
