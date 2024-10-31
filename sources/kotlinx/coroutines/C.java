package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.TypeCastException;

/* compiled from: Dispatched.kt */
/* loaded from: classes3.dex */
public abstract class C<T> extends kotlinx.coroutines.scheduling.h {

    /* renamed from: c, reason: collision with root package name */
    public int f28577c;

    public C(int i) {
        this.f28577c = i;
    }

    public final Throwable a(Object obj) {
        if (!(obj instanceof C2542k)) {
            obj = null;
        }
        C2542k c2542k = (C2542k) obj;
        if (c2542k != null) {
            return c2542k.f28670a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(Object obj) {
        return obj;
    }

    public abstract kotlin.coroutines.b<T> c();

    public abstract Object d();

    @Override // java.lang.Runnable
    public final void run() {
        kotlinx.coroutines.scheduling.i iVar = this.f28711b;
        try {
            try {
                kotlin.coroutines.b<T> c2 = c();
                if (c2 != null) {
                    A a2 = (A) c2;
                    kotlin.coroutines.b<T> bVar = a2.f28575h;
                    kotlin.coroutines.e context = bVar.getContext();
                    P p = da.a(this.f28577c) ? (P) context.get(P.f28600c) : null;
                    Object d2 = d();
                    Object b2 = kotlinx.coroutines.internal.s.b(context, a2.f28573f);
                    if (p != null) {
                        try {
                            if (!p.isActive()) {
                                CancellationException b3 = p.b();
                                Result.a aVar = Result.Companion;
                                Object a3 = kotlin.h.a((Throwable) b3);
                                Result.m23constructorimpl(a3);
                                bVar.resumeWith(a3);
                                kotlin.k kVar = kotlin.k.f28545a;
                                return;
                            }
                        } finally {
                            kotlinx.coroutines.internal.s.a(context, b2);
                        }
                    }
                    Throwable a4 = a(d2);
                    if (a4 != null) {
                        Result.a aVar2 = Result.Companion;
                        Object a5 = kotlin.h.a(kotlinx.coroutines.internal.p.a(a4, (kotlin.coroutines.b<?>) bVar));
                        Result.m23constructorimpl(a5);
                        bVar.resumeWith(a5);
                    } else {
                        b(d2);
                        Result.a aVar3 = Result.Companion;
                        Result.m23constructorimpl(d2);
                        bVar.resumeWith(d2);
                    }
                    kotlin.k kVar2 = kotlin.k.f28545a;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            } catch (Throwable th) {
                throw new DispatchException("Unexpected exception running " + this, th);
            }
        } finally {
            iVar.r();
        }
    }
}
