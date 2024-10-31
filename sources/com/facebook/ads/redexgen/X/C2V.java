package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2V, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2V implements Serializable {
    public static final long serialVersionUID = -2102939945352398575L;
    public String A00;
    public final List<String> A01;

    public C2V(List<String> screenshots) {
        this.A01 = screenshots;
    }

    public final String A00() {
        return this.A00;
    }

    public final List<String> A01() {
        return Collections.unmodifiableList(this.A01);
    }
}
