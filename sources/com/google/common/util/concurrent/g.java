package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractService.a f2977a;
    final /* synthetic */ Service.State b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ AbstractService d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbstractService abstractService, AbstractService.a aVar, Service.State state, Throwable th) {
        this.d = abstractService;
        this.f2977a = aVar;
        this.b = state;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2977a.a(new h(this));
    }
}
