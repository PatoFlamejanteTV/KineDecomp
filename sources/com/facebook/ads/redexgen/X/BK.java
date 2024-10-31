package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import java.util.HashMap;

/* loaded from: assets/audience_network.dex */
public final class BK extends C0279Ax {
    public final Context A00;
    public final ApplicationInfo A01;
    public final AA A02;
    public final EF A03;

    public BK(Context context, AA aa) {
        super(context, aa);
        this.A01 = context.getApplicationInfo();
        this.A00 = context;
        this.A02 = aa;
        this.A03 = EF.A00(this.A00, this.A02.A0a(), this.A02.A0g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A05(HashMap<Integer, BJ> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A06);
    }

    public final InterfaceC0267Al A0G() {
        return new B8(this);
    }

    public final InterfaceC0267Al A0H() {
        return new B6(this);
    }

    public final InterfaceC0267Al A0I() {
        return new B5(this);
    }

    public final InterfaceC0267Al A0J() {
        return new B1(this);
    }

    public final InterfaceC0267Al A0K() {
        return new BD(this);
    }

    public final InterfaceC0267Al A0L() {
        return new BG(this);
    }

    public final InterfaceC0267Al A0M() {
        return new B9(this);
    }

    public final InterfaceC0267Al A0N() {
        return new BA(this);
    }

    public final InterfaceC0267Al A0O() {
        return new BE(this);
    }

    public final InterfaceC0267Al A0P() {
        return new BH(this);
    }

    public final InterfaceC0267Al A0Q() {
        return new BF(this);
    }

    public final InterfaceC0267Al A0R() {
        return new BC(this);
    }

    public final InterfaceC0267Al A0S() {
        return new BB(this);
    }

    public final InterfaceC0267Al A0T() {
        return new C0281Az(this);
    }

    public final InterfaceC0267Al A0U() {
        return new B0(this);
    }

    public final InterfaceC0267Al A0V() {
        return new B2(this);
    }

    public final InterfaceC0267Al A0W() {
        return new B3(this);
    }

    public final InterfaceC0267Al A0X() {
        return new B4(this);
    }

    public final InterfaceC0267Al A0Y() {
        return new B7(this);
    }
}
