package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ShareMessengerGenericTemplateContent.java */
/* loaded from: classes.dex */
class j implements Parcelable.Creator<ShareMessengerGenericTemplateContent> {
    @Override // android.os.Parcelable.Creator
    public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
        return new ShareMessengerGenericTemplateContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMessengerGenericTemplateContent[] newArray(int i) {
        return new ShareMessengerGenericTemplateContent[i];
    }
}
