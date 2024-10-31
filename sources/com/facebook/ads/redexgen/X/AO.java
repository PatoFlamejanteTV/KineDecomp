package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class AO {

    @Nullable
    public static AO A07;
    public static final AtomicBoolean A08 = new AtomicBoolean();
    public AN A00 = new AN(this, EG.A00().A03().getLooper());
    public AX A01;
    public AY A02;
    public List<EnumC0257Ab> A03;
    public final Context A04;
    public final AA A05;
    public final EnumC0349Dp A06;

    public AO(AA aa, Context context) {
        this.A05 = aa;
        this.A04 = context;
        this.A06 = aa.A0a();
    }

    public static synchronized AO A00(Context context, AA aa) {
        AO ao;
        synchronized (AO.class) {
            if (A07 == null) {
                A07 = new AO(aa, context);
            }
            ao = A07;
        }
        return ao;
    }

    private synchronized void A02() {
        A08.set(false);
        this.A03 = new ArrayList();
    }

    public final synchronized void A03() {
        if (this.A01 != null) {
            this.A01.A03(this.A03);
        }
        A02();
    }

    public final synchronized void A04(Map<Integer, C0343Dj> map, EnumC0346Dm enumC0346Dm) {
        A02();
        AS as = new AS(this.A05, map);
        for (Map.Entry<Integer, C0343Dj> entry : map.entrySet()) {
            C0343Dj value = entry.getValue();
            if (value != null && value.A04(enumC0346Dm)) {
                switch (entry.getKey().intValue()) {
                    case 10800:
                        this.A02 = new AY(this.A04, as, this.A06);
                        A08.set(true);
                        break;
                    case 10810:
                        this.A03.add(EnumC0257Ab.A03);
                        break;
                    case 10811:
                        this.A03.add(EnumC0257Ab.A07);
                        break;
                    case 10812:
                        this.A03.add(EnumC0257Ab.A09);
                        break;
                    case 10813:
                        this.A03.add(EnumC0257Ab.A06);
                        break;
                    case 10814:
                        this.A03.add(EnumC0257Ab.A0A);
                        break;
                    case 10815:
                        this.A03.add(EnumC0257Ab.A0B);
                        break;
                    case 10816:
                        this.A03.add(EnumC0257Ab.A0D);
                        break;
                    case 10817:
                        this.A03.add(EnumC0257Ab.A08);
                        break;
                    case 10818:
                        this.A03.add(EnumC0257Ab.A05);
                        break;
                    case 10819:
                        this.A03.add(EnumC0257Ab.A04);
                        break;
                    case 10820:
                        this.A03.add(EnumC0257Ab.A0C);
                        break;
                }
            }
        }
        this.A01 = new AX(this.A04, as, this.A06);
        this.A01.A02(this.A03);
        if (!this.A00.getLooper().getThread().isAlive()) {
            this.A00 = new AN(this, EG.A00().A03().getLooper());
        }
    }

    public final synchronized boolean A05(MotionEvent motionEvent) {
        boolean z;
        if (A08.get()) {
            Message message = new Message();
            message.what = AM.A02.ordinal();
            message.obj = motionEvent;
            this.A00.sendMessage(message);
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
