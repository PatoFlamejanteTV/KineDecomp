package com.nexstreaming.kinemaster.kmpackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.LruCache;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Theme.java */
/* loaded from: classes.dex */
public class as extends AsyncTask<Integer, Integer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3441a;
    final /* synthetic */ Theme b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Theme theme, ResultTask resultTask) {
        this.b = theme;
        this.f3441a = resultTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Integer... numArr) {
        boolean z;
        Bitmap z2;
        z = this.b.p;
        if (!z) {
            z2 = this.b.z();
            return z2;
        }
        return this.b.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        ResultTask resultTask;
        LruCache lruCache;
        ResultTask resultTask2;
        if (bitmap == null) {
            ResultTask resultTask3 = this.f3441a;
            resultTask2 = this.b.M;
            if (resultTask3 == resultTask2) {
                this.b.M = null;
            }
            this.f3441a.signalEvent(Task.Event.FAIL);
            return;
        }
        ResultTask resultTask4 = this.f3441a;
        resultTask = this.b.M;
        if (resultTask4 == resultTask) {
            this.b.M = null;
        }
        this.b.L = new WeakReference(bitmap);
        lruCache = Theme.F;
        lruCache.put(this.b.i(), bitmap);
        this.f3441a.setResult(bitmap);
        this.f3441a.signalEvent(Task.Event.COMPLETE);
    }
}
