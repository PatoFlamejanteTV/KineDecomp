package com.adobe.creativesdk.foundation.internal.storage.controllers;

/* compiled from: AssetsRecyclerListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.sb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC0471sb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f6398a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AbstractC0476tb f6399b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0471sb(AbstractC0476tb abstractC0476tb, int i) {
        this.f6399b = abstractC0476tb;
        this.f6398a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6399b.f6412c.scrollToPosition(this.f6398a);
    }
}
