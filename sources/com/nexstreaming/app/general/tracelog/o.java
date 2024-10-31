package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.z;
import java.net.URI;

/* compiled from: TraceLog.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static Task f3218a = null;

    public static Task a(Context context, String str, String str2, URI[] uriArr, String str3) {
        if (f3218a != null && (f3218a.isComplete() || f3218a.isRunning())) {
            return f3218a;
        }
        f3218a = new Task();
        String e = z.e(context);
        if (e == null || e.length() < 1) {
            f3218a.sendFailure(Task.makeTaskError("app version info error"));
            return f3218a;
        }
        if (PreferenceManager.getDefaultSharedPreferences(context).getString(str, "").equals(e)) {
            f3218a.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
            return f3218a;
        }
        l.a(context).a(uriArr, (URI[]) new RegisterAppRequest(context, str2, str3)).onResultAvailable(new q()).onFailure((Task.OnFailListener) new p());
        return f3218a;
    }
}
