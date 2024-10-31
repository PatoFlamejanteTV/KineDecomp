package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.kinemaster.kmpackage.EffectPreviewView;

/* compiled from: EffectPreviewView.java */
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectPreviewView.a f3468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EffectPreviewView.a aVar) {
        this.f3468a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EffectPreviewView.this.setVisibility(0);
    }
}
