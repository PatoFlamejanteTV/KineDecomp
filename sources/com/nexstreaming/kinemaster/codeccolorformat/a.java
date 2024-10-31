package com.nexstreaming.kinemaster.codeccolorformat;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public class a extends AsyncTask<Void, Void, ColorFormatChecker.ColorFormat> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f20151a = null;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f20152b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SharedPreferences sharedPreferences) {
        this.f20152b = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ColorFormatChecker.ColorFormat doInBackground(Void... voidArr) {
        ColorFormatChecker.ColorFormat b2;
        try {
            b2 = new ColorFormatChecker(null).b();
            return b2;
        } catch (Exception e2) {
            this.f20151a = Task.makeTaskError("Error getting color format", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ColorFormatChecker.ColorFormat colorFormat) {
        ResultTask resultTask;
        ResultTask resultTask2;
        if (colorFormat == null) {
            resultTask = ColorFormatChecker.f20143a;
            resultTask.sendFailure(this.f20151a);
        } else {
            this.f20152b.edit().putString("km_detected_codec_color_format", colorFormat.name()).commit();
            resultTask2 = ColorFormatChecker.f20143a;
            resultTask2.sendResult(colorFormat);
        }
        super.onPostExecute(colorFormat);
    }
}
