package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

/* compiled from: MyAssetFragment.java */
/* loaded from: classes2.dex */
class db implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f23544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(eb ebVar) {
        this.f23544a = ebVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        ListView listView;
        GridView gridView;
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i == 61) {
            listView = this.f23544a.f23548b;
            listView.requestFocus();
            return true;
        }
        if (i != 66) {
            return false;
        }
        eb ebVar = this.f23544a;
        gridView = ebVar.f23549c;
        ebVar.n(gridView.getSelectedItemPosition());
        return true;
    }
}
