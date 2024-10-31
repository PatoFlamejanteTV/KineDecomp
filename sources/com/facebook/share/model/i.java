package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMediaContent.java */
/* loaded from: classes.dex */
public class i implements Parcelable.Creator<ShareMediaContent> {
    @Override // android.os.Parcelable.Creator
    public ShareMediaContent createFromParcel(Parcel parcel) {
        return new ShareMediaContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMediaContent[] newArray(int i) {
        return new ShareMediaContent[i];
    }
}
