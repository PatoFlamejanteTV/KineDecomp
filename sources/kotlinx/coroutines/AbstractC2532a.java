package kotlinx.coroutines;

/* compiled from: AbstractCoroutine.kt */
/* renamed from: kotlinx.coroutines.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2532a<T> extends W implements P, kotlin.coroutines.b<T>, InterfaceC2550t {

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.coroutines.e f28616b;

    /* renamed from: c, reason: collision with root package name */
    protected final kotlin.coroutines.e f28617c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2532a(kotlin.coroutines.e eVar, boolean z) {
        super(z);
        kotlin.jvm.internal.h.b(eVar, "parentContext");
        this.f28617c = eVar;
        this.f28616b = this.f28617c.plus(this);
    }

    @Override // kotlinx.coroutines.InterfaceC2550t
    public kotlin.coroutines.e a() {
        return this.f28616b;
    }

    protected void a(T t) {
    }

    @Override // kotlinx.coroutines.W
    public final void d(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
        C2548q.a(this.f28617c, th, this);
    }

    @Override // kotlinx.coroutines.W
    protected void e(Throwable th) {
    }

    protected void f(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
    }

    @Override // kotlin.coroutines.b
    public final kotlin.coroutines.e getContext() {
        return this.f28616b;
    }

    @Override // kotlinx.coroutines.W
    public String i() {
        String a2 = C2545n.a(this.f28616b);
        if (a2 != null) {
            return '\"' + a2 + "\":" + super.i();
        }
        return super.i();
    }

    @Override // kotlinx.coroutines.W, kotlinx.coroutines.P
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.W
    public final void j() {
        n();
    }

    public int l() {
        return 0;
    }

    public final void m() {
        a((P) this.f28617c.get(P.f28600c));
    }

    protected void n() {
    }

    @Override // kotlin.coroutines.b
    public final void resumeWith(Object obj) {
        a(C2543l.a(obj), l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.W
    public void a(Object obj, int i, boolean z) {
        if (obj instanceof C2542k) {
            f(((C2542k) obj).f28670a);
        } else {
            a((AbstractC2532a<T>) obj);
        }
    }

    public final <R> void a(CoroutineStart coroutineStart, R r, kotlin.jvm.a.c<? super R, ? super kotlin.coroutines.b<? super T>, ? extends Object> cVar) {
        kotlin.jvm.internal.h.b(coroutineStart, "start");
        kotlin.jvm.internal.h.b(cVar, "block");
        m();
        coroutineStart.invoke(cVar, r, this);
    }
}
