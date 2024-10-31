package com.google.common.eventbus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class d extends ThreadLocal<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBus f2899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EventBus eventBus) {
        this.f2899a = eventBus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean initialValue() {
        return false;
    }
}
