package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareVideoContent.java */
/* loaded from: classes.dex */
public class v implements Parcelable.Creator<ShareVideoContent> {
    @Override // android.os.Parcelable.Creator
    public ShareVideoContent createFromParcel(Parcel parcel) {
        return new ShareVideoContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareVideoContent[] newArray(int i) {
        return new ShareVideoContent[i];
    }
}
