package retrofit2;

import java.io.IOException;

/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes3.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ D f29503a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f29504b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(p pVar, D d2) {
        this.f29504b = pVar;
        this.f29503a = d2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f29504b.f29508b.f29511b.S()) {
            p pVar = this.f29504b;
            pVar.f29507a.a(pVar.f29508b, new IOException("Canceled"));
        } else {
            p pVar2 = this.f29504b;
            pVar2.f29507a.a(pVar2.f29508b, this.f29503a);
        }
    }
}
