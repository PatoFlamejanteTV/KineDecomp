package com.google.android.gms.internal.gtm;

import java.io.PrintStream;
import java.util.List;

/* loaded from: classes2.dex */
final class W extends T {

    /* renamed from: b */
    private final U f13189b = new U();

    @Override // com.google.android.gms.internal.gtm.T
    public final void a(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> a2 = this.f13189b.a(th, false);
        if (a2 == null) {
            return;
        }
        synchronized (a2) {
            for (Throwable th2 : a2) {
                printStream.print("Suppressed: ");
                th2.printStackTrace(printStream);
            }
        }
    }
}
