package com.google.common.eventbus;

import com.google.common.eventbus.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Dispatcher.java */
/* loaded from: classes2.dex */
public class c extends ThreadLocal<Boolean> {

    /* renamed from: a */
    final /* synthetic */ d.a f15907a;

    public c(d.a aVar) {
        this.f15907a = aVar;
    }

    @Override // java.lang.ThreadLocal
    public Boolean initialValue() {
        return false;
    }
}
