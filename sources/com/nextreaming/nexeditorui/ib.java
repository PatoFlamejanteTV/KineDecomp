package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class ib extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f24296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24297b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f24298c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24299d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(NexVideoClipItem nexVideoClipItem, File file, int i, ResultTask resultTask) {
        this.f24299d = nexVideoClipItem;
        this.f24296a = file;
        this.f24297b = i;
        this.f24298c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        int i;
        boolean z;
        boolean z2;
        String absolutePath = this.f24296a.getAbsolutePath();
        int i2 = this.f24297b;
        Bitmap a2 = NexImageLoader.loadBitmap(absolutePath, (i2 * 16) / 9, i2).a();
        if (a2 == null) {
            return a2;
        }
        i = this.f24299d.m_rotation;
        z = this.f24299d.m_fliph;
        z2 = this.f24299d.m_flipv;
        return NexImageLoader.rotateAndFlipImage(a2, (360 - i) % 360, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap == null) {
            this.f24298c.sendFailure(null);
        } else {
            this.f24298c.sendResult(bitmap);
        }
    }
}
