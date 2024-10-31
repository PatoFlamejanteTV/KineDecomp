package org.koin.core.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;

/* compiled from: ScopeRegistry.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, org.koin.core.scope.b> f29380a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, org.koin.core.scope.a> f29381b = new ConcurrentHashMap<>();

    public final Collection<org.koin.core.scope.b> a() {
        Collection<org.koin.core.scope.b> values = this.f29380a.values();
        h.a((Object) values, "definitions.values");
        return values;
    }

    public final void a(org.koin.core.a aVar) {
        h.b(aVar, "koin");
        a(aVar.b());
    }

    private final void a(org.koin.core.c.a aVar) {
        Iterator<T> it = aVar.b().iterator();
        while (it.hasNext()) {
            a((g.a.b.b) it.next());
        }
    }

    private final void a(g.a.b.b bVar) {
        org.koin.core.scope.b bVar2 = this.f29380a.get(bVar.c().toString());
        if (bVar2 == null) {
            this.f29380a.put(bVar.c().toString(), bVar.a());
        } else {
            bVar2.a().addAll(bVar.b());
        }
    }

    private final void a(org.koin.core.scope.a aVar) {
        this.f29381b.put(aVar.c(), aVar);
    }

    public final void a(Iterable<org.koin.core.c.a> iterable) {
        h.b(iterable, "modules");
        Iterator<org.koin.core.c.a> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
