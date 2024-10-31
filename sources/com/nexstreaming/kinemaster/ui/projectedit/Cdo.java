package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.do, reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3849a;
    final /* synthetic */ OptionCroppingFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.b = optionCroppingFragment;
        this.f3849a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Rect rect;
        Rect rect2;
        this.b.E = false;
        this.f3849a.b(false);
        NexVideoClipItem a2 = this.b.a();
        rect = this.b.v;
        a2.getStartPositionRaw(rect);
        NexEditor.c a3 = this.f3849a.z().a(NexEditor.FastPreviewOption.nofx, 1);
        rect2 = this.b.v;
        a3.a(rect2).a();
    }
}
