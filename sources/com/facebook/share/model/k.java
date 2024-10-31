package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMessengerGenericTemplateElement.java */
/* loaded from: classes.dex */
public class k implements Parcelable.Creator<ShareMessengerGenericTemplateElement> {
    @Override // android.os.Parcelable.Creator
    public ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
        return new ShareMessengerGenericTemplateElement(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMessengerGenericTemplateElement[] newArray(int i) {
        return new ShareMessengerGenericTemplateElement[i];
    }
}
