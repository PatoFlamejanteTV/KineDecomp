package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.CompoundButton;
import com.nexstreaming.kinemaster.ui.projectedit.ep;

/* compiled from: OptionMenuAdapter.java */
/* loaded from: classes.dex */
class er implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f3880a;
    final /* synthetic */ ep b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(ep epVar, OptionMenuItem optionMenuItem) {
        this.b = epVar;
        this.f3880a = optionMenuItem;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ep.a aVar;
        ep.a aVar2;
        aVar = this.b.h;
        if (aVar != null) {
            aVar2 = this.b.h;
            aVar2.a(this.f3880a.id, z);
        }
    }
}
