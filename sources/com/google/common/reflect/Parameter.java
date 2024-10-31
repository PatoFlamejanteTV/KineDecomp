package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class Parameter implements AnnotatedElement {

    /* renamed from: a, reason: collision with root package name */
    private final Invokable<?, ?> f16058a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16059b;

    /* renamed from: c, reason: collision with root package name */
    private final TypeToken<?> f16060c;

    /* renamed from: d, reason: collision with root package name */
    private final ImmutableList<Annotation> f16061d;

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        return this.f16059b == parameter.f16059b && this.f16058a.equals(parameter.f16058a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @Nullable
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Preconditions.a(cls);
        Iterator it = this.f16061d.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @Nullable
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        Preconditions.a(cls);
        return (A) FluentIterable.a(this.f16061d).a(cls).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        ImmutableList<Annotation> immutableList = this.f16061d;
        return (Annotation[]) immutableList.toArray(new Annotation[immutableList.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) FluentIterable.a(this.f16061d).a(cls).b(cls));
    }

    public int hashCode() {
        return this.f16059b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        return this.f16060c + " arg" + this.f16059b;
    }
}
