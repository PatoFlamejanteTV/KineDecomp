package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
public class p<K> extends TypeToken.b.a<K> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken.b f16101d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TypeToken.b bVar, TypeToken.b bVar2) {
        super(bVar2);
        this.f16101d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    public ImmutableList<K> a(Iterable<? extends K> iterable) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (K k : iterable) {
            if (!c(k).isInterface()) {
                builder.a((ImmutableList.Builder) k);
            }
        }
        return super.a((Iterable) builder.a());
    }

    @Override // com.google.common.reflect.TypeToken.b
    Iterable<? extends K> b(K k) {
        return ImmutableSet.of();
    }
}
