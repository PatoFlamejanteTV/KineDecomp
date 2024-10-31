package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyAssetFragment.java */
/* loaded from: classes2.dex */
public class cb implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ eb f23539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(eb ebVar) {
        this.f23539a = ebVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        GridView gridView;
        if (keyEvent.getAction() != 0 || i != 61) {
            return false;
        }
        gridView = this.f23539a.f23549c;
        gridView.requestFocus();
        return true;
    }
}
