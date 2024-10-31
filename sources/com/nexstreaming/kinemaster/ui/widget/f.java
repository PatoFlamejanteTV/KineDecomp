package com.nexstreaming.kinemaster.ui.widget;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCyclerView.java */
/* loaded from: classes.dex */
public class f extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AssetManager f4390a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ ResultTask d;
    final /* synthetic */ ImageCyclerView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImageCyclerView imageCyclerView, AssetManager assetManager, String str, int i, ResultTask resultTask) {
        this.e = imageCyclerView;
        this.f4390a = assetManager;
        this.b = str;
        this.c = i;
        this.d = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        try {
            InputStream open = this.f4390a.open(this.b);
            try {
                return NexImageLoader.loadBitmap(open, this.c, this.c, Integer.MAX_VALUE).a();
            } finally {
                open.close();
            }
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        Map map;
        if (bitmap != null) {
            map = ImageCyclerView.b;
            map.put(this.b, new WeakReference(bitmap));
            this.d.sendResult(bitmap);
        } else {
            this.d.sendFailure(null);
        }
        super.onPostExecute(bitmap);
    }
}
