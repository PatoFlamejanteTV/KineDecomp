package com.nexstreaming.kinemaster.ui.projectedit;

import android.text.Layout;
import android.view.View;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextAlignOptionMenuItem.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC1859bh implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22290a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f22291b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C1935kd.a f22292c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22293d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C1895fh f22294e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1859bh(C1895fh c1895fh, View view, View view2, C1935kd.a aVar, OptionMenuItem optionMenuItem) {
        this.f22294e = c1895fh;
        this.f22290a = view;
        this.f22291b = view2;
        this.f22292c = aVar;
        this.f22293d = optionMenuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextLayer textLayer;
        TextLayer textLayer2;
        textLayer = this.f22294e.f22338a;
        if (textLayer == null || view.isSelected()) {
            return;
        }
        textLayer2 = this.f22294e.f22338a;
        textLayer2.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        view.setSelected(true);
        this.f22290a.setSelected(false);
        this.f22291b.setSelected(false);
        view.postDelayed(new RunnableC1850ah(this), 200L);
    }
}
