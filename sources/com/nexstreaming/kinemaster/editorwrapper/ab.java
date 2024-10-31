package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ab implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bb f20294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(bb bbVar) {
        this.f20294a = bbVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        File file;
        Context Q;
        file = this.f20294a.f20298c.F;
        File a2 = c.d.b.m.l.a(com.nexstreaming.kinemaster.project.k.b(file.getName()));
        if (bitmap.getWidth() <= 1 || bitmap.getHeight() <= 1) {
            this.f20294a.f20297b.sendFailure(Task.makeTaskError("No available capture filenames"));
            return;
        }
        if (a2 == null) {
            this.f20294a.f20297b.sendFailure(Task.makeTaskError("No available capture filenames"));
            return;
        }
        if (a2.getParentFile().getFreeSpace() < bitmap.getByteCount()) {
            this.f20294a.f20297b.sendFailure(NexEditor.b.ob);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
            fileOutputStream.close();
            if (a2.length() >= 1) {
                Q = this.f20294a.f20298c.Q();
                MediaScannerConnection.scanFile(Q, new String[]{a2.getAbsolutePath()}, null, new _a(this, a2));
            } else {
                this.f20294a.f20297b.sendFailure(NexEditor.b.ob);
            }
        } catch (IOException e2) {
            if (e2.getMessage().contains("ENOSPC")) {
                this.f20294a.f20297b.sendFailure(NexEditor.b.ob);
            } else {
                this.f20294a.f20297b.sendFailure(NexEditor.b.pb);
            }
        }
    }
}
