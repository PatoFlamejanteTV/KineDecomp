package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* renamed from: com.google.android.gms.internal.ads.qh */
/* loaded from: classes2.dex */
final class C1056qh extends AbstractC1000mh {
    @Override // com.google.android.gms.internal.ads.AbstractC1000mh
    public final void a(Throwable th) {
        th.printStackTrace();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1000mh
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
