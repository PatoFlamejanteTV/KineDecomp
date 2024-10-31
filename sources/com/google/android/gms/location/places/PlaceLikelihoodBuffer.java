package com.google.android.gms.location.places;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzn;

/* loaded from: classes.dex */
public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final String b;
    private final Context c;
    private final int d;
    private final Status e;

    /* loaded from: classes.dex */
    public static class zza {
        static int a(int i) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.c = context;
        this.e = PlacesStatusCodes.c(dataHolder.e());
        this.d = zza.a(i);
        if (dataHolder == null || dataHolder.f() == null) {
            this.b = null;
        } else {
            this.b = dataHolder.f().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihood a(int i) {
        return new zzn(this.f982a, i, this.c);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.e;
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, getStatus()).a("attributions", this.b).toString();
    }
}
