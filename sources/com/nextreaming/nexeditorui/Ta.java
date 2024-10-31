package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class Ta extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f24173a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24174b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f24175c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24176d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(NexVideoClipItem nexVideoClipItem, File file, int i, ResultTask resultTask) {
        this.f24176d = nexVideoClipItem;
        this.f24173a = file;
        this.f24174b = i;
        this.f24175c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        int i;
        boolean z;
        boolean z2;
        String absolutePath = this.f24173a.getAbsolutePath();
        int i2 = this.f24174b;
        Bitmap a2 = NexImageLoader.loadBitmap(absolutePath, (i2 * 16) / 9, i2).a();
        if (a2 == null) {
            return a2;
        }
        i = this.f24176d.m_rotation;
        z = this.f24176d.m_fliph;
        z2 = this.f24176d.m_flipv;
        return NexImageLoader.rotateAndFlipImage(a2, (360 - i) % 360, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap == null) {
            this.f24175c.sendFailure(null);
        } else {
            this.f24175c.sendResult(bitmap);
        }
    }
}
