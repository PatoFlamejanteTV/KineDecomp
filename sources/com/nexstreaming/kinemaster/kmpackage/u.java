package com.nexstreaming.kinemaster.kmpackage;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewPlayer.java */
/* loaded from: classes.dex */
public class u implements Comparator<b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Theme f3465a;
    final /* synthetic */ EffectPreviewPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(EffectPreviewPlayer effectPreviewPlayer, Theme theme) {
        this.b = effectPreviewPlayer;
        this.f3465a = theme;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        int a2;
        int a3;
        a2 = this.b.a(this.f3465a, bVar);
        a3 = this.b.a(this.f3465a, bVar2);
        return a2 - a3;
    }
}
