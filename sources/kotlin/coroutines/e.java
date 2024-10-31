package kotlin.coroutines;

import kotlin.TypeCastException;
import kotlin.coroutines.e;
import kotlin.jvm.internal.h;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public interface e {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static e a(e eVar, e eVar2) {
            h.b(eVar2, com.umeng.analytics.pro.b.Q);
            return eVar2 == EmptyCoroutineContext.INSTANCE ? eVar : (e) eVar2.fold(eVar, new kotlin.jvm.a.c<e, b, e>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // kotlin.jvm.a.c
                public final e invoke(e eVar3, e.b bVar) {
                    h.b(eVar3, "acc");
                    h.b(bVar, "element");
                    e minusKey = eVar3.minusKey(bVar.getKey());
                    if (minusKey == EmptyCoroutineContext.INSTANCE) {
                        return bVar;
                    }
                    c cVar = (c) minusKey.get(c.f28514c);
                    if (cVar == null) {
                        return new CombinedContext(minusKey, bVar);
                    }
                    e minusKey2 = minusKey.minusKey(c.f28514c);
                    return minusKey2 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(bVar, cVar) : new CombinedContext(new CombinedContext(minusKey2, bVar), cVar);
                }
            });
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface b extends e {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E a(b bVar, c<E> cVar) {
                h.b(cVar, "key");
                if (!h.a(bVar.getKey(), cVar)) {
                    return null;
                }
                if (bVar != 0) {
                    return bVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type E");
            }

            public static e a(b bVar, e eVar) {
                h.b(eVar, com.umeng.analytics.pro.b.Q);
                return a.a(bVar, eVar);
            }

            public static e b(b bVar, c<?> cVar) {
                h.b(cVar, "key");
                return h.a(bVar.getKey(), cVar) ? EmptyCoroutineContext.INSTANCE : bVar;
            }

            public static <R> R a(b bVar, R r, kotlin.jvm.a.c<? super R, ? super b, ? extends R> cVar) {
                h.b(cVar, "operation");
                return cVar.invoke(r, bVar);
            }
        }

        @Override // kotlin.coroutines.e
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super b, ? extends R> cVar);

    <E extends b> E get(c<E> cVar);

    e minusKey(c<?> cVar);

    e plus(e eVar);
}
