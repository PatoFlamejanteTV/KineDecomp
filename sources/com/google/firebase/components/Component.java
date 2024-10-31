package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class Component<T> {

    /* renamed from: a */
    private final Set<Class<? super T>> f16563a;

    /* renamed from: b */
    private final Set<Dependency> f16564b;

    /* renamed from: c */
    private final int f16565c;

    /* renamed from: d */
    private final ComponentFactory<T> f16566d;

    /* renamed from: e */
    private final Set<Class<?>> f16567e;

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class Builder<T> {

        /* renamed from: a */
        private final Set<Class<? super T>> f16568a;

        /* renamed from: b */
        private final Set<Dependency> f16569b;

        /* renamed from: c */
        private int f16570c;

        /* renamed from: d */
        private ComponentFactory<T> f16571d;

        /* renamed from: e */
        private Set<Class<?>> f16572e;

        /* synthetic */ Builder(Class cls, Class[] clsArr, c cVar) {
            this(cls, clsArr);
        }

        @KeepForSdk
        public Builder<T> a(Dependency dependency) {
            Preconditions.a(dependency, "Null dependency");
            a(dependency.a());
            this.f16569b.add(dependency);
            return this;
        }

        @KeepForSdk
        public Component<T> b() {
            Preconditions.b(this.f16571d != null, "Missing required property: factory.");
            return new Component<>(new HashSet(this.f16568a), new HashSet(this.f16569b), this.f16570c, this.f16571d, this.f16572e);
        }

        @KeepForSdk
        public Builder<T> c() {
            a(2);
            return this;
        }

        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.f16568a = new HashSet();
            this.f16569b = new HashSet();
            this.f16570c = 0;
            this.f16572e = new HashSet();
            Preconditions.a(cls, "Null interface");
            this.f16568a.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.a(cls2, "Null interface");
            }
            Collections.addAll(this.f16568a, clsArr);
        }

        @KeepForSdk
        public Builder<T> a() {
            a(1);
            return this;
        }

        private Builder<T> a(int i) {
            Preconditions.b(this.f16570c == 0, "Instantiation type has already been set.");
            this.f16570c = i;
            return this;
        }

        private void a(Class<?> cls) {
            Preconditions.a(!this.f16568a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @KeepForSdk
        public Builder<T> a(ComponentFactory<T> componentFactory) {
            Preconditions.a(componentFactory, "Null factory");
            this.f16571d = componentFactory;
            return this;
        }
    }

    /* synthetic */ Component(Set set, Set set2, int i, ComponentFactory componentFactory, Set set3, c cVar) {
        this(set, set2, i, componentFactory, set3);
    }

    public static /* synthetic */ Object a(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    public Set<Dependency> a() {
        return this.f16564b;
    }

    public ComponentFactory<T> b() {
        return this.f16566d;
    }

    public Set<Class<? super T>> c() {
        return this.f16563a;
    }

    public Set<Class<?>> d() {
        return this.f16567e;
    }

    public boolean e() {
        return this.f16565c == 1;
    }

    public boolean f() {
        return this.f16565c == 2;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f16563a.toArray()) + ">{" + this.f16565c + ", deps=" + Arrays.toString(this.f16564b.toArray()) + "}";
    }

    private Component(Set<Class<? super T>> set, Set<Dependency> set2, int i, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f16563a = Collections.unmodifiableSet(set);
        this.f16564b = Collections.unmodifiableSet(set2);
        this.f16565c = i;
        this.f16566d = componentFactory;
        this.f16567e = Collections.unmodifiableSet(set3);
    }

    @KeepForSdk
    public static <T> Builder<T> a(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    @KeepForSdk
    public static <T> Builder<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    @SafeVarargs
    @KeepForSdk
    public static <T> Component<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        return a(cls, clsArr).a(b.a(t)).b();
    }
}
