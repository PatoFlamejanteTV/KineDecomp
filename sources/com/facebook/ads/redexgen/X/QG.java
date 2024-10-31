package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: assets/audience_network.dex */
public final class QG extends ContentObserver {
    public final Q9 A00;

    public QG(Handler handler, Q9 q9) {
        super(handler);
        this.A00 = q9;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.A00.A0K();
    }
}
