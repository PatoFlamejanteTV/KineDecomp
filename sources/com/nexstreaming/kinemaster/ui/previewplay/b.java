package com.nexstreaming.kinemaster.ui.previewplay;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class b implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PreviewPlayActivity previewPlayActivity) {
        this.f3721a = previewPlayActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        int i;
        if (!this.f3721a.b().f().a().checkReadyToPlay()) {
            new a.C0074a(this.f3721a).a(R.string.play_fail_notready).a(false).a(R.string.button_ok, new c(this)).a().show();
            return;
        }
        VideoEditor b = this.f3721a.b();
        i = this.f3721a.e;
        b.a(i).onComplete(new d(this));
    }
}
