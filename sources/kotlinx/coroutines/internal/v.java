package kotlinx.coroutines.internal;

/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a */
    private Object[] f28663a;

    /* renamed from: b */
    private int f28664b;

    /* renamed from: c */
    private final kotlin.coroutines.e f28665c;

    public v(kotlin.coroutines.e eVar, int i) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        this.f28665c = eVar;
        this.f28663a = new Object[i];
    }

    public final kotlin.coroutines.e a() {
        return this.f28665c;
    }

    public final void b() {
        this.f28664b = 0;
    }

    public final Object c() {
        Object[] objArr = this.f28663a;
        int i = this.f28664b;
        this.f28664b = i + 1;
        return objArr[i];
    }

    public final void a(Object obj) {
        Object[] objArr = this.f28663a;
        int i = this.f28664b;
        this.f28664b = i + 1;
        objArr[i] = obj;
    }
}
