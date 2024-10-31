package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

/* loaded from: classes.dex */
public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Context b;
    private final Status c;
    private final String d;

    public PlaceBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.b = context;
        this.c = PlacesStatusCodes.c(dataHolder.e());
        if (dataHolder == null || dataHolder.f() == null) {
            this.d = null;
        } else {
            this.d = dataHolder.f().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Place a(int i) {
        return new zzs(this.f982a, i, this.b);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }
}
