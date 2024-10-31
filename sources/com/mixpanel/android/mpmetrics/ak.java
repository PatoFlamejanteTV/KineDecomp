package com.mixpanel.android.mpmetrics;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: UpdateDisplayState.java */
/* loaded from: classes.dex */
final class ak implements Parcelable.Creator<UpdateDisplayState.AnswerMap> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.AnswerMap createFromParcel(Parcel parcel) {
        Bundle bundle = new Bundle(UpdateDisplayState.AnswerMap.class.getClassLoader());
        UpdateDisplayState.AnswerMap answerMap = new UpdateDisplayState.AnswerMap();
        bundle.readFromParcel(parcel);
        for (String str : bundle.keySet()) {
            answerMap.a(Integer.valueOf(str), bundle.getString(str));
        }
        return answerMap;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateDisplayState.AnswerMap[] newArray(int i) {
        return new UpdateDisplayState.AnswerMap[i];
    }
}
