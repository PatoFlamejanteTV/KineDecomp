package com.nexstreaming.kinemaster.ui.a;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class c implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ e f21307a;

    public c(e eVar) {
        this.f21307a = eVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof e.b)) {
            return false;
        }
        e.b bVar = (e.b) tag;
        DialogInterface.OnClickListener onClickListener = bVar.f21331c;
        if (onClickListener instanceof e.c) {
            return ((e.c) onClickListener).a(this.f21307a, bVar.f21329a);
        }
        return false;
    }
}
