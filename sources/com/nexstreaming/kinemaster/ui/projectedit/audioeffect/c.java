package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioEffectAdapter.kt */
/* loaded from: classes2.dex */
public final class c<T> implements io.reactivex.c.e<Pair<? extends AudioPlayStatus, ? extends b>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f22228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar) {
        this.f22228a = fVar;
    }

    @Override // io.reactivex.c.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Pair<? extends AudioPlayStatus, b> pair) {
        this.f22228a.a(pair.getFirst(), pair.getSecond());
    }
}
