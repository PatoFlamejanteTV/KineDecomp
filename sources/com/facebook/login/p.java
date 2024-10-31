package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WebViewLoginMethodHandler.java */
/* loaded from: classes.dex */
final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
        return new WebViewLoginMethodHandler(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WebViewLoginMethodHandler[] newArray(int i) {
        return new WebViewLoginMethodHandler[i];
    }
}
