package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* loaded from: classes.dex */
public final class zzz extends com.google.android.gms.common.data.zzc implements DataEvent {
    private final int c;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public DataItem b() {
        return new zzaf(this.a_, this.b_, this.c);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public int c() {
        return c("event_type");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataEvent a() {
        return new zzy(this);
    }

    public String toString() {
        return "DataEventRef{ type=" + (c() == 1 ? "changed" : c() == 2 ? "deleted" : "unknown") + ", dataitem=" + b() + " }";
    }
}
