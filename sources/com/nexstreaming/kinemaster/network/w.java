package com.nexstreaming.kinemaster.network;

import android.content.Context;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class w implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VolleyNetworkService f21153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(VolleyNetworkService volleyNetworkService) {
        this.f21153a = volleyNetworkService;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Context context;
        context = this.f21153a.j;
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove("access_token").remove("scope").apply();
        this.f21153a.m = false;
        this.f21153a.f();
    }
}
