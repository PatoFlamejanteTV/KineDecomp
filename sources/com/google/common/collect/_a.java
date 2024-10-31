package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;

/* compiled from: Multisets.java */
/* loaded from: classes2.dex */
class _a extends Ordering<Multiset.Entry<?>> {
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
        return Ints.a(entry2.getCount(), entry.getCount());
    }
}
