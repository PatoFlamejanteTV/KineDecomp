package org.koin.core.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.h;
import org.koin.core.error.BadScopeInstanceException;
import org.koin.core.error.ScopeNotCreatedException;

/* compiled from: ScopeDefinitionInstance.kt */
/* loaded from: classes3.dex */
public final class d<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, T> f29353c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(org.koin.core.definition.b<T> bVar) {
        super(bVar);
        h.b(bVar, "beanDefinition");
        this.f29353c = new ConcurrentHashMap();
    }

    private final void a(org.koin.core.definition.b<?> bVar, org.koin.core.scope.a aVar) {
        org.koin.core.scope.b d2 = aVar.d();
        org.koin.core.e.a b2 = d2 != null ? d2.b() : null;
        org.koin.core.e.a f2 = bVar.f();
        if (!h.a(f2, b2)) {
            if (b2 == null) {
                throw new BadScopeInstanceException("Can't use definition " + bVar + " defined for scope '" + f2 + "', with an open scope instance " + aVar + ". Use a scope instance with scope '" + f2 + '\'');
            }
            if (f2 == null) {
                return;
            }
            throw new BadScopeInstanceException("Can't use definition " + bVar + " defined for scope '" + f2 + "' with scope instance " + aVar + ". Use a scope instance with scope '" + f2 + "'.");
        }
    }

    @Override // org.koin.core.b.a
    public <T> T b(c cVar) {
        h.b(cVar, com.umeng.analytics.pro.b.Q);
        if (cVar.a() != null) {
            if (!h.a(cVar.c(), cVar.a().b())) {
                org.koin.core.scope.a c2 = cVar.c();
                if (c2 != null) {
                    a(a(), c2);
                    String c3 = c2.c();
                    T t = this.f29353c.get(c3);
                    if (t == null) {
                        t = a(cVar);
                        Map<String, T> map = this.f29353c;
                        if (t == null) {
                            throw new IllegalStateException(("Instance creation from " + a() + " should not be null").toString());
                        }
                        map.put(c3, t);
                    }
                    return t;
                }
                throw new IllegalStateException("ScopeDefinitionInstance has no scope in context");
            }
            throw new ScopeNotCreatedException("No scope instance created to resolve " + a());
        }
        throw new IllegalStateException("ScopeDefinitionInstance has no registered Koin instance");
    }
}
