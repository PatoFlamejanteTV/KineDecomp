package c.c.a.a.a.a;

import android.content.Context;
import c.c.a.a.a.a.c;
import javax.inject.Provider;

/* compiled from: DaggerKinemasterServiceComponent.java */
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.a.a.c.a> f3467a;

    /* renamed from: b, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.a.a.c.b> f3468b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<Context> f3469c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.a.a.a.a> f3470d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.a.e> f3471e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.c.a.a.a> f3472f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.c.a.a.b> f3473g;

    /* renamed from: h, reason: collision with root package name */
    private Provider<c.c.a.a.a.b.c.a> f3474h;
    private Provider<c.c.a.a.a.b.b.a.b.b> i;
    private Provider<c.c.a.a.a.b.b.a.b.c> j;
    private Provider<c.c.a.a.a.b.b.c> k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerKinemasterServiceComponent.java */
    /* loaded from: classes2.dex */
    public static final class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private d f3475a;

        /* renamed from: b, reason: collision with root package name */
        private Context f3476b;

        private a() {
        }

        @Override // c.c.a.a.a.a.c.a
        public /* bridge */ /* synthetic */ c.a a(Context context) {
            a(context);
            return this;
        }

        @Override // c.c.a.a.a.a.c.a
        public c build() {
            if (this.f3475a == null) {
                this.f3475a = new d();
            }
            d.a.f.a(this.f3476b, (Class<Context>) Context.class);
            return new b(this.f3475a, this.f3476b);
        }

        @Override // c.c.a.a.a.a.c.a
        public a a(Context context) {
            d.a.f.a(context);
            this.f3476b = context;
            return this;
        }
    }

    private void a(d dVar, Context context) {
        this.f3467a = d.a.b.a(e.a(dVar));
        this.f3468b = d.a.b.a(f.a(dVar, this.f3467a));
        this.f3469c = d.a.d.a(context);
        this.f3470d = d.a.b.a(g.a(dVar, this.f3469c));
        this.f3471e = d.a.b.a(h.a(dVar, this.f3468b, this.f3470d));
        this.f3472f = d.a.b.a(l.a(dVar, this.f3471e));
        this.f3473g = d.a.b.a(m.a(dVar, this.f3472f));
        this.f3474h = d.a.b.a(n.a(dVar, this.f3473g, this.f3471e));
        this.i = d.a.b.a(i.a(dVar, this.f3471e));
        this.j = d.a.b.a(j.a(dVar, this.i));
        this.k = d.a.b.a(k.a(dVar, this.j, this.f3471e));
    }

    public static c.a b() {
        return new a();
    }

    private b(d dVar, Context context) {
        a(dVar, context);
    }

    @Override // c.c.a.a.a.a.c
    public c.c.a.a.a.b.b.c a() {
        return this.k.get();
    }
}
