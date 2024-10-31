package com.nexstreaming.kinemaster.mediainfo;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class AsyncTaskC1793k extends AsyncTask<File, Integer, int[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC1793k(MediaInfo mediaInfo) {
        this.f20745a = mediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int[] doInBackground(File... fileArr) {
        NexEditor da;
        File file;
        File file2;
        try {
            file2 = this.f20745a.v;
            return a(file2);
        } catch (IOException unused) {
            da = MediaInfo.da();
            if (da == null) {
                return null;
            }
            NexClipInfo nexClipInfo = new NexClipInfo();
            if (da.a(fileArr[0].getAbsolutePath(), nexClipInfo, true, 0).c() || nexClipInfo.mSeekTable == null) {
                return null;
            }
            try {
                file = this.f20745a.v;
                a(file, nexClipInfo.mSeekTable);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return nexClipInfo.mSeekTable;
        }
    }

    private int[] a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            int min = ((int) Math.min(file.length(), 204800L)) / 4;
            int[] iArr = new int[min];
            for (int i = 0; i < min; i++) {
                iArr[i] = dataInputStream.readInt();
            }
            return iArr;
        } finally {
            dataInputStream.close();
        }
    }

    private void a(File file, int[] iArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        int i = 0;
        while (true) {
            try {
                if (i >= iArr.length) {
                    return;
                }
                dataOutputStream.writeInt(iArr[i]);
                i++;
            } finally {
                dataOutputStream.close();
                file.setReadable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(int[] iArr) {
        ResultTask resultTask;
        ResultTask resultTask2;
        ResultTask resultTask3;
        if (iArr == null) {
            resultTask3 = this.f20745a.I;
            resultTask3.signalEvent(Task.Event.FAIL);
        } else {
            resultTask = this.f20745a.I;
            resultTask.setResult(iArr);
            resultTask2 = this.f20745a.I;
            resultTask2.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
        }
    }
}
