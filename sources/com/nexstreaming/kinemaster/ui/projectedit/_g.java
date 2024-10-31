package com.nexstreaming.kinemaster.ui.projectedit;

import android.text.Layout;
import android.view.View;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextAlignOptionMenuItem.java */
/* loaded from: classes2.dex */
public class _g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22206a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f22207b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1935kd.a f22208c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22209d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C1895fh f22210e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _g(C1895fh c1895fh, View view, View view2, C1935kd.a aVar, OptionMenuItem optionMenuItem) {
        this.f22210e = c1895fh;
        this.f22206a = view;
        this.f22207b = view2;
        this.f22208c = aVar;
        this.f22209d = optionMenuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextLayer textLayer;
        TextLayer textLayer2;
        textLayer = this.f22210e.f22338a;
        if (textLayer == null || view.isSelected()) {
            return;
        }
        textLayer2 = this.f22210e.f22338a;
        textLayer2.setTextAlign(Layout.Alignment.ALIGN_NORMAL);
        view.setSelected(true);
        this.f22206a.setSelected(false);
        this.f22207b.setSelected(false);
        view.postDelayed(new Zg(this), 200L);
    }
}
