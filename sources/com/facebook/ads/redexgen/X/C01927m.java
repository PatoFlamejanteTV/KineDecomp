package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C01927m<T> implements InvocationHandler {
    public static byte[] A02;
    public ClassLoader A00;
    public T A01;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01927m.A02
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 111(0x6f, float:1.56E-43)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01927m.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{89, 72, 81};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.7m != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public C01927m(T impl, ClassLoader classLoader) {
        this.A01 = impl;
        this.A00 = classLoader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0076, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object A00(final java.lang.ClassLoader r5, java.lang.reflect.Method r6) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            r0 = 0
            r1 = 0
            java.lang.Class r3 = r6.getReturnType()
            java.lang.Class r0 = java.lang.Void.TYPE
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L72
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L44;
                case 3: goto L74;
                case 4: goto L38;
                case 5: goto L27;
                case 6: goto L18;
                case 7: goto L47;
                case 8: goto L51;
                case 9: goto L5e;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L24
            r0 = 7
            goto L14
        L24:
            r0 = 8
            goto L14
        L27:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            r1 = 0
            java.lang.Class r0 = r6.getReturnType()
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r4)
            java.lang.Object r1 = java.lang.reflect.Array.get(r0, r1)
            r0 = 3
            goto L14
        L38:
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isPrimitive()
            if (r0 == 0) goto L42
            r0 = 5
            goto L14
        L42:
            r0 = 6
            goto L14
        L44:
            r1 = 0
            r0 = 3
            goto L14
        L47:
            r2 = 0
            r1 = 0
            r0 = 103(0x67, float:1.44E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 3
            goto L14
        L51:
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isInterface()
            if (r0 == 0) goto L5c
            r0 = 9
            goto L14
        L5c:
            r0 = 3
            goto L14
        L5e:
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5
            java.lang.Class r3 = (java.lang.Class) r3
            r0 = 0
            java.lang.Class[] r1 = new java.lang.Class[r4]
            r1[r0] = r3
            com.facebook.ads.redexgen.X.7l r0 = new com.facebook.ads.redexgen.X.7l
            r0.<init>()
            java.lang.Object r1 = java.lang.reflect.Proxy.newProxyInstance(r5, r1, r0)
            r0 = 3
            goto L14
        L72:
            r0 = 4
            goto L14
        L74:
            java.lang.Object r1 = (java.lang.Object) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01927m.A00(java.lang.ClassLoader, java.lang.reflect.Method):java.lang.Object");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.7m != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public final T A04() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.7m != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    @Override // java.lang.reflect.InvocationHandler
    @SuppressLint({"CatchGeneralException"})
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        C01927m<T> c01927m = this;
        Object obj2 = null;
        Throwable th = null;
        Throwable th2 = null;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c01927m = c01927m;
                        obj2 = method.invoke(c01927m.A01, objArr);
                        c = '\t';
                        break;
                    } catch (Throwable th3) {
                        th = th3;
                        if (!(th instanceof InvocationTargetException)) {
                            c = '\b';
                            break;
                        } else {
                            c = 6;
                            break;
                        }
                    }
                case 6:
                    th = th;
                    th2 = ((InvocationTargetException) th).getTargetException();
                    if (!(th2 instanceof C3Z)) {
                        c = '\b';
                        break;
                    } else {
                        c = 7;
                        break;
                    }
                case 7:
                    throw new IllegalStateException(th2.getMessage());
                case '\b':
                    c01927m = c01927m;
                    method = method;
                    th = th;
                    obj2 = A00(c01927m.A00, method);
                    C0511Kb.A0E(A02(0, 3, 87), C0512Kc.A0D, new C0514Ke(th));
                    c = '\t';
                    break;
                case '\t':
                    return obj2;
            }
        }
    }
}
