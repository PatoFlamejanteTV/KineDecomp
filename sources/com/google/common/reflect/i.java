package com.google.common.reflect;

import com.google.common.reflect.Invokable;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
public class i<T> extends Invokable.b<T> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken f16095d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TypeToken typeToken, Method method) {
        super(method);
        this.f16095d = typeToken;
    }

    @Override // com.google.common.reflect.Invokable, com.google.common.reflect.b
    public TypeToken<T> a() {
        return this.f16095d;
    }

    @Override // com.google.common.reflect.Invokable, com.google.common.reflect.b
    public String toString() {
        return a() + "." + super.toString();
    }
}
