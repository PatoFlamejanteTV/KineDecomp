package b.b.c;

import android.net.Uri;
import android.os.Bundle;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f3270a;

    /* renamed from: b */
    final /* synthetic */ Uri f3271b;

    /* renamed from: c */
    final /* synthetic */ boolean f3272c;

    /* renamed from: d */
    final /* synthetic */ Bundle f3273d;

    /* renamed from: e */
    final /* synthetic */ g f3274e;

    public f(g gVar, int i, Uri uri, boolean z, Bundle bundle) {
        this.f3274e = gVar;
        this.f3270a = i;
        this.f3271b = uri;
        this.f3272c = z;
        this.f3273d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3274e.f3276b.a(this.f3270a, this.f3271b, this.f3272c, this.f3273d);
        throw null;
    }
}
