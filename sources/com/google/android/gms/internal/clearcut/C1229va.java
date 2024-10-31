package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.va */
/* loaded from: classes2.dex */
public final class C1229va extends Ba {

    /* renamed from: b */
    private final /* synthetic */ C1223sa f12898b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C1229va(C1223sa c1223sa) {
        super(c1223sa, null);
        this.f12898b = c1223sa;
    }

    public /* synthetic */ C1229va(C1223sa c1223sa, C1225ta c1225ta) {
        this(c1223sa);
    }

    @Override // com.google.android.gms.internal.clearcut.Ba, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1227ua(this.f12898b, null);
    }
}
