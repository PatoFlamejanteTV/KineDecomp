package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public class ei implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f3869a;
    final /* synthetic */ ed b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(ed edVar, OptionMenuItem optionMenuItem) {
        this.b = edVar;
        this.f3869a = optionMenuItem;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        ListView listView;
        ListView listView2;
        ep epVar;
        listView = this.b.f3864a;
        if (listView != null) {
            if (!z) {
                this.b.m().setColorOption(this.f3869a.id, i);
                this.b.d();
            }
            listView2 = this.b.f3864a;
            listView2.clearChoices();
            epVar = this.b.b;
            epVar.notifyDataSetChanged();
            this.b.c(this.b.j_());
        }
    }
}
