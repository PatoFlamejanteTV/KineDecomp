package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
public class g<K> extends TypeToken.a.C0051a<K> {
    final /* synthetic */ TypeToken.a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TypeToken.a aVar, TypeToken.a aVar2) {
        super(aVar2);
        this.c = aVar;
    }

    @Override // com.google.common.reflect.TypeToken.a.C0051a, com.google.common.reflect.TypeToken.a
    Iterable<? extends K> c(K k) {
        return ImmutableSet.of();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.a
    public ImmutableList<K> a(Iterable<? extends K> iterable) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (K k : iterable) {
            if (!b(k).isInterface()) {
                builder.b((ImmutableList.Builder) k);
            }
        }
        return super.a((Iterable) builder.a());
    }
}
