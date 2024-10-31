package kotlinx.coroutines.internal;

import com.facebook.internal.ServerProtocol;
import kotlin.TypeCastException;
import kotlin.coroutines.e;
import kotlinx.coroutines.fa;

/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private static final q f28657a = new q("ZERO");

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.jvm.a.c<Object, e.b, Object> f28658b = new kotlin.jvm.a.c<Object, e.b, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.a.c
        public final Object invoke(Object obj, e.b bVar) {
            kotlin.jvm.internal.h.b(bVar, "element");
            if (!(bVar instanceof fa)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final kotlin.jvm.a.c<fa<?>, e.b, fa<?>> f28659c = new kotlin.jvm.a.c<fa<?>, e.b, fa<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.a.c
        public final fa<?> invoke(fa<?> faVar, e.b bVar) {
            kotlin.jvm.internal.h.b(bVar, "element");
            if (faVar != null) {
                return faVar;
            }
            if (!(bVar instanceof fa)) {
                bVar = null;
            }
            return (fa) bVar;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static final kotlin.jvm.a.c<v, e.b, v> f28660d = new kotlin.jvm.a.c<v, e.b, v>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.a.c
        public final v invoke(v vVar, e.b bVar) {
            kotlin.jvm.internal.h.b(vVar, ServerProtocol.DIALOG_PARAM_STATE);
            kotlin.jvm.internal.h.b(bVar, "element");
            if (bVar instanceof fa) {
                vVar.a(((fa) bVar).a(vVar.a()));
            }
            return vVar;
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final kotlin.jvm.a.c<v, e.b, v> f28661e = new kotlin.jvm.a.c<v, e.b, v>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$restoreState$1
        @Override // kotlin.jvm.a.c
        public final v invoke(v vVar, e.b bVar) {
            kotlin.jvm.internal.h.b(vVar, ServerProtocol.DIALOG_PARAM_STATE);
            kotlin.jvm.internal.h.b(bVar, "element");
            if (bVar instanceof fa) {
                ((fa) bVar).a(vVar.a(), vVar.c());
            }
            return vVar;
        }
    };

    public static final Object a(kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        Object fold = eVar.fold(0, f28658b);
        if (fold != null) {
            return fold;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    public static final Object b(kotlin.coroutines.e eVar, Object obj) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        if (obj == null) {
            obj = a(eVar);
        }
        if (obj == 0) {
            return f28657a;
        }
        if (obj instanceof Integer) {
            return eVar.fold(new v(eVar, ((Number) obj).intValue()), f28660d);
        }
        if (obj != null) {
            return ((fa) obj).a(eVar);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final void a(kotlin.coroutines.e eVar, Object obj) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        if (obj == f28657a) {
            return;
        }
        if (obj instanceof v) {
            ((v) obj).b();
            eVar.fold(obj, f28661e);
        } else {
            Object fold = eVar.fold(null, f28659c);
            if (fold != null) {
                ((fa) fold).a(eVar, obj);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }
}
