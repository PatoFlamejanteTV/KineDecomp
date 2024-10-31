package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.GridView;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.b;
import java.util.List;

/* compiled from: OptionColorTintFragment.java */
/* loaded from: classes.dex */
class de implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dc f3839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dc dcVar) {
        this.f3839a = dcVar;
    }

    @Override // com.nextreaming.nexeditorui.b.a
    public void a(int i) {
        NexTimelineItem.g gVar;
        List list;
        NexTimelineItem.g gVar2;
        com.nextreaming.nexeditorui.b bVar;
        com.nextreaming.nexeditorui.b bVar2;
        GridView gridView;
        gVar = this.f3839a.f3837a;
        if (gVar != null) {
            list = this.f3839a.c;
            ColorEffect colorEffect = (ColorEffect) list.get(i);
            gVar2 = this.f3839a.f3837a;
            gVar2.setColorEffect(colorEffect);
            bVar = this.f3839a.d;
            bVar.a(i);
            bVar2 = this.f3839a.d;
            bVar2.notifyDataSetChanged();
            gridView = this.f3839a.e;
            gridView.post(new df(this, colorEffect));
        }
    }
}
