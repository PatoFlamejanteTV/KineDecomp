package com.facebook.marketing;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.marketing.ViewIndexer;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ViewIndexer.java */
/* loaded from: classes.dex */
public class e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Activity f9434a;

    /* renamed from: b */
    final /* synthetic */ String f9435b;

    /* renamed from: c */
    final /* synthetic */ ViewIndexer f9436c;

    public e(ViewIndexer viewIndexer, Activity activity, String str) {
        this.f9436c = viewIndexer;
        this.f9434a = activity;
        this.f9435b = str;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        String str;
        Handler handler;
        String str2;
        String str3;
        String str4;
        try {
            View rootView = this.f9434a.getWindow().getDecorView().getRootView();
            if (CodelessActivityLifecycleTracker.getIsAppIndexingEnabled()) {
                FutureTask futureTask = new FutureTask(new ViewIndexer.a(rootView));
                handler = this.f9436c.uiThreadHandler;
                handler.post(futureTask);
                try {
                    str3 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                } catch (Exception e2) {
                    str2 = ViewIndexer.TAG;
                    Log.e(str2, "Failed to take screenshot.", e2);
                    str3 = "";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("screenname", this.f9435b);
                    jSONObject.put("screenshot", str3);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                    jSONObject.put("view", jSONArray);
                } catch (JSONException unused) {
                    str4 = ViewIndexer.TAG;
                    Log.e(str4, "Failed to create JSONObject");
                }
                this.f9436c.sendToServer(jSONObject.toString(), this.f9435b);
            }
        } catch (Exception e3) {
            str = ViewIndexer.TAG;
            Log.e(str, "UI Component tree indexing failure!", e3);
        }
    }
}
