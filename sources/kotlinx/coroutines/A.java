package kotlinx.coroutines;

/* compiled from: Dispatched.kt */
/* loaded from: classes3.dex */
public final class A<T> extends C<T> implements kotlin.coroutines.jvm.internal.b, kotlin.coroutines.b<T> {

    /* renamed from: d, reason: collision with root package name */
    public Object f28571d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.coroutines.jvm.internal.b f28572e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f28573f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC2546o f28574g;

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.coroutines.b<T> f28575h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public A(AbstractC2546o abstractC2546o, kotlin.coroutines.b<? super T> bVar) {
        super(0);
        kotlin.jvm.internal.h.b(abstractC2546o, "dispatcher");
        kotlin.jvm.internal.h.b(bVar, "continuation");
        this.f28574g = abstractC2546o;
        this.f28575h = bVar;
        this.f28571d = B.a();
        kotlin.coroutines.b<T> bVar2 = this.f28575h;
        this.f28572e = (kotlin.coroutines.jvm.internal.b) (bVar2 instanceof kotlin.coroutines.jvm.internal.b ? bVar2 : null);
        this.f28573f = kotlinx.coroutines.internal.s.a(getContext());
    }

    @Override // kotlinx.coroutines.C
    public kotlin.coroutines.b<T> c() {
        return this;
    }

    @Override // kotlinx.coroutines.C
    public Object d() {
        Object obj = this.f28571d;
        if (obj != B.a()) {
            this.f28571d = B.a();
            return obj;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // kotlin.coroutines.jvm.internal.b
    public kotlin.coroutines.jvm.internal.b getCallerFrame() {
        return this.f28572e;
    }

    @Override // kotlin.coroutines.b
    public kotlin.coroutines.e getContext() {
        return this.f28575h.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.b
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.b
    public void resumeWith(Object obj) {
        kotlin.coroutines.e context = this.f28575h.getContext();
        Object a2 = C2543l.a(obj);
        if (this.f28574g.b(context)) {
            this.f28571d = a2;
            this.f28577c = 0;
            this.f28574g.a(context, this);
            return;
        }
        G a3 = ga.f28622b.a();
        if (a3.v()) {
            this.f28571d = a2;
            this.f28577c = 0;
            a3.a((C<?>) this);
            return;
        }
        a3.b(true);
        try {
            try {
                kotlin.coroutines.e context2 = getContext();
                Object b2 = kotlinx.coroutines.internal.s.b(context2, this.f28573f);
                try {
                    this.f28575h.resumeWith(obj);
                    kotlin.k kVar = kotlin.k.f28545a;
                    do {
                    } while (a3.x());
                } finally {
                    kotlinx.coroutines.internal.s.a(context2, b2);
                }
            } catch (Throwable th) {
                throw new DispatchException("Unexpected exception in unconfined event loop", th);
            }
        } finally {
            a3.a(true);
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f28574g + ", " + C2553w.a((kotlin.coroutines.b<?>) this.f28575h) + ']';
    }
}
