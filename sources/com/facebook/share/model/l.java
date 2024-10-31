package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMessengerMediaTemplateContent.java */
/* loaded from: classes.dex */
public class l implements Parcelable.Creator<ShareMessengerMediaTemplateContent> {
    @Override // android.os.Parcelable.Creator
    public ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
        return new ShareMessengerMediaTemplateContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMessengerMediaTemplateContent[] newArray(int i) {
        return new ShareMessengerMediaTemplateContent[i];
    }
}
