package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.ListView;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionMenuItemClickHandler.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ud, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2047ud implements ColorPickerPopup.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionMenuItem f22727a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2073xd f22728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2047ud(C2073xd c2073xd, OptionMenuItem optionMenuItem) {
        this.f22728b = c2073xd;
        this.f22727a = optionMenuItem;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerPopup.b
    public void a(int i, boolean z) {
        ListView listView;
        ListView listView2;
        C1935kd c1935kd;
        C1935kd.a aVar;
        Bg bg;
        Bg bg2;
        Bg bg3;
        listView = this.f22728b.f22767a;
        if (listView != null) {
            if (!z) {
                bg = this.f22728b.f22769c;
                com.nexstreaming.kinemaster.editorwrapper.Fa ca = bg.ca();
                if (ca instanceof Fa.a) {
                    ((Fa.a) ca).setColorOption(this.f22727a.f21997c, i);
                    bg2 = this.f22728b.f22769c;
                    bg2.na();
                    bg3 = this.f22728b.f22769c;
                    bg3.G();
                }
            }
            listView2 = this.f22728b.f22767a;
            listView2.clearChoices();
            c1935kd = this.f22728b.f22768b;
            c1935kd.notifyDataSetChanged();
            aVar = this.f22728b.f22770d;
            aVar.a(this.f22727a.f21997c);
        }
    }
}
