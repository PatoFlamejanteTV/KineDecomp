package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.nexstreaming.kinemaster.layer.TextLayer;

/* compiled from: GroupEditFragment.java */
/* loaded from: classes2.dex */
class Ma implements InterfaceC1997rd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pa f21955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(Pa pa) {
        this.f21955a = pa;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public String a(OptionMenuItem optionMenuItem) {
        if (!(optionMenuItem.A instanceof TextLayer)) {
            return null;
        }
        Log.d("GroupEditFragment", "TESTTEST :: getTextFieldOption");
        return ((TextLayer) optionMenuItem.A).getText();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, float f2, boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, boolean z) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public boolean a(ListView listView, OptionMenuItem optionMenuItem, View view) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public float b(OptionMenuItem optionMenuItem) {
        return 0.0f;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public boolean c(OptionMenuItem optionMenuItem) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public int d(OptionMenuItem optionMenuItem) {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1997rd
    public void a(OptionMenuItem optionMenuItem, String str) {
        if (optionMenuItem.A instanceof TextLayer) {
            Log.d("GroupEditFragment", "TESTTEST :: onTextFieldOptionChanged - " + str);
            if (((TextLayer) optionMenuItem.A).getText().equals(str)) {
                return;
            }
            ((TextLayer) optionMenuItem.A).setText(str);
            this.f21955a.na();
            this.f21955a.G();
        }
    }
}
