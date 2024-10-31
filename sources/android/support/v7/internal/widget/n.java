package android.support.v7.internal.widget;

import android.graphics.Rect;
import android.os.Build;

/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Rect f181a = new Rect();
    private static Class<?> b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:            switch(r1) {            case 0: goto L24;            case 1: goto L30;            case 2: goto L31;            case 3: goto L32;            default: goto L37;        };     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:            r0.left = r7.getInt(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:            r3 = r3 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:            r0.top = r7.getInt(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:            r0.right = r7.getInt(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:            r0.bottom = r7.getInt(r4);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Rect a(android.graphics.drawable.Drawable r10) {
        /*
            r2 = 0
            java.lang.Class<?> r0 = android.support.v7.internal.widget.n.b
            if (r0 == 0) goto L7a
            android.graphics.drawable.Drawable r0 = android.support.v4.b.a.a.d(r10)     // Catch: java.lang.Exception -> L72
            java.lang.Class r1 = r0.getClass()     // Catch: java.lang.Exception -> L72
            java.lang.String r3 = "getOpticalInsets"
            r4 = 0
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L72
            java.lang.reflect.Method r1 = r1.getMethod(r3, r4)     // Catch: java.lang.Exception -> L72
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L72
            java.lang.Object r4 = r1.invoke(r0, r3)     // Catch: java.lang.Exception -> L72
            if (r4 == 0) goto L7a
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch: java.lang.Exception -> L72
            r0.<init>()     // Catch: java.lang.Exception -> L72
            java.lang.Class<?> r1 = android.support.v7.internal.widget.n.b     // Catch: java.lang.Exception -> L72
            java.lang.reflect.Field[] r5 = r1.getFields()     // Catch: java.lang.Exception -> L72
            int r6 = r5.length     // Catch: java.lang.Exception -> L72
            r3 = r2
        L2c:
            if (r3 >= r6) goto L7c
            r7 = r5[r3]     // Catch: java.lang.Exception -> L72
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Exception -> L72
            r1 = -1
            int r9 = r8.hashCode()     // Catch: java.lang.Exception -> L72
            switch(r9) {
                case -1383228885: goto L61;
                case 115029: goto L4d;
                case 3317767: goto L43;
                case 108511772: goto L57;
                default: goto L3c;
            }     // Catch: java.lang.Exception -> L72
        L3c:
            switch(r1) {
                case 0: goto L6b;
                case 1: goto L7d;
                case 2: goto L84;
                case 3: goto L8b;
                default: goto L3f;
            }     // Catch: java.lang.Exception -> L72
        L3f:
            int r1 = r3 + 1
            r3 = r1
            goto L2c
        L43:
            java.lang.String r9 = "left"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = r2
            goto L3c
        L4d:
            java.lang.String r9 = "top"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 1
            goto L3c
        L57:
            java.lang.String r9 = "right"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 2
            goto L3c
        L61:
            java.lang.String r9 = "bottom"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> L72
            if (r8 == 0) goto L3c
            r1 = 3
            goto L3c
        L6b:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.left = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L72:
            r0 = move-exception
            java.lang.String r0 = "DrawableUtils"
            java.lang.String r1 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r0, r1)
        L7a:
            android.graphics.Rect r0 = android.support.v7.internal.widget.n.f181a
        L7c:
            return r0
        L7d:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.top = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L84:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.right = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        L8b:
            int r1 = r7.getInt(r4)     // Catch: java.lang.Exception -> L72
            r0.bottom = r1     // Catch: java.lang.Exception -> L72
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.n.a(android.graphics.drawable.Drawable):android.graphics.Rect");
    }
}
