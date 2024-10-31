package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class RegularImmutableSet<E> extends ImmutableSet.ArrayImmutableSet<E> {

    /* renamed from: a, reason: collision with root package name */
    private final transient int f2755a;
    private final transient int b;

    @VisibleForTesting
    final transient Object[] table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        super(objArr);
        this.table = objArr2;
        this.f2755a = i2;
        this.b = i;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int a2 = ab.a(obj.hashCode());
        while (true) {
            Object obj2 = this.table[this.f2755a & a2];
            if (obj2 == null) {
                return false;
            }
            if (!obj2.equals(obj)) {
                a2++;
            } else {
                return true;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }
}
