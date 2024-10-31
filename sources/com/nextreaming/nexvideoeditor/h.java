package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.ResultTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class h implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f4832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NexEditor nexEditor) {
        this.f4832a = nexEditor;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ResultTask resultTask;
        ResultTask resultTask2;
        resultTask = this.f4832a.aa;
        if (resultTask != null) {
            resultTask2 = this.f4832a.aa;
            resultTask2.sendResult(new Rect(0, 0, i2, i3));
            this.f4832a.aa = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
