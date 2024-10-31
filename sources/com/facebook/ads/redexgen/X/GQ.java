package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class GQ {
    public static GQ A00 = new GQ();

    @VisibleForTesting
    public GQ() {
    }

    public static GQ A00() {
        return A00;
    }

    @Nullable
    public static Map<String, String> A01() {
        return GS.A05();
    }

    @SuppressLint({"InstanceMethodCanBeStatic"})
    public final GP A02(C0361Eb c0361Eb, boolean z) {
        return new GS(c0361Eb, z);
    }

    @SuppressLint({"CatchGeneralException"})
    public final Map<String, String> A03(C0361Eb c0361Eb) {
        try {
            return A02(c0361Eb, false).A4c();
        } catch (Throwable th) {
            C0511Kb.A0F(th);
            return GK.A01(c0361Eb);
        }
    }
}
