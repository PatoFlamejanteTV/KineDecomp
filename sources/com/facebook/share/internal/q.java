package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: LikeContent.java */
/* loaded from: classes.dex */
final class q implements Parcelable.Creator<LikeContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LikeContent createFromParcel(Parcel parcel) {
        return new LikeContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LikeContent[] newArray(int i) {
        return new LikeContent[i];
    }
}
