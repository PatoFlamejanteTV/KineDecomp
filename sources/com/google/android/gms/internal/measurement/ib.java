package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ib extends ob {

    /* renamed from: b */
    private final /* synthetic */ C1362fb f13466b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private ib(C1362fb c1362fb) {
        super(c1362fb, null);
        this.f13466b = c1362fb;
    }

    @Override // com.google.android.gms.internal.measurement.ob, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1368hb(this.f13466b, null);
    }

    public /* synthetic */ ib(C1362fb c1362fb, C1365gb c1365gb) {
        this(c1362fb);
    }
}
