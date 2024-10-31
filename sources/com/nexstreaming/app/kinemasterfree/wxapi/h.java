package com.nexstreaming.app.kinemasterfree.wxapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.APCManager;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* compiled from: WXEntryActivity.java */
/* loaded from: classes2.dex */
class h implements ResultTask.OnResultAvailableListener<APCManager.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f19929a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WXEntryActivity f19930b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WXEntryActivity wXEntryActivity, SharedPreferences sharedPreferences) {
        this.f19930b = wXEntryActivity;
        this.f19929a = sharedPreferences;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<APCManager.a> resultTask, Task.Event event, APCManager.a aVar) {
        if (this.f19929a.getBoolean("wx_event", false)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(this.f19930b).edit().putBoolean("wx_event", true).apply();
        Intent intent = new Intent(this.f19930b, (Class<?>) ProjectGalleryActivity.class);
        intent.setFlags(603979776);
        intent.setAction("com.nexstreaming.app.kinemasterfree.wechat.share.timeline.completed");
        this.f19930b.startActivity(intent);
        this.f19930b.finish();
    }
}
