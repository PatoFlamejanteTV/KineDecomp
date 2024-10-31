package com.nextreaming.nexeditorui.newproject.b;

import android.content.Context;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import java.lang.ref.WeakReference;

/* compiled from: ThemeDownloadServerConnector.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private EffectLibrary f4681a;
    private ResultTask<Theme[]> b;
    private WeakReference<a> c;

    /* compiled from: ThemeDownloadServerConnector.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void a(Theme[] themeArr);
    }

    public s(Context context, a aVar) {
        this.f4681a = EffectLibrary.a(context);
        this.c = new WeakReference<>(aVar);
        boolean c = com.nexstreaming.kinemaster.h.a.c(context);
        Log.i("ThemeDownloadServerConnector", "isConnected : " + c);
        if (!c) {
            aVar.a(200);
        }
    }

    public void a(Context context) {
        Log.d("ThemeDownloadServerConnector", "getServerThemes()");
        if (com.nexstreaming.kinemaster.h.a.c(context)) {
            this.b = this.f4681a.d();
            this.b.onResultAvailable(new t(this));
            this.b.onFailure((Task.OnFailListener) new u(this));
        }
    }
}
