package g.a.b;

import java.util.HashSet;
import kotlin.jvm.internal.h;

/* compiled from: ScopeSet.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<org.koin.core.definition.b<?>> f26773a;

    /* renamed from: b, reason: collision with root package name */
    private final org.koin.core.e.a f26774b;

    public final org.koin.core.scope.b a() {
        org.koin.core.scope.b bVar = new org.koin.core.scope.b(this.f26774b);
        bVar.a().addAll(this.f26773a);
        return bVar;
    }

    public final HashSet<org.koin.core.definition.b<?>> b() {
        return this.f26773a;
    }

    public final org.koin.core.e.a c() {
        return this.f26774b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && h.a(this.f26774b, ((b) obj).f26774b);
        }
        return true;
    }

    public int hashCode() {
        org.koin.core.e.a aVar = this.f26774b;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Scope['" + this.f26774b + "']";
    }
}
