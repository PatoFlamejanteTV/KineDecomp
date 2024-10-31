package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareHashtag.java */
/* loaded from: classes.dex */
public class g implements Parcelable.Creator<ShareHashtag> {
    @Override // android.os.Parcelable.Creator
    public ShareHashtag createFromParcel(Parcel parcel) {
        return new ShareHashtag(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareHashtag[] newArray(int i) {
        return new ShareHashtag[i];
    }
}
