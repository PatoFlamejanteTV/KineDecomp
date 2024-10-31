package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class y extends AsyncTask<File, Integer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3518a;
    final /* synthetic */ MediaInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MediaInfo mediaInfo, ResultTask resultTask) {
        this.b = mediaInfo;
        this.f3518a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(File... fileArr) {
        return BitmapFactory.decodeFile(fileArr[0].getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        this.f3518a.setResult(bitmap);
        this.f3518a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
