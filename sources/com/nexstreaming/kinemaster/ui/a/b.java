package com.nexstreaming.kinemaster.ui.a;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ e f21306a;

    public b(e eVar) {
        this.f21306a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar;
        DialogInterface.OnClickListener onClickListener;
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof e.b) || (onClickListener = (bVar = (e.b) tag).f21331c) == null) {
            return;
        }
        onClickListener.onClick(this.f21306a, bVar.f21329a);
    }
}
