package retrofit2;

import java.io.IOException;
import okhttp3.InterfaceC2562f;
import okhttp3.InterfaceC2563g;
import okhttp3.M;

/* compiled from: OkHttpCall.java */
/* loaded from: classes3.dex */
class t implements InterfaceC2563g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2580d f29518a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f29519b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(v vVar, InterfaceC2580d interfaceC2580d) {
        this.f29519b = vVar;
        this.f29518a = interfaceC2580d;
    }

    @Override // okhttp3.InterfaceC2563g
    public void a(InterfaceC2562f interfaceC2562f, M m) {
        try {
            try {
                this.f29518a.a(this.f29519b, this.f29519b.a(m));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            H.a(th2);
            a(th2);
        }
    }

    @Override // okhttp3.InterfaceC2563g
    public void a(InterfaceC2562f interfaceC2562f, IOException iOException) {
        a(iOException);
    }

    private void a(Throwable th) {
        try {
            this.f29518a.a(this.f29519b, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
