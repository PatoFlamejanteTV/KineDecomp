package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.general.iab.SKUDetails;

/* compiled from: AccountInfoFragment.java */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SKUDetails f4256a;
    final /* synthetic */ a b;

    public g(a aVar, SKUDetails sKUDetails) {
        this.b = aVar;
        this.f4256a = sKUDetails;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4256a != null) {
            this.b.a(this.f4256a);
        } else if (this.b.b != null) {
            this.b.b.a((DialogInterface.OnClickListener) null);
        }
    }
}
