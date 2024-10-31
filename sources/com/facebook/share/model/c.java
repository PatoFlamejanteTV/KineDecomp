package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraEffectArguments.java */
/* loaded from: classes.dex */
public class c implements Parcelable.Creator<CameraEffectArguments> {
    @Override // android.os.Parcelable.Creator
    public CameraEffectArguments createFromParcel(Parcel parcel) {
        return new CameraEffectArguments(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public CameraEffectArguments[] newArray(int i) {
        return new CameraEffectArguments[i];
    }
}
