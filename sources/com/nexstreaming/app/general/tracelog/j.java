package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/* compiled from: NotifyApp.java */
/* loaded from: classes.dex */
public class j {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotifyApp.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        URI[] f3213a;
        NotifyAppRequest b;

        /* synthetic */ a(URI[] uriArr, NotifyAppRequest notifyAppRequest, k kVar) {
            this(uriArr, notifyAppRequest);
        }

        private a(URI[] uriArr, NotifyAppRequest notifyAppRequest) {
            this.f3213a = uriArr;
            this.b = notifyAppRequest;
        }
    }

    public static boolean a(Context context, int i) {
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet("nex_noifyapp_shown_messages", null);
        return stringSet != null && stringSet.contains(new StringBuilder().append("").append(i).toString());
    }

    public static void b(Context context, int i) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        HashSet hashSet = new HashSet(defaultSharedPreferences.getStringSet("nex_noifyapp_shown_messages", new HashSet()));
        hashSet.add("" + i);
        defaultSharedPreferences.edit().putStringSet("nex_noifyapp_shown_messages", hashSet).commit();
    }

    public static ResultTask<NotifyAppResponse> a(URI[] uriArr, NotifyAppRequest notifyAppRequest) {
        ResultTask<NotifyAppResponse> resultTask = new ResultTask<>();
        new k(resultTask).executeOnExecutor(EditorGlobal.l, new a(uriArr, notifyAppRequest, null));
        return resultTask;
    }
}
