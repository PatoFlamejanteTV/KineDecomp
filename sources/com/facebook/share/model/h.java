package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareLinkContent.java */
/* loaded from: classes.dex */
public class h implements Parcelable.Creator<ShareLinkContent> {
    @Override // android.os.Parcelable.Creator
    public ShareLinkContent createFromParcel(Parcel parcel) {
        return new ShareLinkContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareLinkContent[] newArray(int i) {
        return new ShareLinkContent[i];
    }
}
