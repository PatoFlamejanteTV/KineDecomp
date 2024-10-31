package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.ta */
/* loaded from: classes2.dex */
public final class C1276ta extends C1288za {

    /* renamed from: b */
    private final /* synthetic */ C1269pa f13082b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C1276ta(C1269pa c1269pa) {
        super(c1269pa, null);
        this.f13082b = c1269pa;
    }

    @Override // com.google.android.gms.internal.firebase_auth.C1288za, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1274sa(this.f13082b, null);
    }

    public /* synthetic */ C1276ta(C1269pa c1269pa, C1272ra c1272ra) {
        this(c1269pa);
    }
}
