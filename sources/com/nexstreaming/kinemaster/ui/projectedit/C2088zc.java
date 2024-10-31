package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.zc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2088zc implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22803a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22804b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2088zc(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.f22804b = optionCroppingFragment;
        this.f22803a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Rect rect;
        Rect rect2;
        this.f22804b.P = false;
        this.f22803a.b(false);
        NexVideoClipItem sa = this.f22804b.sa();
        rect = this.f22804b.G;
        sa.getEndPositionRaw(rect);
        NexEditor.c n = this.f22803a.n();
        n.a(NexEditor.FastPreviewOption.nofx, 1);
        rect2 = this.f22804b.G;
        n.a(rect2);
        n.execute();
    }
}
