package org.koin.core.scope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.reflect.c;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;

/* compiled from: Scope.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final org.koin.core.f.a f29383a;

    /* renamed from: b, reason: collision with root package name */
    private b f29384b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<Object> f29385c;

    /* renamed from: d, reason: collision with root package name */
    private final String f29386d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f29387e;

    /* renamed from: f, reason: collision with root package name */
    private final org.koin.core.a f29388f;

    public a(String str, boolean z, org.koin.core.a aVar) {
        h.b(str, "id");
        h.b(aVar, "_koin");
        this.f29386d = str;
        this.f29387e = z;
        this.f29388f = aVar;
        this.f29383a = new org.koin.core.f.a();
        this.f29385c = new ArrayList<>();
    }

    public final org.koin.core.f.a b() {
        return this.f29383a;
    }

    public final String c() {
        return this.f29386d;
    }

    public final b d() {
        return this.f29384b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (h.a((Object) this.f29386d, (Object) aVar.f29386d)) {
                    if (!(this.f29387e == aVar.f29387e) || !h.a(this.f29388f, aVar.f29388f)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f29386d;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.f29387e;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        org.koin.core.a aVar = this.f29388f;
        return i2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        b bVar = this.f29384b;
        StringBuilder sb = new StringBuilder();
        sb.append(",set:'");
        sb.append(bVar != null ? bVar.b() : null);
        sb.append('\'');
        return "Scope[id:'" + this.f29386d + '\'' + sb.toString() + ']';
    }

    public final <T> T a(final c<?> cVar, final org.koin.core.e.a aVar, final kotlin.jvm.a.a<org.koin.core.d.a> aVar2) {
        h.b(cVar, "clazz");
        synchronized (this) {
            if (org.koin.core.b.f29345b.b().a(Level.DEBUG)) {
                org.koin.core.b.f29345b.b().a("+- get '" + g.a.c.a.a(cVar) + '\'');
                Pair a2 = org.koin.core.g.a.a(new kotlin.jvm.a.a<T>() { // from class: org.koin.core.scope.Scope$get$$inlined$synchronized$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.a.a
                    public final T invoke() {
                        Object a3;
                        a3 = a.this.a(aVar, (c<?>) cVar, (kotlin.jvm.a.a<org.koin.core.d.a>) aVar2);
                        return (T) a3;
                    }
                });
                T t = (T) a2.component1();
                double doubleValue = ((Number) a2.component2()).doubleValue();
                org.koin.core.b.f29345b.b().a("+- got '" + g.a.c.a.a(cVar) + "' in " + doubleValue + " ms");
                return t;
            }
            return (T) a(aVar, cVar, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T a(org.koin.core.e.a aVar, c<?> cVar, kotlin.jvm.a.a<org.koin.core.d.a> aVar2) {
        return (T) a(aVar, cVar).a(new org.koin.core.b.c(this.f29388f, this, aVar2));
    }

    private final org.koin.core.definition.b<?> a(org.koin.core.e.a aVar, c<?> cVar) {
        org.koin.core.definition.b<?> a2 = this.f29383a.a(aVar, cVar);
        if (a2 != null) {
            return a2;
        }
        if (!this.f29387e) {
            return this.f29388f.b().a(aVar, cVar);
        }
        throw new NoBeanDefFoundException("No definition found for '" + g.a.c.a.a(cVar) + "' has been found. Check your module definitions.");
    }

    public final void a() {
        if (this.f29387e) {
            Set<org.koin.core.definition.b<?>> a2 = this.f29383a.a();
            if (!a2.isEmpty()) {
                Iterator<T> it = a2.iterator();
                while (it.hasNext()) {
                    ((org.koin.core.definition.b) it.next()).a(new org.koin.core.b.c(this.f29388f, this, null, 4, null));
                }
            }
        }
    }
}
