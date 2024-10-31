package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.2N, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C2N implements Serializable {
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public C00592e A05;
    public String A06;
    public String A07;
    public boolean A08;
    public boolean A09;

    public final C2N A0A(int i) {
        this.A00 = i;
        return this;
    }

    public final C2N A0B(int i) {
        this.A01 = i;
        return this;
    }

    public final C2N A0C(int i) {
        this.A02 = i;
        return this;
    }

    public final C2N A0D(int i) {
        this.A03 = i;
        return this;
    }

    public final C2N A0E(int i) {
        this.A04 = i;
        return this;
    }

    public final C2N A0F(@Nullable C00592e c00592e) {
        this.A05 = c00592e;
        return this;
    }

    public final C2N A0G(String str) {
        this.A06 = str;
        return this;
    }

    public final C2N A0H(String str) {
        this.A07 = str;
        return this;
    }

    public final C2N A0I(boolean z) {
        this.A08 = z;
        return this;
    }

    public final C2N A0J(boolean z) {
        this.A09 = z;
        return this;
    }

    public final C2O A0K() {
        return new C2O(this);
    }
}
