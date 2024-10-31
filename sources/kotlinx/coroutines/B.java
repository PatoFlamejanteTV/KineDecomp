package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;

/* compiled from: Dispatched.kt */
/* loaded from: classes3.dex */
public final class B {

    /* renamed from: a */
    private static final kotlinx.coroutines.internal.q f28576a = new kotlinx.coroutines.internal.q("UNDEFINED");

    public static final /* synthetic */ kotlinx.coroutines.internal.q a() {
        return f28576a;
    }

    public static final <T> void a(kotlin.coroutines.b<? super T> bVar, T t) {
        boolean z;
        kotlin.jvm.internal.h.b(bVar, "receiver$0");
        if (bVar instanceof A) {
            A a2 = (A) bVar;
            if (a2.f28574g.b(a2.getContext())) {
                a2.f28571d = t;
                a2.f28577c = 1;
                a2.f28574g.a(a2.getContext(), a2);
                return;
            }
            G a3 = ga.f28622b.a();
            if (a3.v()) {
                a2.f28571d = t;
                a2.f28577c = 1;
                a3.a((C<?>) a2);
                return;
            }
            a3.b(true);
            try {
                try {
                    P p = (P) a2.getContext().get(P.f28600c);
                    if (p == null || p.isActive()) {
                        z = false;
                    } else {
                        CancellationException b2 = p.b();
                        Result.a aVar = Result.Companion;
                        Object a4 = kotlin.h.a((Throwable) b2);
                        Result.m23constructorimpl(a4);
                        a2.resumeWith(a4);
                        z = true;
                    }
                    if (!z) {
                        kotlin.coroutines.e context = a2.getContext();
                        Object b3 = kotlinx.coroutines.internal.s.b(context, a2.f28573f);
                        try {
                            kotlin.coroutines.b<T> bVar2 = a2.f28575h;
                            Result.a aVar2 = Result.Companion;
                            Result.m23constructorimpl(t);
                            bVar2.resumeWith(t);
                            kotlin.k kVar = kotlin.k.f28545a;
                            kotlinx.coroutines.internal.s.a(context, b3);
                        } catch (Throwable th) {
                            kotlinx.coroutines.internal.s.a(context, b3);
                            throw th;
                        }
                    }
                    do {
                    } while (a3.x());
                    return;
                } catch (Throwable th2) {
                    throw new DispatchException("Unexpected exception in unconfined event loop", th2);
                }
            } finally {
                a3.a(true);
            }
        }
        Result.a aVar3 = Result.Companion;
        Result.m23constructorimpl(t);
        bVar.resumeWith(t);
    }
}
