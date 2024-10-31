package com.bumptech.glide.load.engine;

import com.bumptech.glide.g.a.d;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class t implements d.a<u<?>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s.b f8953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s.b bVar) {
        this.f8953a = bVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g.a.d.a
    public u<?> create() {
        s.b bVar = this.f8953a;
        return new u<>(bVar.f8942a, bVar.f8943b, bVar.f8944c, bVar.f8945d, bVar.f8946e, bVar.f8947f);
    }
}
