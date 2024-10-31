package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: KatanaProxyLoginMethodHandler.java */
/* loaded from: classes.dex */
final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
        return new KatanaProxyLoginMethodHandler(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public KatanaProxyLoginMethodHandler[] newArray(int i) {
        return new KatanaProxyLoginMethodHandler[i];
    }
}
