package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.Ch, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0315Ch extends C0279Ax {
    public C0315Ch(Context context, AA aa) {
        super(context, aa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A02(HashMap<String, C0314Cg> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A0C);
    }

    public final InterfaceC0267Al A0G() {
        return new C0312Ce(this);
    }
}
