package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInviteContent.java */
/* loaded from: classes.dex */
public class b implements Parcelable.Creator<AppInviteContent> {
    @Override // android.os.Parcelable.Creator
    public AppInviteContent createFromParcel(Parcel parcel) {
        return new AppInviteContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public AppInviteContent[] newArray(int i) {
        return new AppInviteContent[i];
    }
}
