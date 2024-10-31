package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharePhotoContent.java */
/* loaded from: classes.dex */
public class s implements Parcelable.Creator<SharePhotoContent> {
    @Override // android.os.Parcelable.Creator
    public SharePhotoContent createFromParcel(Parcel parcel) {
        return new SharePhotoContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public SharePhotoContent[] newArray(int i) {
        return new SharePhotoContent[i];
    }
}
