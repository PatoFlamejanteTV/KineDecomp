package b.b.c;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import b.b.c.n;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
public class g extends n.a {

    /* renamed from: a */
    private Handler f3275a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    final /* synthetic */ a f3276b;

    /* renamed from: c */
    final /* synthetic */ h f3277c;

    public g(h hVar, a aVar) {
        this.f3277c = hVar;
        this.f3276b = aVar;
    }

    @Override // b.b.c.n
    public void a(int i, Bundle bundle) {
        if (this.f3276b == null) {
            return;
        }
        this.f3275a.post(new b(this, i, bundle));
    }

    @Override // b.b.c.n
    public void b(String str, Bundle bundle) throws RemoteException {
        if (this.f3276b == null) {
            return;
        }
        this.f3275a.post(new e(this, str, bundle));
    }

    @Override // b.b.c.n
    public void c(Bundle bundle) throws RemoteException {
        if (this.f3276b == null) {
            return;
        }
        this.f3275a.post(new d(this, bundle));
    }

    @Override // b.b.c.n
    public void a(String str, Bundle bundle) throws RemoteException {
        if (this.f3276b == null) {
            return;
        }
        this.f3275a.post(new c(this, str, bundle));
    }

    @Override // b.b.c.n
    public void a(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
        if (this.f3276b == null) {
            return;
        }
        this.f3275a.post(new f(this, i, uri, z, bundle));
    }
}
