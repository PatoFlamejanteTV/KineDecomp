package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* loaded from: assets/audience_network.dex */
public final class DD extends C0279Ax {
    public final Context A00;

    public DD(Context context, AA aa) {
        super(context, aa);
        this.A00 = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A03(HashMap<String, DC> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A0C);
    }

    public final InterfaceC0267Al A0G(List<C0345Dl> list, DB db) {
        return new D9(this, list, db);
    }
}
