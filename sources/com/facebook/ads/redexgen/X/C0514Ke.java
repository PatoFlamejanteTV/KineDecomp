package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ke, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0514Ke extends Exception {
    public int A00;
    public int A01;

    @Nullable
    public JSONObject A02;
    public boolean A03;
    public boolean A04;

    public C0514Ke(String str) {
        super(str);
        this.A00 = 0;
        this.A03 = true;
        this.A01 = -1;
    }

    public C0514Ke(String str, String str2) {
        super(str + '\n' + str2);
        this.A00 = 0;
        this.A03 = true;
        this.A01 = -1;
    }

    public C0514Ke(Throwable th) {
        super(th);
        this.A00 = 0;
        this.A03 = true;
        this.A01 = -1;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    @Nullable
    public final JSONObject A02() {
        return this.A02;
    }

    public final void A03(int i) {
        this.A00 = i;
    }

    public final void A04(int i) {
        this.A01 = i;
    }

    public final void A05(@Nullable JSONObject jSONObject) {
        this.A02 = jSONObject;
    }

    public final void A06(boolean z) {
        this.A03 = z;
    }

    public final void A07(boolean z) {
        this.A04 = z;
    }

    public final boolean A08() {
        return this.A03;
    }

    public final boolean A09() {
        return this.A04;
    }
}
