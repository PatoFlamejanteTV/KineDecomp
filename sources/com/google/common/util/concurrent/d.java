package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AbstractScheduledService.java */
/* loaded from: classes2.dex */
class d extends AbstractService {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractScheduledService f2974a;
    private final ReentrantLock b = new ReentrantLock();
    private final Runnable c = new e(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AbstractScheduledService abstractScheduledService) {
        this.f2974a = abstractScheduledService;
    }
}
