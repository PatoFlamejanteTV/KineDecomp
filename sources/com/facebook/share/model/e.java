package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareOpenGraphAction.java */
/* loaded from: classes.dex */
final class e implements Parcelable.Creator<ShareOpenGraphAction> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphAction createFromParcel(Parcel parcel) {
        return new ShareOpenGraphAction(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShareOpenGraphAction[] newArray(int i) {
        return new ShareOpenGraphAction[i];
    }
}
