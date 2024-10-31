package kotlin.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: Continuation.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final <T> void a(kotlin.jvm.a.b<? super b<? super T>, ? extends Object> bVar, b<? super T> bVar2) {
        b<k> a2;
        b a3;
        h.b(bVar, "$this$startCoroutine");
        h.b(bVar2, "completion");
        a2 = kotlin.coroutines.intrinsics.b.a(bVar, bVar2);
        a3 = kotlin.coroutines.intrinsics.b.a(a2);
        k kVar = k.f28545a;
        Result.a aVar = Result.Companion;
        Result.m23constructorimpl(kVar);
        a3.resumeWith(kVar);
    }

    public static final <R, T> void a(kotlin.jvm.a.c<? super R, ? super b<? super T>, ? extends Object> cVar, R r, b<? super T> bVar) {
        b<k> a2;
        b a3;
        h.b(cVar, "$this$startCoroutine");
        h.b(bVar, "completion");
        a2 = kotlin.coroutines.intrinsics.b.a(cVar, r, bVar);
        a3 = kotlin.coroutines.intrinsics.b.a(a2);
        k kVar = k.f28545a;
        Result.a aVar = Result.Companion;
        Result.m23constructorimpl(kVar);
        a3.resumeWith(kVar);
    }
}
