package b.b.c;

import android.os.Bundle;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3267a;

    /* renamed from: b */
    final /* synthetic */ Bundle f3268b;

    /* renamed from: c */
    final /* synthetic */ g f3269c;

    public e(g gVar, String str, Bundle bundle) {
        this.f3269c = gVar;
        this.f3267a = str;
        this.f3268b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3269c.f3276b.b(this.f3267a, this.f3268b);
        throw null;
    }
}
