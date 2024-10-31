package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
public class cm implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3820a;
    final /* synthetic */ ce b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ce ceVar, VideoEditor videoEditor) {
        this.b = ceVar;
        this.f3820a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        boolean z2;
        if (this.b.isAdded()) {
            z = this.b.f;
            if (z) {
                z2 = this.b.g;
                if (z2) {
                    this.f3820a.r().onComplete(new co(this)).onFailure(new cn(this));
                }
            }
        }
    }
}
