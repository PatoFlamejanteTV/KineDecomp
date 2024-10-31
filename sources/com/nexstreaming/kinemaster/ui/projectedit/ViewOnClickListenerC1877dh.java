package com.nexstreaming.kinemaster.ui.projectedit;

import android.text.Layout;
import android.view.View;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextAlignOptionMenuItem.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.dh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1877dh implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22316a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f22317b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1935kd.a f22318c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22319d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C1895fh f22320e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1877dh(C1895fh c1895fh, View view, View view2, C1935kd.a aVar, OptionMenuItem optionMenuItem) {
        this.f22320e = c1895fh;
        this.f22316a = view;
        this.f22317b = view2;
        this.f22318c = aVar;
        this.f22319d = optionMenuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextLayer textLayer;
        TextLayer textLayer2;
        textLayer = this.f22320e.f22338a;
        if (textLayer == null || view.isSelected()) {
            return;
        }
        textLayer2 = this.f22320e.f22338a;
        textLayer2.setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
        view.setSelected(true);
        this.f22316a.setSelected(false);
        this.f22317b.setSelected(false);
        view.postDelayed(new RunnableC1868ch(this), 200L);
    }
}
