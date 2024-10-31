package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ai extends Gi {

    /* renamed from: b */
    private final /* synthetic */ C1154xi f11380b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private Ai(C1154xi c1154xi) {
        super(c1154xi, null);
        this.f11380b = c1154xi;
    }

    @Override // com.google.android.gms.internal.ads.Gi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1182zi(this.f11380b, null);
    }

    public /* synthetic */ Ai(C1154xi c1154xi, C1168yi c1168yi) {
        this(c1154xi);
    }
}
