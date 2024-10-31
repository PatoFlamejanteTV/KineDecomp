package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: GetTokenLoginMethodHandler.java */
/* loaded from: classes.dex */
final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
        return new GetTokenLoginMethodHandler(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetTokenLoginMethodHandler[] newArray(int i) {
        return new GetTokenLoginMethodHandler[i];
    }
}
