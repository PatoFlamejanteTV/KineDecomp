package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.File;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class dn extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4603a;
    final /* synthetic */ int b;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ NexVideoClipItem d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(NexVideoClipItem nexVideoClipItem, File file, int i, ResultTask resultTask) {
        this.d = nexVideoClipItem;
        this.f4603a = file;
        this.b = i;
        this.c = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        int i;
        boolean z;
        boolean z2;
        Bitmap a2 = NexImageLoader.loadBitmap(this.f4603a.getAbsolutePath(), (this.b * 16) / 9, this.b).a();
        if (a2 != null) {
            i = this.d.m_rotation;
            z = this.d.m_fliph;
            z2 = this.d.m_flipv;
            return NexImageLoader.rotateAndFlipImage(a2, (360 - i) % 360, z, z2);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap == null) {
            this.c.sendFailure(null);
        } else {
            this.c.sendResult(bitmap);
        }
    }
}
