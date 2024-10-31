package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1410d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f13753a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f13754b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Object f13755c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Object f13756d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Object f13757e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzas f13758f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1410d(zzas zzasVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f13758f = zzasVar;
        this.f13753a = i;
        this.f13754b = str;
        this.f13755c = obj;
        this.f13756d = obj2;
        this.f13757e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        long j;
        char c3;
        long j2;
        C1428m q = this.f13758f.f13672a.q();
        if (!q.k()) {
            this.f13758f.a(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c2 = this.f13758f.f13932c;
        if (c2 == 0) {
            if (this.f13758f.j().k()) {
                zzas zzasVar = this.f13758f;
                zzasVar.zzgw();
                zzasVar.f13932c = 'C';
            } else {
                zzas zzasVar2 = this.f13758f;
                zzasVar2.zzgw();
                zzasVar2.f13932c = 'c';
            }
        }
        j = this.f13758f.f13933d;
        if (j < 0) {
            zzas zzasVar3 = this.f13758f;
            zzasVar3.f13933d = zzasVar3.j().l();
        }
        char charAt = "01VDIWEA?".charAt(this.f13753a);
        c3 = this.f13758f.f13932c;
        j2 = this.f13758f.f13933d;
        String a2 = zzas.a(true, this.f13754b, this.f13755c, this.f13756d, this.f13757e);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c3);
        sb.append(j2);
        sb.append(":");
        sb.append(a2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f13754b.substring(0, 1024);
        }
        q.f13799e.a(sb2, 1L);
    }
}
