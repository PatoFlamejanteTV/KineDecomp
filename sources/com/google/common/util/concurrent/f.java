package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.s;

/* compiled from: AbstractService.java */
/* loaded from: classes2.dex */
class f extends s.a<Service.Listener> {
    public f(String str) {
        super(str);
    }

    @Override // com.google.common.util.concurrent.s.a
    public void a(Service.Listener listener) {
        listener.b();
    }
}
