package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.reflect.Invokable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
class j<T> extends Invokable.a<T> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken f16096d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TypeToken typeToken, Constructor constructor) {
        super(constructor);
        this.f16096d = typeToken;
    }

    @Override // com.google.common.reflect.Invokable, com.google.common.reflect.b
    public TypeToken<T> a() {
        return this.f16096d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.Invokable.a
    public Type[] b() {
        TypeToken typeToken = this.f16096d;
        Type[] b2 = super.b();
        TypeToken.access$000(typeToken, b2);
        return b2;
    }

    @Override // com.google.common.reflect.Invokable, com.google.common.reflect.b
    public String toString() {
        return a() + "(" + Joiner.a(", ").a((Object[]) b()) + ")";
    }
}
