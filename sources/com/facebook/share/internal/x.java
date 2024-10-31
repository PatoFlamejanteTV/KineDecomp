package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LikeContent.java */
/* loaded from: classes.dex */
public class x implements Parcelable.Creator<LikeContent> {
    @Override // android.os.Parcelable.Creator
    public LikeContent createFromParcel(Parcel parcel) {
        return new LikeContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public LikeContent[] newArray(int i) {
        return new LikeContent[i];
    }
}
