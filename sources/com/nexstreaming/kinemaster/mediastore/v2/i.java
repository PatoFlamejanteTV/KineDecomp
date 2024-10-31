package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.AsyncTask;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class i extends AsyncTask<MediaStoreItem, Long, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f3564a;
    final /* synthetic */ Task b;
    final /* synthetic */ MediaStoreItem c;
    final /* synthetic */ MediaStore d;
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaStore mediaStore, l lVar, Task task, MediaStoreItem mediaStoreItem) {
        this.d = mediaStore;
        this.f3564a = lVar;
        this.b = task;
        this.c = mediaStoreItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task.TaskError doInBackground(MediaStoreItem... mediaStoreItemArr) {
        MediaStoreItem mediaStoreItem = mediaStoreItemArr[0];
        Task task = new Task();
        task.makeWaitable();
        task.onProgress(new j(this));
        Log.i("MediaStore", "download task ID : " + task.getTaskId());
        this.f3564a.a(mediaStoreItem, task);
        task.awaitTaskCompletion();
        Log.i("MediaStore", "download complete");
        if (task.isRunning()) {
            return MediaStore.MediaStoreError.DownloadTaskNotSignaled;
        }
        if (task.didSignalEvent(Task.Event.CANCEL)) {
            return MediaStore.MediaStoreError.DownloadCancel;
        }
        if (task.didSignalEvent(Task.Event.FAIL)) {
            return task.getTaskError();
        }
        if (mediaStoreItem.n()) {
            return MediaStore.MediaStoreError.DownloadResultMissing;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Long... lArr) {
        long longValue = lArr[0].longValue();
        this.b.setProgress((int) (longValue >> 32), (int) longValue);
        this.d.i(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Task.TaskError taskError) {
        if (taskError == null) {
            this.b.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            this.d.i(this.c);
        } else if (taskError == MediaStore.MediaStoreError.DownloadCancel) {
            this.b.signalEvent(Task.Event.CANCEL);
            this.d.j(this.c);
        } else {
            this.b.sendFailure(taskError);
            this.d.a(this.c, taskError);
        }
    }
}
