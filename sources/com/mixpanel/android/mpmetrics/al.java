package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: UpdateDisplayState.java */
/* loaded from: classes.dex */
final class al implements Parcelable.Creator<UpdateDisplayState.DisplayState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState createFromParcel(Parcel parcel) {
        Bundle bundle = new Bundle(UpdateDisplayState.DisplayState.class.getClassLoader());
        bundle.readFromParcel(parcel);
        String string = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
        Bundle bundle2 = bundle.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
        if ("InAppNotificationState".equals(string)) {
            return new UpdateDisplayState.DisplayState.InAppNotificationState(bundle2, (aj) null);
        }
        if ("SurveyState".equals(string)) {
            return new UpdateDisplayState.DisplayState.SurveyState(bundle2, null);
        }
        throw new RuntimeException("Unrecognized display state type " + string);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState[] newArray(int i) {
        return new UpdateDisplayState.DisplayState[i];
    }
}
