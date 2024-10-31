package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.ph */
/* loaded from: classes2.dex */
final class C1042ph extends AbstractC1000mh {

    /* renamed from: b */
    private final C1014nh f12433b = new C1014nh();

    @Override // com.google.android.gms.internal.ads.AbstractC1000mh
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> a2 = this.f12433b.a(th, false);
        if (a2 == null) {
            return;
        }
        synchronized (a2) {
            for (Throwable th2 : a2) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1000mh
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> a2 = this.f12433b.a(th, false);
        if (a2 == null) {
            return;
        }
        synchronized (a2) {
            for (Throwable th2 : a2) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}
