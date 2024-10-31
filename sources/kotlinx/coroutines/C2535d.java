package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* renamed from: kotlinx.coroutines.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2535d {
    public static /* synthetic */ P a(InterfaceC2550t interfaceC2550t, kotlin.coroutines.e eVar, CoroutineStart coroutineStart, kotlin.jvm.a.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            eVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C2534c.a(interfaceC2550t, eVar, coroutineStart, cVar);
    }

    public static final P a(InterfaceC2550t interfaceC2550t, kotlin.coroutines.e eVar, CoroutineStart coroutineStart, kotlin.jvm.a.c<? super InterfaceC2550t, ? super kotlin.coroutines.b<? super kotlin.k>, ? extends Object> cVar) {
        AbstractC2532a eaVar;
        kotlin.jvm.internal.h.b(interfaceC2550t, "receiver$0");
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(coroutineStart, "start");
        kotlin.jvm.internal.h.b(cVar, "block");
        kotlin.coroutines.e a2 = C2545n.a(interfaceC2550t, eVar);
        if (coroutineStart.isLazy()) {
            eaVar = new Z(a2, cVar);
        } else {
            eaVar = new ea(a2, true);
        }
        eaVar.a(coroutineStart, (CoroutineStart) eaVar, (kotlin.jvm.a.c<? super CoroutineStart, ? super kotlin.coroutines.b<? super T>, ? extends Object>) cVar);
        return eaVar;
    }
}
