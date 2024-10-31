package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
public class i extends s.a<Service.Listener> {

    /* renamed from: b */
    final /* synthetic */ Service.State f16200b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, Service.State state) {
        super(str);
        this.f16200b = state;
    }

    @Override // com.google.common.util.concurrent.s.a
    public void a(Service.Listener listener) {
        listener.a(this.f16200b);
    }
}
