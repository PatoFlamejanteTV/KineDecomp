package retrofit2;

/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes3.dex */
class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Throwable f29505a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f29506b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar, Throwable th) {
        this.f29506b = pVar;
        this.f29505a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        p pVar = this.f29506b;
        pVar.f29507a.a(pVar.f29508b, this.f29505a);
    }
}
