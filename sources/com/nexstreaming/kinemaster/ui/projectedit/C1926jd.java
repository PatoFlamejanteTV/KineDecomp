package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;

/* compiled from: OptionMenuAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.jd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1926jd implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22404a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1935kd f22405b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1926jd(C1935kd c1935kd, OptionMenuItem optionMenuItem) {
        this.f22405b = c1935kd;
        this.f22404a = optionMenuItem;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C1935kd.a aVar;
        C1935kd.a aVar2;
        InterfaceC1997rd interfaceC1997rd;
        InterfaceC1997rd interfaceC1997rd2;
        if (this.f22404a.v) {
            interfaceC1997rd = this.f22405b.i;
            if (interfaceC1997rd != null) {
                interfaceC1997rd2 = this.f22405b.i;
                interfaceC1997rd2.a(this.f22404a, z);
                return;
            }
        }
        aVar = this.f22405b.j;
        if (aVar != null) {
            aVar2 = this.f22405b.j;
            aVar2.a(this.f22404a.f21997c, z);
        }
    }
}
