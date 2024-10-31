package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.kinemaster.ui.share.qa;

/* compiled from: ShareEventFragment.java */
/* loaded from: classes2.dex */
public class pa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ qa f23374a;

    public pa(qa qaVar) {
        this.f23374a = qaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        qa.a aVar;
        qa.a aVar2;
        aVar = this.f23374a.f23379d;
        if (aVar != null) {
            aVar2 = this.f23374a.f23379d;
            aVar2.q();
        }
    }
}
