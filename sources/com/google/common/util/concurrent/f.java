package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
public class f implements Service.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractService f2976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbstractService abstractService) {
        this.f2976a = abstractService;
    }

    @Override // com.google.common.util.concurrent.Service.Listener
    public void a(Service.State state, Throwable th) {
        AbstractService.c cVar;
        AbstractService.c cVar2;
        AbstractService.c cVar3;
        AbstractService.c cVar4;
        switch (state) {
            case STARTING:
                cVar3 = this.f2976a.c;
                cVar3.a(th);
                cVar4 = this.f2976a.d;
                cVar4.a((Throwable) new Exception("Service failed to start.", th));
                return;
            case RUNNING:
                cVar2 = this.f2976a.d;
                cVar2.a((Throwable) new Exception("Service failed while running", th));
                return;
            case STOPPING:
                cVar = this.f2976a.d;
                cVar.a(th);
                return;
            default:
                throw new AssertionError("Unexpected from state: " + state);
        }
    }
}
