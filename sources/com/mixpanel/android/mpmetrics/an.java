package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: UpdateDisplayState.java */
/* loaded from: classes.dex */
final class an implements Parcelable.Creator<UpdateDisplayState.DisplayState.SurveyState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState.SurveyState createFromParcel(Parcel parcel) {
        Bundle bundle = new Bundle(UpdateDisplayState.DisplayState.SurveyState.class.getClassLoader());
        bundle.readFromParcel(parcel);
        return new UpdateDisplayState.DisplayState.SurveyState(bundle, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.DisplayState.SurveyState[] newArray(int i) {
        return new UpdateDisplayState.DisplayState.SurveyState[i];
    }
}
