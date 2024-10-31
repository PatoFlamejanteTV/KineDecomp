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
abstract class Q extends AsyncTask<Integer, Integer, Task.TaskError> {

    /* renamed from: a */
    private File f20712a;

    /* renamed from: b */
    private File f20713b;

    /* renamed from: c */
    private File f20714c;

    /* renamed from: d */
    private File f20715d;

    /* renamed from: e */
    private long f20716e;

    /* renamed from: f */
    private Bitmap f20717f;

    /* renamed from: g */
    private Bitmap f20718g;

    /* renamed from: h */
    private Bitmap f20719h;
    private int[] i;

    public Q(File file, File file2, File file3, File file4) {
        this.f20712a = file2;
        this.f20715d = file;
        this.f20713b = file3;
        this.f20714c = file4;
    }

    protected abstract void a();

    protected abstract void a(Task.TaskError taskError);

    private Task.TaskError b() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f20715d));
        try {
            return a(bufferedInputStream);
        } finally {
            bufferedInputStream.close();
        }
    }

    private void c() throws IOException {
        a(null, this.f20718g, this.f20713b);
        Bitmap bitmap = this.f20719h;
        if (bitmap == null) {
            bitmap = this.f20718g;
        }
        a(null, bitmap, this.f20714c);
        a(this.i, this.f20717f, this.f20712a);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Task.TaskError doInBackground(Integer... numArr) {
        if (!this.f20715d.exists()) {
            return ThumbnailError.RawFileNotFound;
        }
        this.f20716e = this.f20715d.length();
        if (this.f20716e < 8) {
            return ThumbnailError.RawFileTooSmall;
        }
        try {
            Task.TaskError b2 = b();
            if (b2 != null) {
                return b2;
            }
            c();
            return null;
        } catch (IOException e2) {
            return Task.makeTaskError(e2);
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public final void onPostExecute(Task.TaskError taskError) {
        if (taskError == null) {
            a();
        } else {
            a(taskError);
        }
    }

    private Task.TaskError a(InputStream inputStream) throws IOException {
        return S.a(inputStream, this.f20716e, 50, new P(this));
    }

    private void a(int[] iArr, Bitmap bitmap, File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        if (iArr != null) {
            try {
                dataOutputStream.writeInt(bitmap.getWidth() / iArr.length);
                dataOutputStream.writeInt(bitmap.getHeight());
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
