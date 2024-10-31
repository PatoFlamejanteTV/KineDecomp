package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class cq implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3824a;
    final /* synthetic */ ce b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(ce ceVar, VideoEditor videoEditor) {
        this.b = ceVar;
        this.f3824a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f = false;
        this.b.g = false;
        this.f3824a.b(false);
        this.b.a(true);
        this.b.h();
        Log.d("AudioEffectFragment", "TESTTEST :: onPause :: " + this.f3824a.u());
    }
}
