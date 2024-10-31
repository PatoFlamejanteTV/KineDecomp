package com.google.android.gms.tagmanager;

import java.util.List;

/* loaded from: classes.dex */
class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2221a;
    final /* synthetic */ long b;
    final /* synthetic */ ar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, List list, long j) {
        this.c = arVar;
        this.f2221a = list;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.b(this.f2221a, this.b);
    }
}
