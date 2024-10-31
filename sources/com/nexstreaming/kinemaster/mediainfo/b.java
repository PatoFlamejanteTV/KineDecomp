package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class B extends AsyncTask<File, Integer, MediaInfo.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f20650a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20651b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(MediaInfo mediaInfo, ResultTask resultTask) {
        this.f20651b = mediaInfo;
        this.f20650a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MediaInfo.a doInBackground(File... fileArr) {
        try {
            return a(fileArr[0]);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private MediaInfo.a a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int readInt = dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        int readInt3 = dataInputStream.readInt();
        int[] iArr = new int[readInt3];
        for (int i = 0; i < readInt3; i++) {
            iArr[i] = dataInputStream.readInt();
        }
        return new MediaInfo.a(readInt, readInt2, iArr, BitmapFactory.decodeStream(dataInputStream));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(MediaInfo.a aVar) {
        this.f20650a.setResult(aVar);
        this.f20650a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
