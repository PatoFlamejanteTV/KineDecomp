package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraEffectTextures.java */
/* loaded from: classes.dex */
public class d implements Parcelable.Creator<CameraEffectTextures> {
    @Override // android.os.Parcelable.Creator
    public CameraEffectTextures createFromParcel(Parcel parcel) {
        return new CameraEffectTextures(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public CameraEffectTextures[] newArray(int i) {
        return new CameraEffectTextures[i];
    }
}
