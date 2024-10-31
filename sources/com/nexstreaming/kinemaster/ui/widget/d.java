package com.nexstreaming.kinemaster.ui.widget;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.e;

/* compiled from: IconMenuPopout.java */
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ e f23857a;

    public d(e eVar) {
        this.f23857a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar;
        e.b bVar2;
        bVar = this.f23857a.f23860h;
        if (bVar != null) {
            bVar2 = this.f23857a.f23860h;
            bVar2.a(this.f23857a, ((Integer) view.getTag(R.id.icon_idtag)).intValue());
            this.f23857a.f23878b.dismiss();
        }
    }
}
