package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuAdapter.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.gd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1900gd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1935kd f22349a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1900gd(C1935kd c1935kd) {
        this.f22349a = c1935kd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1935kd.a aVar;
        C1935kd.a aVar2;
        Object tag = view.getTag();
        if (tag instanceof OptionMenuItem) {
            aVar = this.f22349a.j;
            if (aVar != null) {
                aVar2 = this.f22349a.j;
                aVar2.a((OptionMenuItem) tag);
            }
        }
    }
}
