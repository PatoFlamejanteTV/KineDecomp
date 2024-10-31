package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateDisplayState.java */
/* loaded from: classes.dex */
public final class aj implements Parcelable.Creator<UpdateDisplayState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState createFromParcel(Parcel parcel) {
        Bundle bundle = new Bundle(UpdateDisplayState.class.getClassLoader());
        bundle.readFromParcel(parcel);
        return new UpdateDisplayState(bundle, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState[] newArray(int i) {
        return new UpdateDisplayState[i];
    }
}
