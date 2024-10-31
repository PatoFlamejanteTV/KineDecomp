package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import android.view.SurfaceHolder;
import com.nexstreaming.app.general.task.ResultTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class SurfaceHolderCallbackC2359j implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f24718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceHolderCallbackC2359j(NexEditor nexEditor) {
        this.f24718a = nexEditor;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ResultTask resultTask;
        ResultTask resultTask2;
        resultTask = this.f24718a.ia;
        if (resultTask != null) {
            resultTask2 = this.f24718a.ia;
            resultTask2.sendResult(new Rect(0, 0, i2, i3));
            this.f24718a.ia = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
