package kotlin.coroutines;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.coroutines.e;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class CombinedContext implements e, Serializable {
    private final e.b element;
    private final e left;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final e[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public Serialized(e[] eVarArr) {
            h.b(eVarArr, MessengerShareContentUtility.ELEMENTS);
            this.elements = eVarArr;
        }

        private final Object readResolve() {
            e[] eVarArr = this.elements;
            e eVar = EmptyCoroutineContext.INSTANCE;
            for (e eVar2 : eVarArr) {
                eVar = eVar.plus(eVar2);
            }
            return eVar;
        }

        public final e[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(e eVar, e.b bVar) {
        h.b(eVar, "left");
        h.b(bVar, "element");
        this.left = eVar;
        this.element = bVar;
    }

    private final int a() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            e eVar = combinedContext.left;
            if (!(eVar instanceof CombinedContext)) {
                eVar = null;
            }
            combinedContext = (CombinedContext) eVar;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int a2 = a();
        final e[] eVarArr = new e[a2];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        fold(k.f28545a, new kotlin.jvm.a.c<k, e.b, k>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.a.c
            public /* bridge */ /* synthetic */ k invoke(k kVar, e.b bVar) {
                invoke2(kVar, bVar);
                return k.f28545a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k kVar, e.b bVar) {
                h.b(kVar, "<anonymous parameter 0>");
                h.b(bVar, "element");
                e[] eVarArr2 = eVarArr;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i = ref$IntRef2.element;
                ref$IntRef2.element = i + 1;
                eVarArr2[i] = bVar;
            }
        });
        if (ref$IntRef.element == a2) {
            return new Serialized(eVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.a() != a() || !combinedContext.a(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return cVar.invoke((Object) this.left.fold(r, cVar), this.element);
    }

    @Override // kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = (E) combinedContext.element.get(cVar);
            if (e2 != null) {
                return e2;
            }
            e eVar = combinedContext.left;
            if (eVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) eVar;
            } else {
                return (E) eVar.get(cVar);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        e minusKey = this.left.minusKey(cVar);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, com.umeng.analytics.pro.b.Q);
        return e.a.a(this, eVar);
    }

    public String toString() {
        return "[" + ((String) fold("", new kotlin.jvm.a.c<String, e.b, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.a.c
            public final String invoke(String str, e.b bVar) {
                h.b(str, "acc");
                h.b(bVar, "element");
                if (str.length() == 0) {
                    return bVar.toString();
                }
                return str + ", " + bVar;
            }
        })) + "]";
    }

    private final boolean a(e.b bVar) {
        return h.a(get(bVar.getKey()), bVar);
    }

    private final boolean a(CombinedContext combinedContext) {
        while (a(combinedContext.element)) {
            e eVar = combinedContext.left;
            if (!(eVar instanceof CombinedContext)) {
                if (eVar != null) {
                    return a((e.b) eVar);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            combinedContext = (CombinedContext) eVar;
        }
        return false;
    }
}
