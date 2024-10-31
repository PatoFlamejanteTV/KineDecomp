package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Survey.java */
/* loaded from: classes.dex */
public final class ac implements Parcelable.Creator<Survey> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Survey createFromParcel(Parcel parcel) {
        try {
            return new Survey(new JSONObject(parcel.readString()));
        } catch (BadDecideObjectException e) {
            throw new RuntimeException("Unexpected or incomplete object written to survey parcel.", e);
        } catch (JSONException e2) {
            throw new RuntimeException("Corrupted JSON object written to survey parcel.", e2);
        }
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Survey[] newArray(int i) {
        return new Survey[i];
    }
}
