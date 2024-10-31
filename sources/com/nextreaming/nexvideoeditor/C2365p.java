package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2365p implements ResultTask.OnResultAvailableListener<Rect> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2366q f24731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2365p(C2366q c2366q) {
        this.f24731a = c2366q;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Rect> resultTask, Task.Event event, Rect rect) {
        Task w;
        w = this.f24731a.f24734c.w();
        w.setTimeout(500L).onComplete(new C2364o(this)).onFailure(new C2362m(this));
        this.f24731a.f24734c.a(NexEditor.FastPreviewOption.nofx, 1, false);
    }
}
