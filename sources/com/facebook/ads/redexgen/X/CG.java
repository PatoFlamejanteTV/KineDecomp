package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* loaded from: assets/audience_network.dex */
public final class CG extends C0279Ax {
    public static PackageManager A00;

    public CG(Context context, AA aa) {
        super(context, aa);
        A00 = context.getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A03(HashMap<String, CF> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A0C);
    }

    public final InterfaceC0267Al A0G(List<C0345Dl> list) {
        return new CE(this, list);
    }
}
