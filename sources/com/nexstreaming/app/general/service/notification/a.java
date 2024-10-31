package com.nexstreaming.app.general.service.notification;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: NotificationData.java */
/* loaded from: classes.dex */
final class a implements Parcelable.Creator<NotificationData> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationData createFromParcel(Parcel parcel) {
        return new NotificationData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NotificationData[] newArray(int i) {
        return new NotificationData[i];
    }
}
