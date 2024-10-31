package com.nexstreaming.app.general.service.alarm;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AlarmData.java */
/* loaded from: classes.dex */
final class a implements Parcelable.Creator<AlarmData> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AlarmData createFromParcel(Parcel parcel) {
        return new AlarmData(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AlarmData[] newArray(int i) {
        return new AlarmData[i];
    }
}
