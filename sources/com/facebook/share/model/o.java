package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareOpenGraphAction.java */
/* loaded from: classes.dex */
public class o implements Parcelable.Creator<ShareOpenGraphAction> {
    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphAction createFromParcel(Parcel parcel) {
        return new ShareOpenGraphAction(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareOpenGraphAction[] newArray(int i) {
        return new ShareOpenGraphAction[i];
    }
}
