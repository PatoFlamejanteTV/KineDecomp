package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbnailConversionTask.java */
/* loaded from: classes.dex */
abstract class an extends AsyncTask<Integer, Integer, Task.TaskError> {

    /* renamed from: a, reason: collision with root package name */
    private File f3496a;
    private File b;
    private File c;
    private File d;
    private long e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private int[] i;

    protected abstract void a();

    protected abstract void a(Task.TaskError taskError);

    public an(File file, File file2, File file3, File file4) {
        this.f3496a = file2;
        this.d = file;
        this.b = file3;
        this.c = file4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Task.TaskError doInBackground(Integer... numArr) {
        if (!this.d.exists()) {
            return ThumbnailError.RawFileNotFound;
        }
        this.e = this.d.length();
        if (this.e < 8) {
            return ThumbnailError.RawFileTooSmall;
        }
        try {
            Task.TaskError b = b();
            if (b == null) {
                c();
                return null;
            }
            return b;
        } catch (IOException e) {
            return Task.makeTaskError(e);
        }
    }

    private Task.TaskError a(InputStream inputStream) throws IOException {
        return ap.a(inputStream, this.e, 50, new ao(this));
    }

    private Task.TaskError b() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.d));
        try {
            return a(bufferedInputStream);
        } finally {
            bufferedInputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void onPostExecute(Task.TaskError taskError) {
        if (taskError == null) {
            a();
        } else {
            a(taskError);
        }
    }

    private void c() throws IOException {
        a(null, this.g, this.b);
        a(null, this.h == null ? this.g : this.h, this.c);
        a(this.i, this.f, this.f3496a);
    }

    private void a(int[] iArr, Bitmap bitmap, File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        if (iArr != null) {
            try {
                dataOutputStream.writeInt(160);
                dataOutputStream.writeInt(90);
                dataOutputStream.writeInt(iArr.length);
                for (int i : iArr) {
                    dataOutputStream.writeInt(i);
                }
            } finally {
                dataOutputStream.close();
                file.setReadable(true);
            }
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, dataOutputStream);
    }
}
