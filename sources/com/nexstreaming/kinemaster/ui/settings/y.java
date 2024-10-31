package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* loaded from: classes2.dex */
public class Y implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23101a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23102b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(C2202xa c2202xa, Slider slider) {
        this.f23102b = c2202xa;
        this.f23101a = slider;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f23102b.j = (int) (this.f23101a.getValue() * 1000.0f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
