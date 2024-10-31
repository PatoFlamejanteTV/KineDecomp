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
/* loaded from: classes2.dex */
public class r {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotifyApp.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        URI[] f19791a;

        /* renamed from: b, reason: collision with root package name */
        NotifyAppRequest f19792b;

        /* synthetic */ a(URI[] uriArr, NotifyAppRequest notifyAppRequest, q qVar) {
            this(uriArr, notifyAppRequest);
        }

        private a(URI[] uriArr, NotifyAppRequest notifyAppRequest) {
            this.f19791a = uriArr;
            this.f19792b = notifyAppRequest;
        }
    }

    public static void a(Context context, int i) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        HashSet hashSet = new HashSet(defaultSharedPreferences.getStringSet("nex_noifyapp_shown_messages", new HashSet()));
        hashSet.add("" + i);
        defaultSharedPreferences.edit().putStringSet("nex_noifyapp_shown_messages", hashSet).commit();
    }

    public static boolean b(Context context, int i) {
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet("nex_noifyapp_shown_messages", null);
        if (stringSet == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return stringSet.contains(sb.toString());
    }

    public static ResultTask<NotifyAppResponse> a(URI[] uriArr, NotifyAppRequest notifyAppRequest) {
        ResultTask<NotifyAppResponse> resultTask = new ResultTask<>();
        new q(resultTask).executeOnExecutor(EditorGlobal.C, new a(uriArr, notifyAppRequest, null));
        return resultTask;
    }
}
