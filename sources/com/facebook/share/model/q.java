package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareOpenGraphObject.java */
/* loaded from: classes.dex */
public class q implements Parcelable.Creator<ShareOpenGraphObject> {
    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphObject createFromParcel(Parcel parcel) {
        return new ShareOpenGraphObject(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphObject[] newArray(int i) {
        return new ShareOpenGraphObject[i];
    }
}
