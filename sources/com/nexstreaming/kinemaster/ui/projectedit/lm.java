package com.nexstreaming.kinemaster.ui.projectedit;

import android.text.Layout;
import android.view.View;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.ep;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextAlignOptionMenuItem.java */
/* loaded from: classes.dex */
public class lm implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4067a;
    final /* synthetic */ View b;
    final /* synthetic */ ep.a c;
    final /* synthetic */ OptionMenuItem d;
    final /* synthetic */ lh e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lm(lh lhVar, View view, View view2, ep.a aVar, OptionMenuItem optionMenuItem) {
        this.e = lhVar;
        this.f4067a = view;
        this.b = view2;
        this.c = aVar;
        this.d = optionMenuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextLayer textLayer;
        TextLayer textLayer2;
        textLayer = this.e.f4061a;
        if (textLayer != null && !view.isSelected()) {
            textLayer2 = this.e.f4061a;
            textLayer2.setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
            view.setSelected(true);
            this.f4067a.setSelected(false);
            this.b.setSelected(false);
            view.postDelayed(new ln(this), 200L);
        }
    }
}