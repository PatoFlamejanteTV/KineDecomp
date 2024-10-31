package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ha, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2171ha implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Slider f23147a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2202xa f23148b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2171ha(C2202xa c2202xa, Slider slider) {
        this.f23148b = c2202xa;
        this.f23147a = slider;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f23148b.t = (int) this.f23147a.getValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }
}
