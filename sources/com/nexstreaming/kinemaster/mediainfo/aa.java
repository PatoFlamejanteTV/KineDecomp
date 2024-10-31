package com.nexstreaming.kinemaster.mediainfo;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class aa extends AsyncTask<MediaInfo, Integer, aj> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3489a;
    final /* synthetic */ MediaInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MediaInfo mediaInfo, ResultTask resultTask) {
        this.b = mediaInfo;
        this.f3489a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public aj doInBackground(MediaInfo... mediaInfoArr) {
        File file;
        File file2;
        File file3;
        MediaInfo mediaInfo = mediaInfoArr[0];
        file = mediaInfo.j;
        if (file.exists()) {
            file2 = mediaInfo.j;
            int min = (int) Math.min(file2.length(), 204800L);
            try {
                byte[] bArr = new byte[min];
                file3 = this.b.j;
                FileInputStream fileInputStream = new FileInputStream(file3);
                try {
                    if (fileInputStream.read(bArr) >= min) {
                        return new aj(bArr);
                    }
                } finally {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(aj ajVar) {
        this.f3489a.setResult(ajVar);
        this.f3489a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
