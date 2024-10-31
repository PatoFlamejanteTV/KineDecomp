package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareVideo.java */
/* loaded from: classes.dex */
public class u implements Parcelable.Creator<ShareVideo> {
    @Override // android.os.Parcelable.Creator
    public ShareVideo createFromParcel(Parcel parcel) {
        return new ShareVideo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareVideo[] newArray(int i) {
        return new ShareVideo[i];
    }
}
