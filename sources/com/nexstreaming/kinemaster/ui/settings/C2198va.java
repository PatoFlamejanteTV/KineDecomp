package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.va, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2198va implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23214a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23215b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2198va(C2202xa c2202xa, Slider slider) {
        this.f23215b = c2202xa;
        this.f23214a = slider;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f23215b.i = (int) (this.f23214a.getValue() * 1000.0f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}