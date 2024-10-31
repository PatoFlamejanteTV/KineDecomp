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
public class A extends AsyncTask<File, Integer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f20648a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20649b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(MediaInfo mediaInfo, ResultTask resultTask) {
        this.f20649b = mediaInfo;
        this.f20648a = resultTask;
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
        this.f20648a.setResult(bitmap);
        this.f20648a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
