package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ServiceManager;
import com.google.common.util.concurrent.s;

/* compiled from: ServiceManager.java */
/* loaded from: classes2.dex */
class w extends s.a<ServiceManager.Listener> {
    public w(String str) {
        super(str);
    }

    @Override // com.google.common.util.concurrent.s.a
    public void a(ServiceManager.Listener listener) {
        listener.b();
    }
}
