package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AppGroupCreationContent.java */
/* loaded from: classes.dex */
final class a implements Parcelable.Creator<AppGroupCreationContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppGroupCreationContent createFromParcel(Parcel parcel) {
        return new AppGroupCreationContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppGroupCreationContent[] newArray(int i) {
        return new AppGroupCreationContent[i];
    }
}
