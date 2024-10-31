package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.s;

/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
public class j extends s.a<Service.Listener> {

    /* renamed from: b */
    final /* synthetic */ Service.State f16201b;

    /* renamed from: c */
    final /* synthetic */ Throwable f16202c;

    /* renamed from: d */
    final /* synthetic */ AbstractService f16203d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(AbstractService abstractService, String str, Service.State state, Throwable th) {
        super(str);
        this.f16203d = abstractService;
        this.f16201b = state;
        this.f16202c = th;
    }

    @Override // com.google.common.util.concurrent.s.a
    public void a(Service.Listener listener) {
        listener.a(this.f16201b, this.f16202c);
    }
}
