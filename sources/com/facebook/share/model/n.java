package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMessengerURLActionButton.java */
/* loaded from: classes.dex */
public class n implements Parcelable.Creator<ShareMessengerURLActionButton> {
    @Override // android.os.Parcelable.Creator
    public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
        return new ShareMessengerURLActionButton(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMessengerURLActionButton[] newArray(int i) {
        return new ShareMessengerURLActionButton[i];
    }
}
