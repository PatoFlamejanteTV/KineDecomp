package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public class d extends kotlinx.coroutines.internal.l<h> {
    public d() {
        super(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:            r7 = r9;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.scheduling.h a(kotlinx.coroutines.scheduling.TaskMode r12) {
        /*
            r11 = this;
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.h.b(r12, r0)
        L5:
            java.lang.Object r0 = r11._cur$internal
            kotlinx.coroutines.internal.m r0 = (kotlinx.coroutines.internal.m) r0
        L9:
            long r3 = r0._state$internal
            r1 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            r5 = 0
            r7 = 0
            int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r8 == 0) goto L19
            kotlinx.coroutines.internal.q r7 = kotlinx.coroutines.internal.m.f28647c
            goto L95
        L19:
            kotlinx.coroutines.internal.m$a r1 = kotlinx.coroutines.internal.m.f28648d
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r5 = 0
            long r1 = r1 >> r5
            int r8 = (int) r1
            r1 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r1 = r1 & r3
            r6 = 30
            long r1 = r1 >> r6
            int r2 = (int) r1
            int r1 = kotlinx.coroutines.internal.m.b(r0)
            r1 = r1 & r2
            int r2 = kotlinx.coroutines.internal.m.b(r0)
            r2 = r2 & r8
            if (r1 != r2) goto L39
            goto L95
        L39:
            java.util.concurrent.atomic.AtomicReferenceArray r1 = kotlinx.coroutines.internal.m.a(r0)
            int r2 = kotlinx.coroutines.internal.m.b(r0)
            r2 = r2 & r8
            java.lang.Object r9 = r1.get(r2)
            if (r9 != 0) goto L4f
            boolean r1 = kotlinx.coroutines.internal.m.c(r0)
            if (r1 == 0) goto L9
            goto L95
        L4f:
            boolean r1 = r9 instanceof kotlinx.coroutines.internal.m.b
            if (r1 == 0) goto L54
            goto L95
        L54:
            r1 = r9
            kotlinx.coroutines.scheduling.h r1 = (kotlinx.coroutines.scheduling.h) r1
            kotlinx.coroutines.scheduling.TaskMode r1 = r1.b()
            if (r1 != r12) goto L5e
            r5 = 1
        L5e:
            if (r5 != 0) goto L61
            goto L95
        L61:
            int r1 = r8 + 1
            r2 = 1073741823(0x3fffffff, float:1.9999999)
            r10 = r1 & r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.m.f28646b
            kotlinx.coroutines.internal.m$a r2 = kotlinx.coroutines.internal.m.f28648d
            long r5 = r2.a(r3, r10)
            r2 = r0
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L84
            java.util.concurrent.atomic.AtomicReferenceArray r1 = kotlinx.coroutines.internal.m.a(r0)
            int r2 = kotlinx.coroutines.internal.m.b(r0)
            r2 = r2 & r8
            r1.set(r2, r7)
            goto L94
        L84:
            boolean r1 = kotlinx.coroutines.internal.m.c(r0)
            if (r1 != 0) goto L8c
            goto L9
        L8c:
            r1 = r0
        L8d:
            kotlinx.coroutines.internal.m r1 = kotlinx.coroutines.internal.m.a(r1, r8, r10)
            if (r1 == 0) goto L94
            goto L8d
        L94:
            r7 = r9
        L95:
            kotlinx.coroutines.internal.q r1 = kotlinx.coroutines.internal.m.f28647c
            if (r7 == r1) goto L9c
            kotlinx.coroutines.scheduling.h r7 = (kotlinx.coroutines.scheduling.h) r7
            return r7
        L9c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.l.f28644a
            kotlinx.coroutines.internal.m r2 = r0.d()
            r1.compareAndSet(r11, r0, r2)
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.d.a(kotlinx.coroutines.scheduling.TaskMode):kotlinx.coroutines.scheduling.h");
    }
}
