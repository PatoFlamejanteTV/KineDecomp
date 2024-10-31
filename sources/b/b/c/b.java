package b.b.c;

import android.os.Bundle;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f3259a;

    /* renamed from: b */
    final /* synthetic */ Bundle f3260b;

    /* renamed from: c */
    final /* synthetic */ g f3261c;

    public b(g gVar, int i, Bundle bundle) {
        this.f3261c = gVar;
        this.f3259a = i;
        this.f3260b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3261c.f3276b.a(this.f3259a, this.f3260b);
        throw null;
    }
}
