package com.flurry.sdk;

import com.flurry.sdk.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f489a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, l.a aVar) {
        this.b = lVar;
        this.f489a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.e();
        try {
            this.b.f();
            if (this.f489a != null) {
                this.f489a.a();
            }
        } catch (Exception e) {
            as.a(6, l.d, "retransmitNotSentBlocks error", e);
        }
    }
}
