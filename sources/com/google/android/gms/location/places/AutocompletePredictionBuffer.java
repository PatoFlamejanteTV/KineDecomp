package com.google.android.gms.location.places;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction a(int i) {
        return new com.google.android.gms.location.places.internal.zzb(this.f982a, i);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return PlacesStatusCodes.c(this.f982a.e());
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, getStatus()).toString();
    }
}
