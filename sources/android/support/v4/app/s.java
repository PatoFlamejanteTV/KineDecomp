package android.support.v4.app;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f65a;
    final /* synthetic */ int b;
    final /* synthetic */ q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, int i, int i2) {
        this.c = qVar;
        this.f65a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.c.o.mHandler, (String) null, this.f65a, this.b);
    }
}
