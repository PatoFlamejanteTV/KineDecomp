package com.nexstreaming.kinemaster.codeccolorformat;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccolorformat.ColorFormatChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public final class a extends AsyncTask<Void, Void, ColorFormatChecker.ColorFormat> {

    /* renamed from: a, reason: collision with root package name */
    Task.TaskError f3287a = null;
    final /* synthetic */ SharedPreferences b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ColorFormatChecker.ColorFormat doInBackground(Void... voidArr) {
        ColorFormatChecker.ColorFormat b;
        try {
            b = new ColorFormatChecker(null).b();
            return b;
        } catch (Exception e) {
            this.f3287a = Task.makeTaskError("Error getting color format", e);
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
            resultTask = ColorFormatChecker.f3286a;
            resultTask.sendFailure(this.f3287a);
        } else {
            this.b.edit().putString("km_detected_codec_color_format", colorFormat.name()).commit();
            resultTask2 = ColorFormatChecker.f3286a;
            resultTask2.sendResult(colorFormat);
        }
        super.onPostExecute(colorFormat);
    }
}
