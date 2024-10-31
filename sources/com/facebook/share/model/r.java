package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharePhoto.java */
/* loaded from: classes.dex */
public class r implements Parcelable.Creator<SharePhoto> {
    @Override // android.os.Parcelable.Creator
    public SharePhoto createFromParcel(Parcel parcel) {
        return new SharePhoto(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public SharePhoto[] newArray(int i) {
        return new SharePhoto[i];
    }
}
