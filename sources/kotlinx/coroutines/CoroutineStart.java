package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes3.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(kotlin.jvm.a.b<? super kotlin.coroutines.b<? super T>, ? extends Object> bVar, kotlin.coroutines.b<? super T> bVar2) {
        kotlin.jvm.internal.h.b(bVar, "block");
        kotlin.jvm.internal.h.b(bVar2, "completion");
        int i = C2552v.f28724a[ordinal()];
        if (i == 1) {
            kotlinx.coroutines.a.a.a(bVar, bVar2);
            return;
        }
        if (i == 2) {
            kotlin.coroutines.d.a(bVar, bVar2);
        } else if (i == 3) {
            kotlinx.coroutines.a.b.a(bVar, bVar2);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    public final <R, T> void invoke(kotlin.jvm.a.c<? super R, ? super kotlin.coroutines.b<? super T>, ? extends Object> cVar, R r, kotlin.coroutines.b<? super T> bVar) {
        kotlin.jvm.internal.h.b(cVar, "block");
        kotlin.jvm.internal.h.b(bVar, "completion");
        int i = C2552v.f28725b[ordinal()];
        if (i == 1) {
            kotlinx.coroutines.a.a.a(cVar, r, bVar);
            return;
        }
        if (i == 2) {
            kotlin.coroutines.d.a(cVar, r, bVar);
        } else if (i == 3) {
            kotlinx.coroutines.a.b.a(cVar, r, bVar);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
