package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioMenuListFragment.java */
/* loaded from: classes2.dex */
public class U implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22136a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ X f22137b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public U(X x, VideoEditor videoEditor) {
        this.f22137b = x;
        this.f22136a = videoEditor;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.f22137b.isAdded()) {
            this.f22136a.D().onComplete(new T(this)).onFailure(new S(this));
        }
    }
}
