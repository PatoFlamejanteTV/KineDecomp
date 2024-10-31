package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* loaded from: classes.dex */
public class zzn extends zzu implements PlaceLikelihood {
    private final Context c;

    public zzn(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.c = context;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood a() {
        return PlaceLikelihoodEntity.a((PlaceImpl) e().a(), d());
    }

    public float d() {
        return a("place_likelihood", -1.0f);
    }

    public Place e() {
        return new zzs(this.a_, this.b_, this.c);
    }
}
