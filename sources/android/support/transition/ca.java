package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
public class ca implements ea {

    /* renamed from: a */
    private static LayoutTransition f571a;

    /* renamed from: b */
    private static Field f572b;

    /* renamed from: c */
    private static boolean f573c;

    /* renamed from: d */
    private static Method f574d;

    /* renamed from: e */
    private static boolean f575e;

    @Override // android.support.transition.ea
    public Z a(ViewGroup viewGroup) {
        return X.a(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.support.transition.ea
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.ViewGroup r6, boolean r7) {
        /*
            r5 = this;
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            android.support.transition.ba r0 = new android.support.transition.ba
            r0.<init>(r5)
            android.support.transition.ca.f571a = r0
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            r4 = 4
            r0.setAnimator(r4, r3)
        L2a:
            if (r7 == 0) goto L4a
            android.animation.LayoutTransition r7 = r6.getLayoutTransition()
            if (r7 == 0) goto L44
            boolean r0 = r7.isRunning()
            if (r0 == 0) goto L3b
            a(r7)
        L3b:
            android.animation.LayoutTransition r0 = android.support.transition.ca.f571a
            if (r7 == r0) goto L44
            int r0 = android.support.transition.G.transition_layout_save
            r6.setTag(r0, r7)
        L44:
            android.animation.LayoutTransition r7 = android.support.transition.ca.f571a
            r6.setLayoutTransition(r7)
            goto L9a
        L4a:
            r6.setLayoutTransition(r3)
            boolean r7 = android.support.transition.ca.f573c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r7 != 0) goto L6a
            java.lang.Class<android.view.ViewGroup> r7 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L63
            android.support.transition.ca.f572b = r7     // Catch: java.lang.NoSuchFieldException -> L63
            java.lang.reflect.Field r7 = android.support.transition.ca.f572b     // Catch: java.lang.NoSuchFieldException -> L63
            r7.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L63
            goto L68
        L63:
            java.lang.String r7 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r7)
        L68:
            android.support.transition.ca.f573c = r1
        L6a:
            java.lang.reflect.Field r7 = android.support.transition.ca.f572b
            if (r7 == 0) goto L83
            boolean r7 = r7.getBoolean(r6)     // Catch: java.lang.IllegalAccessException -> L7e
            if (r7 == 0) goto L7c
            java.lang.reflect.Field r1 = android.support.transition.ca.f572b     // Catch: java.lang.IllegalAccessException -> L7a
            r1.setBoolean(r6, r2)     // Catch: java.lang.IllegalAccessException -> L7a
            goto L7c
        L7a:
            r2 = r7
            goto L7e
        L7c:
            r2 = r7
            goto L83
        L7e:
            java.lang.String r7 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r7)
        L83:
            if (r2 == 0) goto L88
            r6.requestLayout()
        L88:
            int r7 = android.support.transition.G.transition_layout_save
            java.lang.Object r7 = r6.getTag(r7)
            android.animation.LayoutTransition r7 = (android.animation.LayoutTransition) r7
            if (r7 == 0) goto L9a
            int r0 = android.support.transition.G.transition_layout_save
            r6.setTag(r0, r3)
            r6.setLayoutTransition(r7)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ca.a(android.view.ViewGroup, boolean):void");
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f575e) {
            try {
                f574d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f574d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f575e = true;
        }
        Method method = f574d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
