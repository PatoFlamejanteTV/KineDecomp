package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.GridView;
import com.nextreaming.nexeditorui.C2300c;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* compiled from: OptionColorTintFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1934kc implements C2300c.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1943lc f22413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1934kc(C1943lc c1943lc) {
        this.f22413a = c1943lc;
    }

    @Override // com.nextreaming.nexeditorui.C2300c.a
    public void a(int i) {
        NexTimelineItem.h hVar;
        List list;
        NexTimelineItem.h hVar2;
        C2300c c2300c;
        C2300c c2300c2;
        GridView gridView;
        hVar = this.f22413a.l;
        if (hVar != null) {
            list = this.f22413a.n;
            ColorEffect colorEffect = (ColorEffect) list.get(i);
            hVar2 = this.f22413a.l;
            hVar2.setColorEffect(colorEffect);
            c2300c = this.f22413a.o;
            c2300c.a(i);
            c2300c2 = this.f22413a.o;
            c2300c2.notifyDataSetChanged();
            gridView = this.f22413a.p;
            gridView.post(new RunnableC1925jc(this, colorEffect));
        }
    }
}
