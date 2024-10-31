package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.util.List;

/* loaded from: classes2.dex */
final class Y extends V {

    /* renamed from: b */
    private final W f13407b = new W();

    @Override // com.google.android.gms.internal.measurement.V
    public final void a(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        List<Throwable> a2 = this.f13407b.a(th, false);
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
