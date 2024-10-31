package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* compiled from: OptionMenuAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1909hd implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f22363a = false;

    /* renamed from: b, reason: collision with root package name */
    float f22364b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22365c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C1935kd f22366d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1909hd(C1935kd c1935kd, OptionMenuItem optionMenuItem) {
        this.f22366d = c1935kd;
        this.f22365c = optionMenuItem;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        InterfaceC1997rd interfaceC1997rd;
        this.f22364b = f2;
        interfaceC1997rd = this.f22366d.i;
        interfaceC1997rd.a(this.f22365c, this.f22364b, false);
        this.f22363a = true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22363a = false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        InterfaceC1997rd interfaceC1997rd;
        if (this.f22363a) {
            this.f22363a = false;
            interfaceC1997rd = this.f22366d.i;
            interfaceC1997rd.a(this.f22365c, this.f22364b, true);
        }
    }
}
