package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Map;

/* compiled from: AbstractMapBasedMultiset.java */
/* renamed from: com.google.common.collect.g */
/* loaded from: classes2.dex */
public class C1507g<E> extends Multisets.a<E> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15788a;

    /* renamed from: b */
    final /* synthetic */ C1510h f15789b;

    public C1507g(C1510h c1510h, Map.Entry entry) {
        this.f15789b = c1510h;
        this.f15788a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        Count count;
        Count count2 = (Count) this.f15788a.getValue();
        if ((count2 == null || count2.get() == 0) && (count = (Count) this.f15789b.f15796c.f15323c.get(getElement())) != null) {
            return count.get();
        }
        if (count2 == null) {
            return 0;
        }
        return count2.get();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public E getElement() {
        return (E) this.f15788a.getKey();
    }
}
