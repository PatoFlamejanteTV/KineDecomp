package com.bumptech.glide.load.engine;

import com.bumptech.glide.g.a.d;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class r implements d.a<DecodeJob<?>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s.a f8930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(s.a aVar) {
        this.f8930a = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.g.a.d.a
    public DecodeJob<?> create() {
        s.a aVar = this.f8930a;
        return new DecodeJob<>(aVar.f8939a, aVar.f8940b);
    }
}
