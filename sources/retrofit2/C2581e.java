package retrofit2;

import java.util.concurrent.CompletableFuture;
import retrofit2.C2583g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompletableFutureCallAdapterFactory.java */
/* renamed from: retrofit2.e */
/* loaded from: classes3.dex */
public class C2581e<R> extends CompletableFuture<R> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2578b f29487a;

    /* renamed from: b */
    final /* synthetic */ C2583g.a f29488b;

    public C2581e(C2583g.a aVar, InterfaceC2578b interfaceC2578b) {
        this.f29488b = aVar;
        this.f29487a = interfaceC2578b;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (z) {
            this.f29487a.cancel();
        }
        return super.cancel(z);
    }
}
