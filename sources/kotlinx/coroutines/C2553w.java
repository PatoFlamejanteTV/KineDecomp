package kotlinx.coroutines;

import kotlin.Result;

/* compiled from: Debug.kt */
/* renamed from: kotlinx.coroutines.w */
/* loaded from: classes3.dex */
public final class C2553w {

    /* renamed from: a */
    public static final boolean f28726a;

    /* renamed from: b */
    public static final boolean f28727b;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:            if (r0.equals("auto") != false) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:            if (r0.equals("on") != false) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:            if (r0.equals("") != false) goto L53;     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.r.a(r0)
            r1 = 1
            if (r0 != 0) goto La
            goto L26
        La:
            int r2 = r0.hashCode()
            if (r2 == 0) goto L40
            r3 = 3551(0xddf, float:4.976E-42)
            if (r2 == r3) goto L37
            r3 = 109935(0x1ad6f, float:1.54052E-40)
            if (r2 == r3) goto L2d
            r3 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r2 != r3) goto L54
            java.lang.String r2 = "auto"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L54
        L26:
            java.lang.Class<kotlinx.coroutines.r> r0 = kotlinx.coroutines.r.class
            boolean r0 = r0.desiredAssertionStatus()
            goto L49
        L2d:
            java.lang.String r2 = "off"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L54
            r0 = 0
            goto L49
        L37:
            java.lang.String r2 = "on"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L54
            goto L48
        L40:
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L54
        L48:
            r0 = 1
        L49:
            kotlinx.coroutines.C2553w.f28726a = r0
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.r.a(r0, r1)
            kotlinx.coroutines.C2553w.f28727b = r0
            return
        L54:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2553w.<clinit>():void");
    }

    public static final String a(kotlin.coroutines.b<?> bVar) {
        Object a2;
        kotlin.jvm.internal.h.b(bVar, "receiver$0");
        if (bVar instanceof A) {
            return bVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            a2 = bVar + '@' + b(bVar);
            Result.m23constructorimpl(a2);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a2 = kotlin.h.a(th);
            Result.m23constructorimpl(a2);
        }
        if (Result.m26exceptionOrNullimpl(a2) != null) {
            a2 = bVar.getClass().getName() + '@' + b(bVar);
        }
        return (String) a2;
    }

    public static final String b(Object obj) {
        kotlin.jvm.internal.h.b(obj, "receiver$0");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        kotlin.jvm.internal.h.a((Object) hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String a(Object obj) {
        kotlin.jvm.internal.h.b(obj, "receiver$0");
        String simpleName = obj.getClass().getSimpleName();
        kotlin.jvm.internal.h.a((Object) simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
