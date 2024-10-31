package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2072xc implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22765a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22766b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2072xc(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.f22766b = optionCroppingFragment;
        this.f22765a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Rect rect;
        Rect rect2;
        this.f22766b.P = false;
        this.f22765a.b(false);
        NexVideoClipItem sa = this.f22766b.sa();
        rect = this.f22766b.G;
        sa.getStartPositionRaw(rect);
        NexEditor.c n = this.f22765a.n();
        n.a(NexEditor.FastPreviewOption.nofx, 1);
        rect2 = this.f22766b.G;
        n.a(rect2);
        n.execute();
    }
}
