package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuItemClickHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.td, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2015td implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22538a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2073xd f22539b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2015td(C2073xd c2073xd, OptionMenuItem optionMenuItem) {
        this.f22539b = c2073xd;
        this.f22538a = optionMenuItem;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        ListView listView;
        ListView listView2;
        C1935kd c1935kd;
        C1935kd.a aVar;
        Bg bg;
        Bg bg2;
        InterfaceC1997rd interfaceC1997rd;
        InterfaceC1997rd interfaceC1997rd2;
        listView = this.f22539b.f22767a;
        if (listView != null) {
            if (!z) {
                if (this.f22538a.v) {
                    interfaceC1997rd = this.f22539b.f22771e;
                    if (interfaceC1997rd != null) {
                        interfaceC1997rd2 = this.f22539b.f22771e;
                        interfaceC1997rd2.a(this.f22538a, i);
                    }
                } else {
                    bg = this.f22539b.f22769c;
                    com.nexstreaming.kinemaster.editorwrapper.Fa ca = bg.ca();
                    if (ca instanceof Fa.a) {
                        ((Fa.a) ca).setColorOption(this.f22538a.f21997c, i);
                        bg2 = this.f22539b.f22769c;
                        bg2.G();
                    }
                }
            }
            listView2 = this.f22539b.f22767a;
            listView2.clearChoices();
            c1935kd = this.f22539b.f22768b;
            c1935kd.notifyDataSetChanged();
            aVar = this.f22539b.f22770d;
            aVar.a(this.f22538a.f21997c);
        }
    }
}
