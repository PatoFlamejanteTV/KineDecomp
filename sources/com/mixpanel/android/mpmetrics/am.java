package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: UpdateDisplayState.java */
/* loaded from: classes.dex */
final class am implements Parcelable.Creator<UpdateDisplayState.DisplayState.InAppNotificationState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState.InAppNotificationState createFromParcel(Parcel parcel) {
        Bundle bundle = new Bundle(UpdateDisplayState.DisplayState.InAppNotificationState.class.getClassLoader());
        bundle.readFromParcel(parcel);
        return new UpdateDisplayState.DisplayState.InAppNotificationState(bundle, (aj) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState.InAppNotificationState[] newArray(int i) {
        return new UpdateDisplayState.DisplayState.InAppNotificationState[i];
    }
}
