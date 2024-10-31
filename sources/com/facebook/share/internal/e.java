package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareFeedContent.java */
/* loaded from: classes.dex */
public class E implements Parcelable.Creator<ShareFeedContent> {
    @Override // android.os.Parcelable.Creator
    public ShareFeedContent createFromParcel(Parcel parcel) {
        return new ShareFeedContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareFeedContent[] newArray(int i) {
        return new ShareFeedContent[i];
    }
}
