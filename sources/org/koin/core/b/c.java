package org.koin.core.b;

/* compiled from: DefinitionInstance.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a */
    private final org.koin.core.d.a f29349a;

    /* renamed from: b */
    private final org.koin.core.a f29350b;

    /* renamed from: c */
    private final org.koin.core.scope.a f29351c;

    /* renamed from: d */
    private final kotlin.jvm.a.a<org.koin.core.d.a> f29352d;

    public c(org.koin.core.a aVar, org.koin.core.scope.a aVar2, kotlin.jvm.a.a<org.koin.core.d.a> aVar3) {
        org.koin.core.d.a invoke;
        this.f29350b = aVar;
        this.f29351c = aVar2;
        this.f29352d = aVar3;
        kotlin.jvm.a.a<org.koin.core.d.a> aVar4 = this.f29352d;
        this.f29349a = (aVar4 == null || (invoke = aVar4.invoke()) == null) ? org.koin.core.d.b.a() : invoke;
    }

    public final org.koin.core.a a() {
        return this.f29350b;
    }

    public final org.koin.core.d.a b() {
        return this.f29349a;
    }

    public final org.koin.core.scope.a c() {
        return this.f29351c;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ c(org.koin.core.a r2, org.koin.core.scope.a r3, kotlin.jvm.a.a r4, int r5, kotlin.jvm.internal.f r6) {
        /*
            r1 = this;
            r6 = r5 & 1
            r0 = 0
            if (r6 == 0) goto L6
            r2 = r0
        L6:
            r6 = r5 & 2
            if (r6 == 0) goto L12
            if (r2 == 0) goto L11
            org.koin.core.scope.a r3 = r2.b()
            goto L12
        L11:
            r3 = r0
        L12:
            r5 = r5 & 4
            if (r5 == 0) goto L17
            r4 = r0
        L17:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.b.c.<init>(org.koin.core.a, org.koin.core.scope.a, kotlin.jvm.a.a, int, kotlin.jvm.internal.f):void");
    }
}
