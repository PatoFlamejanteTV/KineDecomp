package com.nexstreaming.kinemaster.ui.b;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.ColorPickerView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class n implements ColorPickerView.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3701a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar, String str) {
        this.b = fVar;
        this.f3701a = str;
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerView.c
    public void a(ColorPickerView colorPickerView) {
        VideoEditor o;
        this.b.d();
        o = this.b.o();
        o.n();
    }

    @Override // com.nextreaming.nexeditorui.ColorPickerView.c
    public void a(ColorPickerView colorPickerView, int i) {
        NexTimelineItem.j jVar;
        jVar = this.b.r;
        jVar.getEffectOptions().put(this.f3701a, com.nexstreaming.app.general.util.c.a(i));
    }
}
