package com.google.common.eventbus;

import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Dispatcher.java */
/* loaded from: classes2.dex */
public abstract class d {
    d() {
    }

    public static d a() {
        return new a();
    }

    /* compiled from: Dispatcher.java */
    /* loaded from: classes2.dex */
    public static final class a extends d {

        /* renamed from: a */
        private final ThreadLocal<Queue<Object>> f15908a;

        /* renamed from: b */
        private final ThreadLocal<Boolean> f15909b;

        private a() {
            this.f15908a = new b(this);
            this.f15909b = new c(this);
        }

        /* synthetic */ a(com.google.common.eventbus.a aVar) {
            this();
        }
    }
}
