package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareMessengerOpenGraphMusicTemplateContent.java */
/* loaded from: classes.dex */
public class m implements Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> {
    @Override // android.os.Parcelable.Creator
    public ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
        return new ShareMessengerOpenGraphMusicTemplateContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i) {
        return new ShareMessengerOpenGraphMusicTemplateContent[i];
    }
}
