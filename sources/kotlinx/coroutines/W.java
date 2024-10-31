package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.coroutines.e;
import kotlinx.coroutines.P;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class W implements P, InterfaceC2538g, ca, kotlinx.coroutines.b.a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f28603a = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_state");
    private volatile Object _state;
    private volatile InterfaceC2536e parentHandle;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class a extends V<P> {

        /* renamed from: e, reason: collision with root package name */
        private final W f28604e;

        /* renamed from: f, reason: collision with root package name */
        private final b f28605f;

        /* renamed from: g, reason: collision with root package name */
        private final C2537f f28606g;

        /* renamed from: h, reason: collision with root package name */
        private final Object f28607h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(W w, b bVar, C2537f c2537f, Object obj) {
            super(c2537f.f28620e);
            kotlin.jvm.internal.h.b(w, "parent");
            kotlin.jvm.internal.h.b(bVar, ServerProtocol.DIALOG_PARAM_STATE);
            kotlin.jvm.internal.h.b(c2537f, "child");
            this.f28604e = w;
            this.f28605f = bVar;
            this.f28606g = c2537f;
            this.f28607h = obj;
        }

        @Override // kotlinx.coroutines.AbstractC2544m
        public void b(Throwable th) {
            this.f28604e.a(this.f28605f, this.f28606g, this.f28607h);
        }

        @Override // kotlin.jvm.a.b
        public /* bridge */ /* synthetic */ kotlin.k invoke(Throwable th) {
            b(th);
            return kotlin.k.f28545a;
        }

        @Override // kotlinx.coroutines.internal.k
        public String toString() {
            return "ChildCompletion[" + this.f28606g + ", " + this.f28607h + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class b implements L {
        private volatile Object _exceptionsHolder;

        /* renamed from: a, reason: collision with root package name */
        private final aa f28608a;
        public volatile boolean isCompleting;
        public volatile Throwable rootCause;

        public b(aa aaVar, boolean z, Throwable th) {
            kotlin.jvm.internal.h.b(aaVar, "list");
            this.f28608a = aaVar;
            this.isCompleting = z;
            this.rootCause = th;
        }

        private final ArrayList<Throwable> d() {
            return new ArrayList<>(4);
        }

        @Override // kotlinx.coroutines.L
        public aa a() {
            return this.f28608a;
        }

        public final boolean b() {
            return this.rootCause != null;
        }

        public final boolean c() {
            kotlinx.coroutines.internal.q qVar;
            Object obj = this._exceptionsHolder;
            qVar = Y.f28612a;
            return obj == qVar;
        }

        @Override // kotlinx.coroutines.L
        public boolean isActive() {
            return this.rootCause == null;
        }

        public String toString() {
            return "Finishing[cancelling=" + b() + ", completing=" + this.isCompleting + ", rootCause=" + this.rootCause + ", exceptions=" + this._exceptionsHolder + ", list=" + a() + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th) {
            kotlin.jvm.internal.h.b(th, "exception");
            Throwable th2 = this.rootCause;
            if (th2 == null) {
                this.rootCause = th;
                return;
            }
            if (th == th2) {
                return;
            }
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                this._exceptionsHolder = th;
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> d2 = d();
                d2.add(obj);
                d2.add(th);
                this._exceptionsHolder = d2;
                return;
            }
            if (obj instanceof ArrayList) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                }
                ((ArrayList) obj).add(th);
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final List<Throwable> b(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.q qVar;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayList = d();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> d2 = d();
                d2.add(obj);
                arrayList = d2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                }
                arrayList = (ArrayList) obj;
            }
            Throwable th2 = this.rootCause;
            if (th2 != null) {
                arrayList.add(0, th2);
            }
            if (th != null && (!kotlin.jvm.internal.h.a(th, th2))) {
                arrayList.add(th);
            }
            qVar = Y.f28612a;
            this._exceptionsHolder = qVar;
            return arrayList;
        }
    }

    public W(boolean z) {
        F f2;
        if (!z) {
            f2 = Y.f28613b;
        } else {
            f2 = Y.f28614c;
        }
        this._state = f2;
    }

    private final Throwable d(Object obj) {
        if (!(obj instanceof C2542k)) {
            obj = null;
        }
        C2542k c2542k = (C2542k) obj;
        if (c2542k != null) {
            return c2542k.f28670a;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean e(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r7.g()
            boolean r3 = r2 instanceof kotlinx.coroutines.W.b
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L4b
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.W$b r3 = (kotlinx.coroutines.W.b) r3     // Catch: java.lang.Throwable -> L48
            boolean r3 = r3.c()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L18
            monitor-exit(r2)
            return r4
        L18:
            r3 = r2
            kotlinx.coroutines.W$b r3 = (kotlinx.coroutines.W.b) r3     // Catch: java.lang.Throwable -> L48
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L48
            if (r8 != 0) goto L23
            if (r3 != 0) goto L30
        L23:
            if (r1 == 0) goto L26
            goto L2a
        L26:
            java.lang.Throwable r1 = r7.c(r8)     // Catch: java.lang.Throwable -> L48
        L2a:
            r8 = r2
            kotlinx.coroutines.W$b r8 = (kotlinx.coroutines.W.b) r8     // Catch: java.lang.Throwable -> L48
            r8.a(r1)     // Catch: java.lang.Throwable -> L48
        L30:
            r8 = r2
            kotlinx.coroutines.W$b r8 = (kotlinx.coroutines.W.b) r8     // Catch: java.lang.Throwable -> L48
            java.lang.Throwable r8 = r8.rootCause     // Catch: java.lang.Throwable -> L48
            r1 = r3 ^ 1
            if (r1 == 0) goto L3a
            goto L3b
        L3a:
            r8 = r0
        L3b:
            monitor-exit(r2)
            if (r8 == 0) goto L47
            kotlinx.coroutines.W$b r2 = (kotlinx.coroutines.W.b) r2
            kotlinx.coroutines.aa r0 = r2.a()
            r7.a(r0, r8)
        L47:
            return r5
        L48:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L4b:
            boolean r3 = r2 instanceof kotlinx.coroutines.L
            if (r3 == 0) goto L9e
            if (r1 == 0) goto L52
            goto L56
        L52:
            java.lang.Throwable r1 = r7.c(r8)
        L56:
            r3 = r2
            kotlinx.coroutines.L r3 = (kotlinx.coroutines.L) r3
            boolean r6 = r3.isActive()
            if (r6 == 0) goto L66
            boolean r2 = r7.a(r3, r1)
            if (r2 == 0) goto L2
            return r5
        L66:
            kotlinx.coroutines.k r3 = new kotlinx.coroutines.k
            r3.<init>(r1)
            int r3 = r7.a(r2, r3, r4)
            if (r3 == 0) goto L83
            if (r3 == r5) goto L82
            r2 = 2
            if (r3 == r2) goto L82
            r2 = 3
            if (r3 != r2) goto L7a
            goto L2
        L7a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected result"
            r8.<init>(r0)
            throw r8
        L82:
            return r5
        L83:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cannot happen in "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        L9e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.W.e(java.lang.Object):boolean");
    }

    private final int f(Object obj) {
        F f2;
        if (obj instanceof F) {
            if (((F) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f28603a;
            f2 = Y.f28614c;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, f2)) {
                return -1;
            }
            j();
            return 1;
        }
        if (!(obj instanceof K)) {
            return 0;
        }
        if (!f28603a.compareAndSet(this, obj, ((K) obj).a())) {
            return -1;
        }
        j();
        return 1;
    }

    private final String g(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof L ? ((L) obj).isActive() ? "Active" : "New" : obj instanceof C2542k ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        b bVar = (b) obj;
        return bVar.b() ? "Cancelling" : bVar.isCompleting ? "Completing" : "Active";
    }

    private final JobCancellationException l() {
        return new JobCancellationException("Job was cancelled", null, this);
    }

    public void a(Object obj, int i, boolean z) {
    }

    @Override // kotlinx.coroutines.P
    public final CancellationException b() {
        CancellationException a2;
        Object g2 = g();
        if (!(g2 instanceof b)) {
            if (!(g2 instanceof L)) {
                return g2 instanceof C2542k ? a(((C2542k) g2).f28670a, "Job was cancelled") : new JobCancellationException("Job has completed normally", null, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        Throwable th = ((b) g2).rootCause;
        if (th != null && (a2 = a(th, "Job is cancelling")) != null) {
            return a2;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.ca
    public Throwable c() {
        Throwable th;
        Object g2 = g();
        if (g2 instanceof b) {
            th = ((b) g2).rootCause;
        } else if (!(g2 instanceof L)) {
            th = g2 instanceof C2542k ? ((C2542k) g2).f28670a : null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + g2).toString());
        }
        if (th != null && (!e() || (th instanceof CancellationException))) {
            return th;
        }
        return new JobCancellationException("Parent job is " + g(g2), th, this);
    }

    protected void c(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
    }

    protected boolean d() {
        return false;
    }

    protected void e(Throwable th) {
    }

    protected boolean e() {
        return true;
    }

    public boolean f() {
        return false;
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.c<? super R, ? super e.b, ? extends R> cVar) {
        kotlin.jvm.internal.h.b(cVar, "operation");
        return (R) P.a.a(this, r, cVar);
    }

    @Override // kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return (E) P.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.e.b
    public final e.c<?> getKey() {
        return P.f28600c;
    }

    public final boolean h() {
        return !(g() instanceof L);
    }

    public String i() {
        return C2553w.a(this);
    }

    @Override // kotlinx.coroutines.P
    public boolean isActive() {
        Object g2 = g();
        return (g2 instanceof L) && ((L) g2).isActive();
    }

    public void j() {
    }

    public final String k() {
        return i() + '{' + g(g()) + '}';
    }

    @Override // kotlin.coroutines.e
    public kotlin.coroutines.e minusKey(e.c<?> cVar) {
        kotlin.jvm.internal.h.b(cVar, "key");
        return P.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.e
    public kotlin.coroutines.e plus(kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        return P.a.a(this, eVar);
    }

    @Override // kotlinx.coroutines.P
    public final boolean start() {
        int f2;
        do {
            f2 = f(g());
            if (f2 == 0) {
                return false;
            }
        } while (f2 != 1);
        return true;
    }

    public String toString() {
        return k() + '@' + C2553w.b(this);
    }

    public final void a(P p) {
        if (!(this.parentHandle == null)) {
            throw new IllegalStateException("Check failed.");
        }
        if (p == null) {
            this.parentHandle = ba.f28619a;
            return;
        }
        p.start();
        InterfaceC2536e a2 = p.a(this);
        this.parentHandle = a2;
        if (h()) {
            a2.dispose();
            this.parentHandle = ba.f28619a;
        }
    }

    public void d(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
        throw th;
    }

    public final Object g() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.n)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.n) obj).a(this);
        }
    }

    private final void b(V<?> v) {
        v.a(new aa());
        f28603a.compareAndSet(this, v, v.c());
    }

    private final Throwable c(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : l();
        }
        if (obj != null) {
            return ((ca) obj).c();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final boolean f(Throwable th) {
        InterfaceC2536e interfaceC2536e;
        if (th instanceof CancellationException) {
            return true;
        }
        return d() && (interfaceC2536e = this.parentHandle) != null && interfaceC2536e.a(th);
    }

    private final boolean c(L l) {
        return (l instanceof b) && ((b) l).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:            if (r4 != r6.rootCause) goto L25;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean a(kotlinx.coroutines.W.b r6, java.lang.Object r7, int r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.g()
            r1 = 0
            r2 = 1
            if (r0 != r6) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto La3
            boolean r0 = r6.c()
            r0 = r0 ^ r2
            if (r0 == 0) goto L9b
            boolean r0 = r6.isCompleting
            if (r0 == 0) goto L93
            boolean r0 = r7 instanceof kotlinx.coroutines.C2542k
            r3 = 0
            if (r0 != 0) goto L1f
            r0 = r3
            goto L20
        L1f:
            r0 = r7
        L20:
            kotlinx.coroutines.k r0 = (kotlinx.coroutines.C2542k) r0
            if (r0 == 0) goto L26
            java.lang.Throwable r3 = r0.f28670a
        L26:
            monitor-enter(r6)
            java.util.List r0 = r6.b(r3)     // Catch: java.lang.Throwable -> L90
            java.lang.Throwable r4 = r5.a(r6, r0)     // Catch: java.lang.Throwable -> L90
            if (r4 == 0) goto L3c
            boolean r0 = r5.a(r4, r0)     // Catch: java.lang.Throwable -> L90
            if (r0 != 0) goto L3b
            java.lang.Throwable r0 = r6.rootCause     // Catch: java.lang.Throwable -> L90
            if (r4 == r0) goto L3c
        L3b:
            r1 = 1
        L3c:
            monitor-exit(r6)
            if (r4 != 0) goto L40
            goto L48
        L40:
            if (r4 != r3) goto L43
            goto L48
        L43:
            kotlinx.coroutines.k r7 = new kotlinx.coroutines.k
            r7.<init>(r4)
        L48:
            if (r4 == 0) goto L53
            boolean r0 = r5.f(r4)
            if (r0 != 0) goto L53
            r5.c(r4)
        L53:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.W.f28603a
            java.lang.Object r3 = kotlinx.coroutines.Y.a(r7)
            boolean r0 = r0.compareAndSet(r5, r6, r3)
            if (r0 == 0) goto L63
            r5.a(r6, r7, r8, r1)
            return r2
        L63:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unexpected state: "
            r8.append(r0)
            java.lang.Object r0 = r5._state
            r8.append(r0)
            java.lang.String r0 = ", expected: "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = ", update: "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        L90:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L93:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            r6.<init>(r7)
            throw r6
        L9b:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            r6.<init>(r7)
            throw r6
        La3:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.W.a(kotlinx.coroutines.W$b, java.lang.Object, int):boolean");
    }

    public boolean b(Throwable th) {
        kotlin.jvm.internal.h.b(th, "cause");
        return a((Object) th) && e();
    }

    private final aa b(L l) {
        aa a2 = l.a();
        if (a2 != null) {
            return a2;
        }
        if (l instanceof F) {
            return new aa();
        }
        if (l instanceof V) {
            b((V<?>) l);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + l).toString());
    }

    private final boolean b(b bVar, C2537f c2537f, Object obj) {
        while (P.a.a(c2537f.f28620e, false, false, new a(this, bVar, c2537f, obj), 1, null) == ba.f28619a) {
            c2537f = a((kotlinx.coroutines.internal.k) c2537f);
            if (c2537f == null) {
                return false;
            }
        }
        return true;
    }

    private final void b(aa aaVar, Throwable th) {
        Object b2 = aaVar.b();
        if (b2 != null) {
            CompletionHandlerException completionHandlerException = null;
            for (kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) b2; !kotlin.jvm.internal.h.a(kVar, aaVar); kVar = kVar.c()) {
                if (kVar instanceof V) {
                    V v = (V) kVar;
                    try {
                        v.b(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.b.a(completionHandlerException, th2);
                            if (completionHandlerException != null) {
                            }
                        }
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + v + " for " + this, th2);
                        kotlin.k kVar2 = kotlin.k.f28545a;
                    }
                }
            }
            if (completionHandlerException != null) {
                d((Throwable) completionHandlerException);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final Throwable a(b bVar, List<? extends Throwable> list) {
        Object obj;
        if (list.isEmpty()) {
            if (bVar.b()) {
                return l();
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final boolean b(Object obj) {
        int a2;
        do {
            Object g2 = g();
            if (!(g2 instanceof L) || (((g2 instanceof b) && ((b) g2).isCompleting) || (a2 = a(g2, new C2542k(c(obj)), 0)) == 0)) {
                return false;
            }
            if (a2 == 1 || a2 == 2) {
                return true;
            }
        } while (a2 == 3);
        throw new IllegalStateException("unexpected result");
    }

    private final boolean a(Throwable th, List<? extends Throwable> list) {
        boolean z = false;
        if (list.size() <= 1) {
            return false;
        }
        Set a2 = kotlinx.coroutines.internal.e.a(list.size());
        Iterator<? extends Throwable> it = list.iterator();
        while (it.hasNext()) {
            Throwable a3 = kotlinx.coroutines.internal.p.a(it.next());
            if (a3 != th && !(a3 instanceof CancellationException) && a2.add(a3)) {
                kotlin.b.a(th, a3);
                z = true;
            }
        }
        return z;
    }

    private final boolean a(L l, Object obj, int i) {
        Object b2;
        if ((l instanceof F) || (l instanceof V)) {
            if (!(obj instanceof C2542k)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f28603a;
                b2 = Y.b(obj);
                if (!atomicReferenceFieldUpdater.compareAndSet(this, l, b2)) {
                    return false;
                }
                a(l, obj, i, false);
                return true;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IllegalStateException("Check failed.");
    }

    private final void a(L l, Object obj, int i, boolean z) {
        InterfaceC2536e interfaceC2536e = this.parentHandle;
        if (interfaceC2536e != null) {
            interfaceC2536e.dispose();
            this.parentHandle = ba.f28619a;
        }
        C2542k c2542k = (C2542k) (!(obj instanceof C2542k) ? null : obj);
        Throwable th = c2542k != null ? c2542k.f28670a : null;
        if (!c(l)) {
            e(th);
        }
        if (l instanceof V) {
            try {
                ((V) l).b(th);
            } catch (Throwable th2) {
                d((Throwable) new CompletionHandlerException("Exception in completion handler " + l + " for " + this, th2));
            }
        } else {
            aa a2 = l.a();
            if (a2 != null) {
                b(a2, th);
            }
        }
        a(obj, i, z);
    }

    private final void a(aa aaVar, Throwable th) {
        e(th);
        Object b2 = aaVar.b();
        if (b2 != null) {
            CompletionHandlerException completionHandlerException = null;
            for (kotlinx.coroutines.internal.k kVar = (kotlinx.coroutines.internal.k) b2; !kotlin.jvm.internal.h.a(kVar, aaVar); kVar = kVar.c()) {
                if (kVar instanceof Q) {
                    V v = (V) kVar;
                    try {
                        v.b(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.b.a(completionHandlerException, th2);
                            if (completionHandlerException != null) {
                            }
                        }
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + v + " for " + this, th2);
                        kotlin.k kVar2 = kotlin.k.f28545a;
                    }
                }
            }
            if (completionHandlerException != null) {
                d((Throwable) completionHandlerException);
            }
            f(th);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final CancellationException a(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        return cancellationException != null ? cancellationException : new JobCancellationException(str, th, this);
    }

    private final V<?> a(kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar, boolean z) {
        if (z) {
            Q q = (Q) (bVar instanceof Q ? bVar : null);
            if (q != null) {
                if (!(q.f28602d == this)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                if (q != null) {
                    return q;
                }
            }
            return new N(this, bVar);
        }
        V<?> v = (V) (bVar instanceof V ? bVar : null);
        if (v != null) {
            if (!(v.f28602d == this && !(v instanceof Q))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (v != null) {
                return v;
            }
        }
        return new O(this, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.K] */
    private final void a(F f2) {
        aa aaVar = new aa();
        if (!f2.isActive()) {
            aaVar = new K(aaVar);
        }
        f28603a.compareAndSet(this, f2, aaVar);
    }

    @Override // kotlinx.coroutines.P
    public boolean a(Throwable th) {
        return a((Object) th) && e();
    }

    @Override // kotlinx.coroutines.InterfaceC2538g
    public final void a(ca caVar) {
        kotlin.jvm.internal.h.b(caVar, "parentJob");
        a((Object) caVar);
    }

    private final boolean a(Object obj) {
        if (f() && b(obj)) {
            return true;
        }
        return e(obj);
    }

    private final boolean a(L l, Throwable th) {
        if (!(l instanceof b)) {
            if (l.isActive()) {
                aa b2 = b(l);
                if (b2 == null) {
                    return false;
                }
                if (!f28603a.compareAndSet(this, l, new b(b2, false, th))) {
                    return false;
                }
                a(b2, th);
                return true;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IllegalStateException("Check failed.");
    }

    private final int a(Object obj, Object obj2, int i) {
        if (!(obj instanceof L)) {
            return 0;
        }
        if (((obj instanceof F) || (obj instanceof V)) && !(obj instanceof C2537f) && !(obj2 instanceof C2542k)) {
            return !a((L) obj, obj2, i) ? 3 : 1;
        }
        L l = (L) obj;
        aa b2 = b(l);
        if (b2 == null) {
            return 3;
        }
        b bVar = (b) (!(obj instanceof b) ? null : obj);
        if (bVar == null) {
            bVar = new b(b2, false, null);
        }
        synchronized (bVar) {
            if (bVar.isCompleting) {
                return 0;
            }
            bVar.isCompleting = true;
            if (bVar != obj && !f28603a.compareAndSet(this, obj, bVar)) {
                return 3;
            }
            if (!bVar.c()) {
                boolean b3 = bVar.b();
                C2542k c2542k = (C2542k) (!(obj2 instanceof C2542k) ? null : obj2);
                if (c2542k != null) {
                    bVar.a(c2542k.f28670a);
                }
                Throwable th = bVar.rootCause;
                if (!(!b3)) {
                    th = null;
                }
                kotlin.k kVar = kotlin.k.f28545a;
                if (th != null) {
                    a(b2, th);
                }
                C2537f a2 = a(l);
                if (a2 == null || !b(bVar, a2, obj2)) {
                    return a(bVar, obj2, i) ? 1 : 3;
                }
                return 2;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    private final C2537f a(L l) {
        C2537f c2537f = (C2537f) (!(l instanceof C2537f) ? null : l);
        if (c2537f != null) {
            return c2537f;
        }
        aa a2 = l.a();
        if (a2 != null) {
            return a((kotlinx.coroutines.internal.k) a2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar, C2537f c2537f, Object obj) {
        if (g() == bVar) {
            C2537f a2 = a((kotlinx.coroutines.internal.k) c2537f);
            if ((a2 == null || !b(bVar, a2, obj)) && a(bVar, obj, 0)) {
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private final C2537f a(kotlinx.coroutines.internal.k kVar) {
        while (kVar.g()) {
            kVar = kVar.e();
        }
        while (true) {
            kVar = kVar.c();
            if (!kVar.g()) {
                if (kVar instanceof C2537f) {
                    return (C2537f) kVar;
                }
                if (kVar instanceof aa) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.P
    public final InterfaceC2536e a(InterfaceC2538g interfaceC2538g) {
        kotlin.jvm.internal.h.b(interfaceC2538g, "child");
        E a2 = P.a.a(this, true, false, new C2537f(this, interfaceC2538g), 2, null);
        if (a2 != null) {
            return (InterfaceC2536e) a2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    @Override // kotlinx.coroutines.P
    public final E a(boolean z, boolean z2, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar) {
        Throwable th;
        kotlin.jvm.internal.h.b(bVar, "handler");
        V<?> v = null;
        while (true) {
            Object g2 = g();
            if (g2 instanceof F) {
                F f2 = (F) g2;
                if (f2.isActive()) {
                    if (v == null) {
                        v = a(bVar, z);
                    }
                    if (f28603a.compareAndSet(this, g2, v)) {
                        return v;
                    }
                } else {
                    a(f2);
                }
            } else if (g2 instanceof L) {
                aa a2 = ((L) g2).a();
                if (a2 != null) {
                    E e2 = ba.f28619a;
                    if (z && (g2 instanceof b)) {
                        synchronized (g2) {
                            th = ((b) g2).rootCause;
                            if (th == null || ((bVar instanceof C2537f) && !((b) g2).isCompleting)) {
                                if (v == null) {
                                    v = a(bVar, z);
                                }
                                if (a(g2, a2, v)) {
                                    if (th == null) {
                                        return v;
                                    }
                                    e2 = v;
                                }
                            }
                            kotlin.k kVar = kotlin.k.f28545a;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            bVar.invoke(th);
                        }
                        return e2;
                    }
                    if (v == null) {
                        v = a(bVar, z);
                    }
                    if (a(g2, a2, v)) {
                        return v;
                    }
                } else {
                    if (g2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    }
                    b((V<?>) g2);
                }
            } else {
                if (z2) {
                    if (!(g2 instanceof C2542k)) {
                        g2 = null;
                    }
                    C2542k c2542k = (C2542k) g2;
                    bVar.invoke(c2542k != null ? c2542k.f28670a : null);
                }
                return ba.f28619a;
            }
        }
    }

    private final boolean a(Object obj, aa aaVar, V<?> v) {
        int a2;
        X x = new X(v, v, this, obj);
        do {
            Object d2 = aaVar.d();
            if (d2 != null) {
                a2 = ((kotlinx.coroutines.internal.k) d2).a(v, aaVar, x);
                if (a2 == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (a2 != 2);
        return false;
    }

    public final void a(V<?> v) {
        Object g2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        F f2;
        kotlin.jvm.internal.h.b(v, "node");
        do {
            g2 = g();
            if (!(g2 instanceof V)) {
                if (!(g2 instanceof L) || ((L) g2).a() == null) {
                    return;
                }
                v.h();
                return;
            }
            if (g2 != v) {
                return;
            }
            atomicReferenceFieldUpdater = f28603a;
            f2 = Y.f28614c;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, g2, f2));
    }

    public final boolean a(Object obj, int i) {
        int a2;
        do {
            a2 = a(g(), obj, i);
            if (a2 == 0) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, d(obj));
            }
            if (a2 == 1) {
                return true;
            }
            if (a2 == 2) {
                return false;
            }
        } while (a2 == 3);
        throw new IllegalStateException("unexpected result");
    }
}
