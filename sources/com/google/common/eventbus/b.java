package com.google.common.eventbus;

import com.google.common.collect.Queues;
import com.google.common.eventbus.d;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Dispatcher.java */
/* loaded from: classes2.dex */
public class b extends ThreadLocal<Queue<Object>> {

    /* renamed from: a */
    final /* synthetic */ d.a f15906a;

    public b(d.a aVar) {
        this.f15906a = aVar;
    }

    @Override // java.lang.ThreadLocal
    public Queue<Object> initialValue() {
        return Queues.a();
    }
}
