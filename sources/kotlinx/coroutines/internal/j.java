package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a */
    private static final Object f28635a = new q("CONDITION_FALSE");

    /* renamed from: b */
    private static final Object f28636b = new q("ALREADY_REMOVED");

    /* renamed from: c */
    private static final Object f28637c = new q("LIST_EMPTY");

    /* renamed from: d */
    private static final Object f28638d = new q("REMOVE_PREPARED");

    public static final Object a() {
        return f28635a;
    }

    public static final k a(Object obj) {
        k kVar;
        kotlin.jvm.internal.h.b(obj, "receiver$0");
        o oVar = (o) (!(obj instanceof o) ? null : obj);
        return (oVar == null || (kVar = oVar.f28654a) == null) ? (k) obj : kVar;
    }
}
