package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.mr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
public class mj implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ VideoEditor f4091a;
    final /* synthetic */ mr.a b;
    final /* synthetic */ mh c;

    public mj(mh mhVar, VideoEditor videoEditor, mr.a aVar) {
        this.c = mhVar;
        this.f4091a = videoEditor;
        this.b = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.c.f4089a.isAdded()) {
            this.f4091a.s().onComplete(new ml(this)).onFailure(new mk(this));
        }
    }
}
