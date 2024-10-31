package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* loaded from: classes.dex */
public class zzy implements DataEvent {

    /* renamed from: a, reason: collision with root package name */
    private int f2404a;
    private DataItem b;

    public zzy(DataEvent dataEvent) {
        this.f2404a = dataEvent.c();
        this.b = dataEvent.b().a();
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public DataItem b() {
        return this.b;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public int c() {
        return this.f2404a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataEvent a() {
        return this;
    }

    public String toString() {
        return "DataEventEntity{ type=" + (c() == 1 ? "changed" : c() == 2 ? "deleted" : "unknown") + ", dataitem=" + b() + " }";
    }
}
