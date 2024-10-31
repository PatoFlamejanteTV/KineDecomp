package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IconMenuPopout.java */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f4387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4387a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.InterfaceC0078b interfaceC0078b;
        b.InterfaceC0078b interfaceC0078b2;
        interfaceC0078b = this.f4387a.e;
        if (interfaceC0078b != null) {
            interfaceC0078b2 = this.f4387a.e;
            interfaceC0078b2.a(this.f4387a, ((Integer) view.getTag(R.id.icon_idtag)).intValue());
            this.f4387a.b.dismiss();
        }
    }
}
