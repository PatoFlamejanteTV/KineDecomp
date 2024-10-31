package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareStoryContent.java */
/* loaded from: classes.dex */
public class t implements Parcelable.Creator<ShareStoryContent> {
    @Override // android.os.Parcelable.Creator
    public ShareStoryContent createFromParcel(Parcel parcel) {
        return new ShareStoryContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareStoryContent[] newArray(int i) {
        return new ShareStoryContent[i];
    }
}
