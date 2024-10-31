package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fb extends lb {

    /* renamed from: b */
    private final /* synthetic */ C1297cb f13231b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private fb(C1297cb c1297cb) {
        super(c1297cb, null);
        this.f13231b = c1297cb;
    }

    @Override // com.google.android.gms.internal.gtm.lb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1303eb(this.f13231b, null);
    }

    public /* synthetic */ fb(C1297cb c1297cb, C1300db c1300db) {
        this(c1297cb);
    }
}
