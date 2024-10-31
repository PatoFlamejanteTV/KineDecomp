package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameRequestContent.java */
/* loaded from: classes.dex */
public class e implements Parcelable.Creator<GameRequestContent> {
    @Override // android.os.Parcelable.Creator
    public GameRequestContent createFromParcel(Parcel parcel) {
        return new GameRequestContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public GameRequestContent[] newArray(int i) {
        return new GameRequestContent[i];
    }
}
