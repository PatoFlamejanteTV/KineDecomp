package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareOpenGraphContent.java */
/* loaded from: classes.dex */
public class p implements Parcelable.Creator<ShareOpenGraphContent> {
    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphContent createFromParcel(Parcel parcel) {
        return new ShareOpenGraphContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphContent[] newArray(int i) {
        return new ShareOpenGraphContent[i];
    }
}
