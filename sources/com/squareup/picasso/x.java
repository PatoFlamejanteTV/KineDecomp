package com.squareup.picasso;

import com.squareup.picasso.Picasso;

/* compiled from: Picasso.java */
/* loaded from: classes3.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Exception f25678a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Picasso.b f25679b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Picasso.b bVar, Exception exc) {
        this.f25679b = bVar;
        this.f25678a = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException(this.f25678a);
    }
}
