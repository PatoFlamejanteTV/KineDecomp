package com.nexstreaming.kinemaster.d;

import android.content.DialogInterface;
import android.view.View;
import com.nextreaming.nexeditorui.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PurchaseDialog.java */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3294a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af b;
        af b2;
        b = this.f3294a.b();
        if (b != null) {
            b2 = this.f3294a.b();
            b2.a((DialogInterface.OnClickListener) null);
        }
    }
}
