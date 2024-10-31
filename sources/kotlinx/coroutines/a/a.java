package kotlinx.coroutines.a;

import kotlin.Result;
import kotlin.jvm.a.c;
import kotlin.jvm.internal.h;
import kotlin.k;
import kotlinx.coroutines.B;

/* compiled from: Cancellable.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <T> void a(kotlin.jvm.a.b<? super kotlin.coroutines.b<? super T>, ? extends Object> bVar, kotlin.coroutines.b<? super T> bVar2) {
        h.b(bVar, "receiver$0");
        h.b(bVar2, "completion");
        try {
            B.a(kotlin.coroutines.intrinsics.a.a(kotlin.coroutines.intrinsics.a.a(bVar, bVar2)), k.f28545a);
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            Object a2 = kotlin.h.a(th);
            Result.m23constructorimpl(a2);
            bVar2.resumeWith(a2);
        }
    }

    public static final <R, T> void a(c<? super R, ? super kotlin.coroutines.b<? super T>, ? extends Object> cVar, R r, kotlin.coroutines.b<? super T> bVar) {
        h.b(cVar, "receiver$0");
        h.b(bVar, "completion");
        try {
            B.a(kotlin.coroutines.intrinsics.a.a(kotlin.coroutines.intrinsics.a.a(cVar, r, bVar)), k.f28545a);
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            Object a2 = kotlin.h.a(th);
            Result.m23constructorimpl(a2);
            bVar.resumeWith(a2);
        }
    }
}
