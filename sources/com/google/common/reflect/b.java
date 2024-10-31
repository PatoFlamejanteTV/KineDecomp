package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Element.java */
/* loaded from: classes2.dex */
public class b extends AccessibleObject implements Member {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibleObject f16087a;

    /* renamed from: b, reason: collision with root package name */
    private final Member f16088b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public <M extends AccessibleObject & Member> b(M m) {
        Preconditions.a(m);
        this.f16087a = m;
        this.f16088b = m;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a().equals(bVar.a()) && this.f16088b.equals(bVar.f16088b);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f16087a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f16087a.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f16087a.getDeclaredAnnotations();
    }

    public Class<?> getDeclaringClass() {
        return this.f16088b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f16088b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f16088b.getName();
    }

    public int hashCode() {
        return this.f16088b.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f16087a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f16087a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f16088b.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        this.f16087a.setAccessible(z);
    }

    public String toString() {
        return this.f16088b.toString();
    }
}
