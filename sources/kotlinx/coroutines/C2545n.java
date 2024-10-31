package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: CoroutineContext.kt */
/* renamed from: kotlinx.coroutines.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2545n {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLong f28671a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f28672b;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:            if (r0.equals("on") != false) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:            if (r0.equals("") != false) goto L19;     */
    static {
        /*
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r0.<init>()
            kotlinx.coroutines.C2545n.f28671a = r0
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.r.a(r0)
            if (r0 != 0) goto L10
            goto L3a
        L10:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L32
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L29
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L3e
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
            r0 = 0
            goto L3b
        L29:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
            goto L3a
        L32:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
        L3a:
            r0 = 1
        L3b:
            kotlinx.coroutines.C2545n.f28672b = r0
            return
        L3e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2545n.<clinit>():void");
    }

    public static final AbstractC2546o a() {
        return f28672b ? kotlinx.coroutines.scheduling.b.f28696h : C2541j.f28668d;
    }

    public static final kotlin.coroutines.e a(InterfaceC2550t interfaceC2550t, kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(interfaceC2550t, "receiver$0");
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.coroutines.e plus = interfaceC2550t.a().plus(eVar);
        kotlin.coroutines.e plus2 = C2553w.f28726a ? plus.plus(new r(f28671a.incrementAndGet())) : plus;
        return (plus == D.a() || plus.get(kotlin.coroutines.c.f28514c) != null) ? plus2 : plus2.plus(D.a());
    }

    public static final String a(kotlin.coroutines.e eVar) {
        r rVar;
        String str;
        kotlin.jvm.internal.h.b(eVar, "receiver$0");
        if (!C2553w.f28726a || (rVar = (r) eVar.get(r.f28674b)) == null) {
            return null;
        }
        C2549s c2549s = (C2549s) eVar.get(C2549s.f28676b);
        if (c2549s == null || (str = c2549s.u()) == null) {
            str = "coroutine";
        }
        return str + '#' + rVar.u();
    }
}
