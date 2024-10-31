package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AssetSettingsManager.java */
/* loaded from: classes2.dex */
class A implements PopoutListMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.app.general.nexasset.assetpackage.s f21734a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f21735b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f21736c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ B f21737d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(B b2, com.nexstreaming.app.general.nexasset.assetpackage.s sVar, View view, OptionMenuItem optionMenuItem) {
        this.f21737d = b2;
        this.f21734a = sVar;
        this.f21735b = view;
        this.f21736c = optionMenuItem;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutListMenu.b
    public void a(PopoutListMenu popoutListMenu, int i) {
        Context context;
        NexTimelineItem.l lVar;
        context = this.f21737d.f21773a.f21807a;
        String a2 = com.nexstreaming.app.general.util.J.a(context, this.f21734a.a().get(i).b().get("label"));
        View view = this.f21735b;
        if (view != null) {
            ((TextView) view.findViewById(R.id.buttonLabel)).setText(a2);
        }
        this.f21736c.a(a2);
        lVar = this.f21737d.f21773a.f21808b;
        lVar.getEffectOptions().put(this.f21734a.getId(), this.f21734a.a().get(i).getValue());
        this.f21737d.f21773a.a(true);
    }
}
