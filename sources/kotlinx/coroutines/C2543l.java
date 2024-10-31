package kotlinx.coroutines;

import kotlin.Result;

/* compiled from: CompletedExceptionally.kt */
/* renamed from: kotlinx.coroutines.l */
/* loaded from: classes3.dex */
public final class C2543l {
    public static final <T> Object a(Object obj) {
        if (Result.m29isSuccessimpl(obj)) {
            kotlin.h.a(obj);
            return obj;
        }
        Throwable m26exceptionOrNullimpl = Result.m26exceptionOrNullimpl(obj);
        if (m26exceptionOrNullimpl != null) {
            return new C2542k(m26exceptionOrNullimpl);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
