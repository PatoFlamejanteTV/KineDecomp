package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.kmpackage.au;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3699a;
    final /* synthetic */ List b;
    final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar, String str, List list) {
        this.c = fVar;
        this.f3699a = str;
        this.b = list;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        NexTimelineItem.j jVar;
        NexTimelineItem.j jVar2;
        VideoEditor o;
        jVar = this.c.r;
        String str = jVar.getEffectOptions().get(this.f3699a);
        jVar2 = this.c.r;
        jVar2.getEffectOptions().put(this.f3699a, ((au.a) this.b.get(i)).a());
        if (str != null && !str.equals(((au.a) this.b.get(i)).a())) {
            this.c.d();
            o = this.c.o();
            o.n();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
