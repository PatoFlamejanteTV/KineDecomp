package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareFeedContent.java */
/* loaded from: classes.dex */
final class w implements Parcelable.Creator<ShareFeedContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareFeedContent createFromParcel(Parcel parcel) {
        return new ShareFeedContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareFeedContent[] newArray(int i) {
        return new ShareFeedContent[i];
    }
}
