package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.wc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2064wc implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22751a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22752b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2064wc(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.f22752b = optionCroppingFragment;
        this.f22751a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f22751a.b(false);
    }
}
