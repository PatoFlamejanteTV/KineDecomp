package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Ig, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0466Ig {
    public static final Set<Object> A00 = Collections.newSetFromMap(new WeakHashMap());
    public static final AtomicBoolean A01 = new AtomicBoolean();
    public static final AtomicReference<InterfaceC0408Fx> A02 = new AtomicReference<>();

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000a. Please report as an issue. */
    @SuppressLint({"RethrownThrowableArgument"})
    public static void A00(Throwable th, Object obj) throws Throwable {
        InterfaceC0408Fx interfaceC0408Fx = null;
        char c = A01.get() ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    th = th;
                    obj = obj;
                    A00.add(obj);
                    C0479Iu.A00().A5N(3306, th);
                    interfaceC0408Fx = A02.get();
                    c = interfaceC0408Fx != null ? (char) 3 : (char) 4;
                case 3:
                    th = th;
                    obj = obj;
                    interfaceC0408Fx = interfaceC0408Fx;
                    interfaceC0408Fx.A88(th, obj);
                    c = 4;
                case 4:
                    return;
                case 5:
                    throw th;
            }
        }
    }

    public static void A01(boolean z, InterfaceC0408Fx interfaceC0408Fx) {
        A01.set(z);
        A02.set(interfaceC0408Fx);
    }

    public static boolean A02(Object obj) {
        return A00.contains(obj);
    }
}
