package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.kmpackage.au;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3698a;
    final /* synthetic */ au b;
    final /* synthetic */ int[] c;
    final /* synthetic */ List d;
    final /* synthetic */ ImageButton e;
    final /* synthetic */ f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar, String str, au auVar, int[] iArr, List list, ImageButton imageButton) {
        this.f = fVar;
        this.f3698a = str;
        this.b = auVar;
        this.c = iArr;
        this.d = list;
        this.e = imageButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.j jVar;
        int d;
        NexTimelineItem.j jVar2;
        VideoEditor o;
        jVar = this.f.r;
        String str = jVar.getEffectOptions().get(this.f3698a);
        String c = str == null ? this.b.c() : str;
        this.c[0] = (this.c[0] + 1) % this.d.size();
        ImageButton imageButton = this.e;
        d = this.f.d(((au.a) this.d.get(this.c[0])).b());
        imageButton.setImageResource(d);
        jVar2 = this.f.r;
        jVar2.getEffectOptions().put(this.f3698a, ((au.a) this.d.get(this.c[0])).a());
        if (c != null && !c.equals(((au.a) this.d.get(this.c[0])).a())) {
            this.f.d();
            o = this.f.o();
            o.n();
        }
    }
}
