package b.b.c;

import android.os.Bundle;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3262a;

    /* renamed from: b */
    final /* synthetic */ Bundle f3263b;

    /* renamed from: c */
    final /* synthetic */ g f3264c;

    public c(g gVar, String str, Bundle bundle) {
        this.f3264c = gVar;
        this.f3262a = str;
        this.f3263b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3264c.f3276b.a(this.f3262a, this.f3263b);
        throw null;
    }
}
