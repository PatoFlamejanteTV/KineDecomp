package com.google.common.reflect;

import com.google.common.reflect.TypeResolver;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeResolver.java */
/* loaded from: classes2.dex */
public class h extends TypeResolver.b {

    /* renamed from: b */
    final /* synthetic */ TypeVariable f16092b;

    /* renamed from: c */
    final /* synthetic */ TypeResolver.b f16093c;

    /* renamed from: d */
    final /* synthetic */ TypeResolver.b f16094d;

    public h(TypeResolver.b bVar, TypeVariable typeVariable, TypeResolver.b bVar2) {
        this.f16094d = bVar;
        this.f16092b = typeVariable;
        this.f16093c = bVar2;
    }

    @Override // com.google.common.reflect.TypeResolver.b
    public Type a(TypeVariable<?> typeVariable, TypeResolver.b bVar) {
        return typeVariable.getGenericDeclaration().equals(this.f16092b.getGenericDeclaration()) ? typeVariable : this.f16093c.a(typeVariable, bVar);
    }
}
