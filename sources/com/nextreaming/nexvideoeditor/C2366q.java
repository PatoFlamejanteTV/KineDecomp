package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import android.view.SurfaceView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2366q implements ResultTask.OnResultAvailableListener<Rect> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurfaceView f24732a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f24733b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexEditor f24734c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2366q(NexEditor nexEditor, SurfaceView surfaceView, ResultTask resultTask) {
        this.f24734c = nexEditor;
        this.f24732a = surfaceView;
        this.f24733b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Rect> resultTask, Task.Event event, Rect rect) {
        ResultTask x;
        NexEditorDeviceProfile.c captureSize = NexEditorDeviceProfile.getDeviceProfile().getCaptureSize();
        int i = captureSize.f24096a;
        int i2 = captureSize.f24097b;
        if (EditorGlobal.l() == 1.0f) {
            i = i2;
        } else if (EditorGlobal.l() == 0.5625f) {
            i = captureSize.f24097b;
            i2 = captureSize.f24096a;
        }
        this.f24732a.getHolder().setFixedSize(i, i2);
        x = this.f24734c.x();
        x.setTimeout(500L).onResultAvailable(new C2365p(this)).onFailure((Task.OnFailListener) new C2361l(this));
    }
}
