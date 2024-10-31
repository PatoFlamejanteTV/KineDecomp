package kotlin.jvm.internal;

/* compiled from: ClassReference.kt */
/* loaded from: classes.dex */
public final class d implements kotlin.reflect.c<Object>, c {

    /* renamed from: a */
    private final Class<?> f28538a;

    public d(Class<?> cls) {
        h.b(cls, "jClass");
        this.f28538a = cls;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f28538a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && h.a(kotlin.jvm.a.b(this), kotlin.jvm.a.b((kotlin.reflect.c) obj));
    }

    @Override // kotlin.reflect.c
    public int hashCode() {
        return kotlin.jvm.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
