package org.koin.core.b;

import java.util.ArrayList;
import kotlin.collections.t;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.w;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;

/* compiled from: DefinitionInstance.kt */
/* loaded from: classes3.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final C0170a f29347a = new C0170a(null);

    /* renamed from: b, reason: collision with root package name */
    private final org.koin.core.definition.b<T> f29348b;

    /* compiled from: DefinitionInstance.kt */
    /* renamed from: org.koin.core.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0170a {
        private C0170a() {
        }

        public /* synthetic */ C0170a(f fVar) {
            this();
        }
    }

    public a(org.koin.core.definition.b<T> bVar) {
        h.b(bVar, "beanDefinition");
        this.f29348b = bVar;
    }

    public final org.koin.core.definition.b<T> a() {
        return this.f29348b;
    }

    public abstract <T> T b(c cVar);

    public <T> T a(c cVar) {
        String a2;
        boolean a3;
        h.b(cVar, com.umeng.analytics.pro.b.Q);
        if (org.koin.core.b.f29345b.b().a(Level.DEBUG)) {
            org.koin.core.b.f29345b.b().a("| create instance for " + this.f29348b);
        }
        try {
            org.koin.core.d.a b2 = cVar.b();
            kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, T> b3 = this.f29348b.b();
            org.koin.core.scope.a c2 = cVar.c();
            if (c2 != null) {
                return b3.invoke(c2, b2);
            }
            throw new IllegalStateException("Can't execute definition instance while this context is not registered against any Koin instance");
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(e2.toString());
            sb.append("\n\t");
            StackTraceElement[] stackTrace = e2.getStackTrace();
            h.a((Object) stackTrace, "e.stackTrace");
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement stackTraceElement : stackTrace) {
                h.a((Object) stackTraceElement, "it");
                String className = stackTraceElement.getClassName();
                h.a((Object) className, "it.className");
                a3 = w.a((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null);
                if (!(!a3)) {
                    break;
                }
                arrayList.add(stackTraceElement);
            }
            a2 = t.a(arrayList, "\n\t", null, null, 0, null, null, 62, null);
            sb.append(a2);
            org.koin.core.b.f29345b.b().b("Instance creation error : could not create instance for " + this.f29348b + ": " + sb.toString());
            throw new InstanceCreationException("Could not create instance for " + this.f29348b, e2);
        }
    }
}
