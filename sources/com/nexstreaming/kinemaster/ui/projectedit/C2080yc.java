package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.yc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2080yc implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22789a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22790b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2080yc(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.f22790b = optionCroppingFragment;
        this.f22789a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f22789a.b(false);
    }
}
