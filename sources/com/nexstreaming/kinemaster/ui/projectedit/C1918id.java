package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.SystemClock;
import com.nexstreaming.kinemaster.ui.widget.ValueSpinner;

/* compiled from: OptionMenuAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.id, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1918id implements ValueSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    private long f22390a = 0;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22391b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1935kd f22392c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1918id(C1935kd c1935kd, OptionMenuItem optionMenuItem) {
        this.f22392c = c1935kd;
        this.f22391b = optionMenuItem;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.ValueSpinner.a
    public void a(float f2, float f3, boolean z) {
        InterfaceC1997rd interfaceC1997rd;
        interfaceC1997rd = this.f22392c.i;
        interfaceC1997rd.a(this.f22391b, f2, z);
        this.f22390a = SystemClock.uptimeMillis();
    }
}
