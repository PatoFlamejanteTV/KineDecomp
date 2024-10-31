package org.koin.core.f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;

/* compiled from: BeanRegistry.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<org.koin.core.definition.b<?>> f29374a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, org.koin.core.definition.b<?>> f29375b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<kotlin.reflect.c<?>, org.koin.core.definition.b<?>> f29376c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<kotlin.reflect.c<?>, ArrayList<org.koin.core.definition.b<?>>> f29377d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final HashSet<org.koin.core.definition.b<?>> f29378e = new HashSet<>();

    private final void a(org.koin.core.c.a aVar) {
        Iterator<T> it = aVar.a().iterator();
        while (it.hasNext()) {
            a((org.koin.core.definition.b<?>) it.next());
        }
    }

    private final void c(org.koin.core.definition.b<?> bVar) {
        Iterator<T> it = bVar.g().iterator();
        while (it.hasNext()) {
            a(bVar, (kotlin.reflect.c<?>) it.next());
        }
    }

    private final void d(org.koin.core.definition.b<?> bVar) {
        this.f29378e.add(bVar);
    }

    private final void e(org.koin.core.definition.b<?> bVar) {
        a(bVar.d(), bVar);
    }

    public final Set<org.koin.core.definition.b<?>> b() {
        return this.f29374a;
    }

    private final void b(org.koin.core.definition.b<?> bVar) {
        org.koin.core.e.a e2 = bVar.e();
        if (e2 != null) {
            if (this.f29375b.get(e2.toString()) != null && !bVar.c().a()) {
                throw new DefinitionOverrideException("Already existing definition or try to override an existing one with qualifier '" + e2 + "' with " + bVar + " but has already registered " + this.f29375b.get(e2.toString()));
            }
            this.f29375b.put(e2.toString(), bVar);
            if (org.koin.core.b.f29345b.b().a(Level.INFO)) {
                org.koin.core.b.f29345b.b().c("bind qualifier:'" + bVar.e() + "' ~ " + bVar);
            }
        }
    }

    private final org.koin.core.definition.b<?> c(kotlin.reflect.c<?> cVar) {
        return this.f29376c.get(cVar);
    }

    public final void a(org.koin.core.definition.b<?> bVar) {
        h.b(bVar, "definition");
        a(this.f29374a, bVar);
        bVar.a();
        if (bVar.e() != null) {
            b(bVar);
        } else {
            e(bVar);
        }
        if (!bVar.g().isEmpty()) {
            c(bVar);
        }
        if (bVar.c().b()) {
            d(bVar);
        }
    }

    private final org.koin.core.definition.b<?> b(kotlin.reflect.c<?> cVar) {
        ArrayList<org.koin.core.definition.b<?>> arrayList = this.f29377d.get(cVar);
        if (arrayList != null && arrayList.size() == 1) {
            return arrayList.get(0);
        }
        if (arrayList == null || arrayList.size() <= 1) {
            return null;
        }
        throw new NoBeanDefFoundException("Found multiple definitions for type '" + g.a.c.a.a(cVar) + "': " + arrayList + ". Please use the 'bind<P,S>()' function to bind your instance from primary and secondary types.");
    }

    private final void a(org.koin.core.definition.b<?> bVar, kotlin.reflect.c<?> cVar) {
        ArrayList<org.koin.core.definition.b<?>> arrayList = this.f29377d.get(cVar);
        if (arrayList == null) {
            arrayList = a(cVar);
        }
        arrayList.add(bVar);
        if (org.koin.core.b.f29345b.b().a(Level.INFO)) {
            org.koin.core.b.f29345b.b().c("bind secondary type:'" + g.a.c.a.a(cVar) + "' ~ " + bVar);
        }
    }

    private final ArrayList<org.koin.core.definition.b<?>> a(kotlin.reflect.c<?> cVar) {
        this.f29377d.put(cVar, new ArrayList<>());
        ArrayList<org.koin.core.definition.b<?>> arrayList = this.f29377d.get(cVar);
        if (arrayList != null) {
            return arrayList;
        }
        h.a();
        throw null;
    }

    private final void a(HashSet<org.koin.core.definition.b<?>> hashSet, org.koin.core.definition.b<?> bVar) {
        if (hashSet.add(bVar) || bVar.c().a()) {
            return;
        }
        throw new DefinitionOverrideException("Already existing definition or try to override an existing one: " + bVar);
    }

    private final void a(kotlin.reflect.c<?> cVar, org.koin.core.definition.b<?> bVar) {
        if (this.f29376c.get(cVar) != null && !bVar.c().a()) {
            throw new DefinitionOverrideException("Already existing definition or try to override an existing one with type '" + cVar + "' and " + bVar + " but has already registered " + this.f29376c.get(cVar));
        }
        this.f29376c.put(cVar, bVar);
        if (org.koin.core.b.f29345b.b().a(Level.INFO)) {
            org.koin.core.b.f29345b.b().c("bind type:'" + g.a.c.a.a(cVar) + "' ~ " + bVar);
        }
    }

    public final org.koin.core.definition.b<?> a(org.koin.core.e.a aVar, kotlin.reflect.c<?> cVar) {
        h.b(cVar, "clazz");
        if (aVar != null) {
            return a(aVar.toString());
        }
        org.koin.core.definition.b<?> c2 = c(cVar);
        return c2 != null ? c2 : b(cVar);
    }

    private final org.koin.core.definition.b<?> a(String str) {
        return this.f29375b.get(str);
    }

    public final Set<org.koin.core.definition.b<?>> a() {
        return this.f29378e;
    }

    public final void a(Iterable<org.koin.core.c.a> iterable) {
        h.b(iterable, "modules");
        Iterator<org.koin.core.c.a> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
