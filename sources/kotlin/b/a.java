package kotlin.b;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: kotlin.b.a$a */
    /* loaded from: classes3.dex */
    public static final class C0165a {

        /* renamed from: a */
        public static final Method f28496a;

        /* renamed from: b */
        public static final C0165a f28497b = new C0165a();

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[EDGE_INSN: B:10:0x0049->B:11:0x0049 BREAK  A[LOOP:0: B:2:0x0015->B:9:0x0045], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0045 A[LOOP:0: B:2:0x0015->B:9:0x0045, LOOP_END] */
        static {
            /*
                kotlin.b.a$a r0 = new kotlin.b.a$a
                r0.<init>()
                kotlin.b.a.C0165a.f28497b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                kotlin.jvm.internal.h.a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                if (r4 >= r2) goto L48
                r5 = r1[r4]
                java.lang.String r6 = "it"
                kotlin.jvm.internal.h.a(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = kotlin.jvm.internal.h.a(r6, r7)
                if (r6 == 0) goto L41
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                kotlin.jvm.internal.h.a(r6, r7)
                java.lang.Object r6 = kotlin.collections.c.b(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = kotlin.jvm.internal.h.a(r6, r0)
                if (r6 == 0) goto L41
                r6 = 1
                goto L42
            L41:
                r6 = 0
            L42:
                if (r6 == 0) goto L45
                goto L49
            L45:
                int r4 = r4 + 1
                goto L15
            L48:
                r5 = 0
            L49:
                kotlin.b.a.C0165a.f28496a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.b.a.C0165a.<clinit>():void");
        }

        private C0165a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        h.b(th, "cause");
        h.b(th2, "exception");
        Method method = C0165a.f28496a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
