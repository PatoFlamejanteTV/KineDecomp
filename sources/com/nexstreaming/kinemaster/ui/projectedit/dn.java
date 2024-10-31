package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
public class dn implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ VideoEditor f3848a;
    final /* synthetic */ OptionCroppingFragment b;

    public dn(OptionCroppingFragment optionCroppingFragment, VideoEditor videoEditor) {
        this.b = optionCroppingFragment;
        this.f3848a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3848a.b(false);
    }
}
