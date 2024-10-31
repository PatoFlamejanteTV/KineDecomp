package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundCapture.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3025a = Color.argb(186, 28, 28, 28);

    /* compiled from: BackgroundCapture.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Bitmap bitmap, int i);
    }

    public static void a(Activity activity, b bVar) {
        activity.runOnUiThread(new d(activity, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BackgroundCapture.java */
    /* loaded from: classes.dex */
    public static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private final b f3026a;
        private final Activity b;
        private Bitmap c;
        private int d = -16777216;

        public a(Activity activity, b bVar) {
            this.b = activity;
            this.f3026a = bVar;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.c = com.mixpanel.android.util.a.a(this.b, 2, 2, true);
            this.d = com.mixpanel.android.util.a.a(this.c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            if (this.c != null) {
                try {
                    com.mixpanel.android.util.f.a(this.c, 20);
                    new Canvas(this.c).drawColor(c.f3025a, PorterDuff.Mode.SRC_ATOP);
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.c = null;
                } catch (OutOfMemoryError e2) {
                    this.c = null;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r4) {
            this.f3026a.a(this.c, this.d);
        }
    }
}
