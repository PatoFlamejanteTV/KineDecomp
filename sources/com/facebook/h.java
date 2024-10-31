package com.facebook;

import com.facebook.GraphRequestBatch;
import com.facebook.d;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* loaded from: classes.dex */
public class h implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessToken f266a;
    final /* synthetic */ AtomicBoolean b;
    final /* synthetic */ d.a c;
    final /* synthetic */ Set d;
    final /* synthetic */ Set e;
    final /* synthetic */ d f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, AccessToken accessToken, AtomicBoolean atomicBoolean, d.a aVar, Set set, Set set2) {
        this.f = dVar;
        this.f266a = accessToken;
        this.b = atomicBoolean;
        this.c = aVar;
        this.d = set;
        this.e = set2;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AtomicBoolean atomicBoolean;
        if (d.a().b() != null && d.a().b().getUserId() == this.f266a.getUserId()) {
            try {
                if (this.b.get() || this.c.f262a != null || this.c.b != 0) {
                    d.a().a(new AccessToken(this.c.f262a != null ? this.c.f262a : this.f266a.getToken(), this.f266a.getApplicationId(), this.f266a.getUserId(), this.b.get() ? this.d : this.f266a.getPermissions(), this.b.get() ? this.e : this.f266a.getDeclinedPermissions(), this.f266a.getSource(), this.c.b != 0 ? new Date(this.c.b * 1000) : this.f266a.getExpires(), new Date()));
                }
            } finally {
                atomicBoolean = this.f.e;
                atomicBoolean.set(false);
            }
        }
    }
}
