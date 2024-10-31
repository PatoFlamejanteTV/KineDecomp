package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: com.facebook.ads.redexgen.X.27, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass27 extends BroadcastReceiver {
    public AbstractC00431o A00;
    public AnonymousClass26 A01;
    public String A02;

    public AnonymousClass27(String str, AbstractC00431o abstractC00431o, AnonymousClass26 anonymousClass26) {
        this.A00 = abstractC00431o;
        this.A01 = anonymousClass26;
        this.A02 = str;
    }

    public final IntentFilter A00() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EnumC0666Qc.A06.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A09.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A04.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A0A.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A05.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A0C.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A0B.A03(this.A02));
        intentFilter.addAction(EnumC0666Qc.A03.A03(this.A02));
        return intentFilter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0121, code lost:            return;     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass27.onReceive(android.content.Context, android.content.Intent):void");
    }
}
