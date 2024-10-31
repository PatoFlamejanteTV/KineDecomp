package retrofit2;

import retrofit2.q;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes3.dex */
class p<T> implements InterfaceC2580d<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2580d f29507a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ q.a f29508b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q.a aVar, InterfaceC2580d interfaceC2580d) {
        this.f29508b = aVar;
        this.f29507a = interfaceC2580d;
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<T> interfaceC2578b, D<T> d2) {
        this.f29508b.f29510a.execute(new n(this, d2));
    }

    @Override // retrofit2.InterfaceC2580d
    public void a(InterfaceC2578b<T> interfaceC2578b, Throwable th) {
        this.f29508b.f29510a.execute(new o(this, th));
    }
}
