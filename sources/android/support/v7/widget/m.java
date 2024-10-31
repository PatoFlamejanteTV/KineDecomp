package android.support.v7.widget;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Toolbar toolbar) {
        this.f230a = toolbar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f230a.b();
    }
}
