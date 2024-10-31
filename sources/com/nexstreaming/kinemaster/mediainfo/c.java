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
public class C extends AsyncTask<MediaInfo, Integer, L> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f20652a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20653b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(MediaInfo mediaInfo, ResultTask resultTask) {
        this.f20653b = mediaInfo;
        this.f20652a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public L doInBackground(MediaInfo... mediaInfoArr) {
        File file;
        File file2;
        File file3;
        MediaInfo mediaInfo = mediaInfoArr[0];
        file = mediaInfo.A;
        if (!file.exists()) {
            return null;
        }
        file2 = mediaInfo.A;
        int min = (int) Math.min(file2.length(), 204800L);
        try {
            byte[] bArr = new byte[min];
            file3 = this.f20653b.A;
            FileInputStream fileInputStream = new FileInputStream(file3);
            try {
                if (fileInputStream.read(bArr) >= min) {
                    return new L(bArr);
                }
                return null;
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(L l) {
        this.f20652a.setResult(l);
        this.f20652a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
