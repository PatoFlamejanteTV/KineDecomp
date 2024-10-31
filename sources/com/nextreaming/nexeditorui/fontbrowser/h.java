package com.nextreaming.nexeditorui.fontbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.LruCache;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.fonts.Font;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
public class h extends AsyncTask<Font, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    Font f24269a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FontBrowserActivity f24270b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FontBrowserActivity fontBrowserActivity) {
        this.f24270b = fontBrowserActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Font... fontArr) {
        Context context;
        int a2;
        Context context2;
        Context context3;
        this.f24269a = fontArr[0];
        Font font = this.f24269a;
        context = this.f24270b.f24252b;
        Bitmap a3 = font.a(context);
        if (a3 == null) {
            return null;
        }
        a2 = this.f24270b.a(a3);
        Font font2 = this.f24269a;
        context2 = this.f24270b.f24252b;
        Bitmap createBitmap = Bitmap.createBitmap(a2, font2.a(context2).getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(a3, 0.0f, 0.0f, new Paint());
        int integer = this.f24270b.getResources().getInteger(R.integer.font_toolbar_title_scale);
        if (integer <= 0) {
            return createBitmap;
        }
        Font font3 = this.f24269a;
        context3 = this.f24270b.f24252b;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, a2 / integer, font3.a(context3).getHeight() / integer, true);
        createBitmap.recycle();
        return createScaledBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        LruCache lruCache;
        Toolbar toolbar;
        if (bitmap != null) {
            lruCache = FontBrowserActivity.f24251a;
            lruCache.put(this.f24269a.getId(), bitmap);
            toolbar = this.f24270b.f24255e;
            toolbar.a(bitmap, 1);
        }
    }
}
