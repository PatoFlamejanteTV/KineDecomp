package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class u extends zzfm {

    /* renamed from: a */
    private static final Object f14211a = new Object();

    /* renamed from: b */
    private static u f14212b;

    /* renamed from: c */
    private n f14213c;

    /* renamed from: d */
    private volatile l f14214d;

    /* renamed from: e */
    private int f14215e = 1800000;

    /* renamed from: f */
    private boolean f14216f = true;

    /* renamed from: g */
    private boolean f14217g = false;

    /* renamed from: h */
    private boolean f14218h = true;
    private boolean i = true;
    private o j = new v(this);
    private boolean k = false;

    private u() {
    }

    public static u b() {
        if (f14212b == null) {
            f14212b = new u();
        }
        return f14212b;
    }

    @Override // com.google.android.gms.tagmanager.zzfm
    public final synchronized void a() {
        if (!this.f14217g) {
            zzdi.a("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f14216f = true;
        } else {
            this.f14214d.a(new w(this));
        }
    }
}
