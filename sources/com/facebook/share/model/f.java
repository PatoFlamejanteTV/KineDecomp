package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareCameraEffectContent.java */
/* loaded from: classes.dex */
public class f implements Parcelable.Creator<ShareCameraEffectContent> {
    @Override // android.os.Parcelable.Creator
    public ShareCameraEffectContent createFromParcel(Parcel parcel) {
        return new ShareCameraEffectContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareCameraEffectContent[] newArray(int i) {
        return new ShareCameraEffectContent[i];
    }
}
