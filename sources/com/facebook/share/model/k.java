package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareVideoContent.java */
/* loaded from: classes.dex */
final class k implements Parcelable.Creator<ShareVideoContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareVideoContent createFromParcel(Parcel parcel) {
        return new ShareVideoContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareVideoContent[] newArray(int i) {
        return new ShareVideoContent[i];
    }
}
