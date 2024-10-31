package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.wc;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetriableStream.java */
/* renamed from: io.grpc.internal.lc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC2458lc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f27666a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ wc.g f27667b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ wc f27668c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2458lc(wc wcVar, Collection collection, wc.g gVar) {
        this.f27668c = wcVar;
        this.f27666a = collection;
        this.f27667b = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Status status;
        for (wc.g gVar : this.f27666a) {
            if (gVar != this.f27667b) {
                X x = gVar.f27777a;
                status = wc.f27758c;
                x.a(status);
            }
        }
        this.f27668c.e();
    }
}
