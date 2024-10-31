package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: GameRequestContent.java */
/* loaded from: classes.dex */
final class c implements Parcelable.Creator<GameRequestContent> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestContent createFromParcel(Parcel parcel) {
        return new GameRequestContent(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestContent[] newArray(int i) {
        return new GameRequestContent[i];
    }
}
