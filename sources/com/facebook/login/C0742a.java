package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CustomTabLoginMethodHandler.java */
/* renamed from: com.facebook.login.a */
/* loaded from: classes.dex */
class C0742a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
        return new CustomTabLoginMethodHandler(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public CustomTabLoginMethodHandler[] newArray(int i) {
        return new CustomTabLoginMethodHandler[i];
    }
}
