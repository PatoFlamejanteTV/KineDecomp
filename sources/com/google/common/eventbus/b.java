package com.google.common.eventbus;

import com.google.common.base.Supplier;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class b implements Supplier<Set<Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBus f2897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EventBus eventBus) {
        this.f2897a = eventBus;
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Set<Object> get() {
        return this.f2897a.a();
    }
}
