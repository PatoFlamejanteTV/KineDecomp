package org.koin.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.l;
import kotlin.collections.t;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;
import org.koin.core.logger.Level;

/* compiled from: KoinApplication.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    private final org.koin.core.a f29346c;

    /* renamed from: b, reason: collision with root package name */
    public static final a f29345b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private static org.koin.core.logger.b f29344a = new org.koin.core.logger.a();

    /* compiled from: KoinApplication.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final void a(org.koin.core.logger.b bVar) {
            h.b(bVar, "<set-?>");
            b.f29344a = bVar;
        }

        public final org.koin.core.logger.b b() {
            return b.f29344a;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b a() {
            b bVar = new b(null);
            bVar.d();
            return bVar;
        }
    }

    private b() {
        this.f29346c = new org.koin.core.a();
    }

    public final b b() {
        if (f29344a.a(Level.DEBUG)) {
            double b2 = org.koin.core.g.a.b(new kotlin.jvm.a.a<k>() { // from class: org.koin.core.KoinApplication$createEagerInstances$duration$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ k invoke() {
                    invoke2();
                    return k.f28545a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b.this.c().a();
                }
            });
            f29344a.a("instances started in " + b2 + " ms");
        } else {
            this.f29346c.a();
        }
        return this;
    }

    public final org.koin.core.a c() {
        return this.f29346c;
    }

    public final void d() {
        this.f29346c.c().a(this.f29346c);
    }

    public /* synthetic */ b(f fVar) {
        this();
    }

    public final b a(org.koin.core.c.a aVar) {
        List<org.koin.core.c.a> a2;
        h.b(aVar, "modules");
        a2 = j.a(aVar);
        a(a2);
        return this;
    }

    public final b a(final List<org.koin.core.c.a> list) {
        int a2;
        int d2;
        h.b(list, "modules");
        if (f29344a.a(Level.INFO)) {
            double b2 = org.koin.core.g.a.b(new kotlin.jvm.a.a<k>() { // from class: org.koin.core.KoinApplication$modules$duration$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ k invoke() {
                    invoke2();
                    return k.f28545a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    b.this.a((Iterable<org.koin.core.c.a>) list);
                }
            });
            int size = this.f29346c.b().b().b().size();
            Collection<org.koin.core.scope.b> a3 = this.f29346c.c().a();
            a2 = l.a(a3, 10);
            ArrayList arrayList = new ArrayList(a2);
            Iterator<T> it = a3.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((org.koin.core.scope.b) it.next()).a().size()));
            }
            d2 = t.d((Iterable<Integer>) arrayList);
            int i = size + d2;
            f29344a.c("total " + i + " registered definitions");
            f29344a.c("load modules in " + b2 + " ms");
        } else {
            a((Iterable<org.koin.core.c.a>) list);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Iterable<org.koin.core.c.a> iterable) {
        this.f29346c.b().b().a(iterable);
        this.f29346c.c().a(iterable);
    }
}
