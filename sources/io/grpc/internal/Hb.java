package io.grpc.internal;

import io.grpc.internal.Fb;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManagedChannelImpl.java */
/* loaded from: classes3.dex */
public class Hb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2461mb f27356a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fb.b f27357b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(Fb.b bVar, C2461mb c2461mb) {
        this.f27357b = bVar;
        this.f27356a = c2461mb;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set set;
        if (Fb.this.K) {
            this.f27356a.b(Fb.f27281d);
        }
        if (Fb.this.L) {
            return;
        }
        set = Fb.this.E;
        set.add(this.f27356a);
    }
}
