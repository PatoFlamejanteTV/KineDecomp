package kotlinx.coroutines.a;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.a.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.internal.s;

/* compiled from: Undispatched.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <T> void a(kotlin.jvm.a.b<? super kotlin.coroutines.b<? super T>, ? extends Object> bVar, kotlin.coroutines.b<? super T> bVar2) {
        h.b(bVar, "receiver$0");
        h.b(bVar2, "completion");
        e.a(bVar2);
        try {
            kotlin.coroutines.e context = bVar2.getContext();
            Object b2 = s.b(context, null);
            try {
                m.a(bVar, 1);
                Object invoke = bVar.invoke(bVar2);
                if (invoke != kotlin.coroutines.intrinsics.a.a()) {
                    Result.a aVar = Result.Companion;
                    Result.m23constructorimpl(invoke);
                    bVar2.resumeWith(invoke);
                }
            } finally {
                s.a(context, b2);
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Object a2 = kotlin.h.a(th);
            Result.m23constructorimpl(a2);
            bVar2.resumeWith(a2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> void a(c<? super R, ? super kotlin.coroutines.b<? super T>, ? extends Object> cVar, R r, kotlin.coroutines.b<? super T> bVar) {
        h.b(cVar, "receiver$0");
        h.b(bVar, "completion");
        e.a(bVar);
        try {
            kotlin.coroutines.e context = bVar.getContext();
            Object b2 = s.b(context, null);
            try {
                m.a(cVar, 2);
                Object invoke = cVar.invoke(r, bVar);
                if (invoke != kotlin.coroutines.intrinsics.a.a()) {
                    Result.a aVar = Result.Companion;
                    Result.m23constructorimpl(invoke);
                    bVar.resumeWith(invoke);
                }
            } finally {
                s.a(context, b2);
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Object a2 = kotlin.h.a(th);
            Result.m23constructorimpl(a2);
            bVar.resumeWith(a2);
        }
    }
}
