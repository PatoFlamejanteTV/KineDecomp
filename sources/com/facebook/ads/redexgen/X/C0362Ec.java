package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.api.Repairable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0362Ec extends C0361Eb {
    public WeakHashMap<Repairable, Boolean> A00;
    public final WeakReference<Activity> A01;
    public final AtomicReference<InterfaceC00050c> A02;

    public C0362Ec(Activity activity, InterfaceC0367Eh interfaceC0367Eh, InterfaceC00050c interfaceC00050c) {
        super(activity.getApplicationContext(), interfaceC0367Eh);
        this.A00 = new WeakHashMap<>();
        this.A02 = new AtomicReference<>();
        this.A02.set(interfaceC00050c);
        this.A01 = new WeakReference<>(activity);
    }

    public C0362Ec(Context context, InterfaceC0367Eh interfaceC0367Eh, InterfaceC00050c interfaceC00050c) {
        super(context.getApplicationContext(), interfaceC0367Eh);
        this.A00 = new WeakHashMap<>();
        this.A02 = new AtomicReference<>();
        this.A02.set(interfaceC00050c);
        Activity A00 = A00(context);
        if (A00 != null) {
            this.A01 = new WeakReference<>(A00);
        } else {
            this.A01 = new WeakReference<>(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0058, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.app.Activity A00(android.content.Context r2) {
        /*
            r1 = 0
            r0 = 2
        L2:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L18;
                case 4: goto L11;
                case 5: goto L56;
                case 6: goto L6;
                case 7: goto L2d;
                case 8: goto L41;
                case 9: goto L4c;
                case 10: goto L3e;
                default: goto L5;
            }
        L5:
            goto L2
        L6:
            android.content.Context r2 = (android.content.Context) r2
            boolean r0 = r2 instanceof com.facebook.ads.redexgen.X.C0362Ec
            if (r0 == 0) goto Le
            r0 = 7
            goto L2
        Le:
            r0 = 9
            goto L2
        L11:
            android.content.Context r2 = (android.content.Context) r2
            r1 = r2
            android.app.Activity r1 = (android.app.Activity) r1
            r0 = 5
            goto L2
        L18:
            android.content.Context r2 = (android.content.Context) r2
            boolean r0 = r2 instanceof android.app.Activity
            if (r0 == 0) goto L20
            r0 = 4
            goto L2
        L20:
            r0 = 6
            goto L2
        L22:
            android.content.Context r2 = (android.content.Context) r2
            boolean r0 = r2 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L2a
            r0 = 3
            goto L2
        L2a:
            r0 = 10
            goto L2
        L2d:
            android.content.Context r2 = (android.content.Context) r2
            r0 = r2
            com.facebook.ads.redexgen.X.Ec r0 = (com.facebook.ads.redexgen.X.C0362Ec) r0
            android.app.Activity r0 = r0.A07()
            if (r0 == 0) goto L3b
            r0 = 8
            goto L2
        L3b:
            r0 = 9
            goto L2
        L3e:
            r1 = 0
            r0 = 5
            goto L2
        L41:
            android.content.Context r2 = (android.content.Context) r2
            r0 = r2
            com.facebook.ads.redexgen.X.Ec r0 = (com.facebook.ads.redexgen.X.C0362Ec) r0
            android.app.Activity r1 = r0.A07()
            r0 = 5
            goto L2
        L4c:
            android.content.Context r2 = (android.content.Context) r2
            android.content.ContextWrapper r2 = (android.content.ContextWrapper) r2
            android.content.Context r2 = r2.getBaseContext()
            r0 = 2
            goto L2
        L56:
            android.app.Activity r1 = (android.app.Activity) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0362Ec.A00(android.content.Context):android.app.Activity");
    }

    @Nullable
    public final Activity A07() {
        return this.A01.get();
    }

    public InterfaceC00050c A08() {
        InterfaceC00050c interfaceC00050c = this.A02.get();
        if (interfaceC00050c == null) {
            return new C00270y();
        }
        return interfaceC00050c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09(android.content.Intent r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            android.app.Activity r1 = r2.A07()
            if (r1 == 0) goto L28
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L2a;
                case 4: goto L16;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            android.content.Intent r4 = (android.content.Intent) r4
            android.app.Activity r1 = (android.app.Activity) r1
            r1.startActivity(r4)
            r0 = 3
            goto L9
        L16:
            com.facebook.ads.redexgen.X.Ec r2 = (com.facebook.ads.redexgen.X.C0362Ec) r2
            android.content.Intent r4 = (android.content.Intent) r4
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r4.addFlags(r0)
            android.content.Context r0 = r2.getApplicationContext()
            r0.startActivity(r4)
            r0 = 3
            goto L9
        L28:
            r0 = 4
            goto L9
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0362Ec.A09(android.content.Intent):void");
    }

    public final void A0A(InterfaceC00050c interfaceC00050c) {
        this.A02.set(interfaceC00050c);
    }

    public final void A0B(Repairable repairable) {
        this.A00.put(repairable, true);
    }

    public final void A0C(C0362Ec c0362Ec) {
        c0362Ec.A00.putAll(this.A00);
        this.A00 = c0362Ec.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0D(java.lang.Throwable r3) {
        /*
            r2 = this;
            r0 = 0
            java.util.WeakHashMap<com.facebook.ads.internal.api.Repairable, java.lang.Boolean> r0 = r2.A00
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1c;
                case 4: goto L31;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L1a
            r0 = 3
            goto Lc
        L1a:
            r0 = 4
            goto Lc
        L1c:
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getKey()
            com.facebook.ads.internal.api.Repairable r0 = (com.facebook.ads.internal.api.Repairable) r0
            r0.repair(r3)
            r0 = 2
            goto Lc
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0362Ec.A0D(java.lang.Throwable):void");
    }
}
