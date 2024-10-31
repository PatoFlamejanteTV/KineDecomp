package com.google.common.eventbus;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class c extends ThreadLocal<ConcurrentLinkedQueue<Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBus f2898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EventBus eventBus) {
        this.f2898a = eventBus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConcurrentLinkedQueue<Object> initialValue() {
        return new ConcurrentLinkedQueue<>();
    }
}
