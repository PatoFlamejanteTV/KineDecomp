package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppNotification.java */
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<InAppNotification> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InAppNotification createFromParcel(Parcel parcel) {
        return new InAppNotification(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InAppNotification[] newArray(int i) {
        return new InAppNotification[i];
    }
}
