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
class bo implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ bm f3341a;

    public bo(bm bmVar) {
        this.f3341a = bmVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        File file;
        Context P;
        file = this.f3341a.c.E;
        File c = com.nexstreaming.kinemaster.h.c.c(com.nexstreaming.kinemaster.project.f.f(file.getName()));
        if (c == null) {
            this.f3341a.b.sendFailure(Task.makeTaskError("No available capture filenames"));
            return;
        }
        if (c.getParentFile().getFreeSpace() < bitmap.getByteCount()) {
            this.f3341a.b.sendFailure(NexEditor.b.bo);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(c);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
            fileOutputStream.close();
            if (c.length() >= 1) {
                P = this.f3341a.c.P();
                MediaScannerConnection.scanFile(P, new String[]{c.getAbsolutePath()}, null, new bp(this, c));
            } else {
                this.f3341a.b.sendFailure(NexEditor.b.bo);
            }
        } catch (IOException e) {
            if (e.getMessage().contains("ENOSPC")) {
                this.f3341a.b.sendFailure(NexEditor.b.bo);
            } else {
                this.f3341a.b.sendFailure(NexEditor.b.bp);
            }
        }
    }
}
