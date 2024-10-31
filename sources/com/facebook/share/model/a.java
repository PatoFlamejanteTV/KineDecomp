package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppGroupCreationContent.java */
/* loaded from: classes.dex */
public class a implements Parcelable.Creator<AppGroupCreationContent> {
    @Override // android.os.Parcelable.Creator
    public AppGroupCreationContent createFromParcel(Parcel parcel) {
        return new AppGroupCreationContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public AppGroupCreationContent[] newArray(int i) {
        return new AppGroupCreationContent[i];
    }
}
