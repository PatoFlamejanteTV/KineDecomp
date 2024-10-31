package org.koin.core.scope;

import java.util.HashSet;
import kotlin.jvm.internal.h;

/* compiled from: ScopeDefinition.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<org.koin.core.definition.b<?>> f29389a;

    /* renamed from: b, reason: collision with root package name */
    private final org.koin.core.e.a f29390b;

    public b(org.koin.core.e.a aVar) {
        h.b(aVar, "qualifier");
        this.f29390b = aVar;
        this.f29389a = new HashSet<>();
    }

    public final HashSet<org.koin.core.definition.b<?>> a() {
        return this.f29389a;
    }

    public final org.koin.core.e.a b() {
        return this.f29390b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && h.a(this.f29390b, ((b) obj).f29390b);
        }
        return true;
    }

    public int hashCode() {
        org.koin.core.e.a aVar = this.f29390b;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ScopeDefinition(qualifier=" + this.f29390b + ")";
    }
}
