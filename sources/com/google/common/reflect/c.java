package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeResolver.java */
/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TypeVariable f2946a;
    final /* synthetic */ b b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, ImmutableMap immutableMap, TypeVariable typeVariable, b bVar2) {
        super(immutableMap, null);
        this.c = bVar;
        this.f2946a = typeVariable;
        this.b = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.b
    public Type a(TypeVariable<?> typeVariable, b bVar) {
        return typeVariable.getGenericDeclaration().equals(this.f2946a.getGenericDeclaration()) ? typeVariable : this.b.a(typeVariable, bVar);
    }
}
