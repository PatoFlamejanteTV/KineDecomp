package com.nexstreaming.app.kinemasterfree.wxapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.tracelog.a;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WXEntryActivity.java */
/* loaded from: classes.dex */
public class g implements ResultTask.OnResultAvailableListener<a.C0073a> {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f3254a;
    final /* synthetic */ WXEntryActivity b;

    public g(WXEntryActivity wXEntryActivity, SharedPreferences sharedPreferences) {
        this.b = wXEntryActivity;
        this.f3254a = sharedPreferences;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a */
    public void onResultAvailable(ResultTask<a.C0073a> resultTask, Task.Event event, a.C0073a c0073a) {
        if (!this.f3254a.getBoolean("wx_event", false)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Promotion Name", "WeChat_Shared");
                KMUsage.getMixpanelPeople(this.b).a(jSONObject);
                KMUsage.getMixpanelInstanceFromContext(this.b).a(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PreferenceManager.getDefaultSharedPreferences(this.b).edit().putBoolean("wx_event", true).apply();
            Intent b = android.support.v4.a.c.b(new Intent(this.b, (Class<?>) ProjectGalleryActivity.class).getComponent());
            b.setAction("com.nexstreaming.app.kinemasterfree.wechat.share.timeline.completed");
            this.b.startActivity(b);
            this.b.finish();
            this.b.overridePendingTransition(0, 0);
        }
    }
}
