package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AppInviteContent.java */
/* loaded from: classes.dex */
final class b implements Parcelable.Creator<AppInviteContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppInviteContent createFromParcel(Parcel parcel) {
        return new AppInviteContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppInviteContent[] newArray(int i) {
        return new AppInviteContent[i];
    }
}
