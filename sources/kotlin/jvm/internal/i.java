package kotlin.jvm.internal;

/* compiled from: PackageReference.kt */
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a */
    private final Class<?> f28540a;

    /* renamed from: b */
    private final String f28541b;

    public i(Class<?> cls, String str) {
        h.b(cls, "jClass");
        h.b(str, "moduleName");
        this.f28540a = cls;
        this.f28541b = str;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f28540a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.a(a(), ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
