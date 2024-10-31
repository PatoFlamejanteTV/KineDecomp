package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.ep;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuAdapter.java */
/* loaded from: classes.dex */
public class eq implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ep f3879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(ep epVar) {
        this.f3879a = epVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ep.a aVar;
        ep.a aVar2;
        Object tag = view.getTag();
        if (tag instanceof OptionMenuItem) {
            aVar = this.f3879a.h;
            if (aVar != null) {
                aVar2 = this.f3879a.h;
                aVar2.a((OptionMenuItem) tag);
            }
        }
    }
}
