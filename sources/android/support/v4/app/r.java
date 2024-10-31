package android.support.v4.app;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f64a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f64a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f64a.g();
    }
}
