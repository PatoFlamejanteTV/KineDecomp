package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f3044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.f3044a = nVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        JSONObject jSONObject = new JSONObject();
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        if (bundleExtra != null) {
            for (String str : bundleExtra.keySet()) {
                try {
                    jSONObject.put(str, bundleExtra.get(str));
                } catch (JSONException e) {
                    Log.e("MixpanelAPI.AL", "failed to add key \"" + str + "\" to properties for tracking bolts event", e);
                }
            }
        }
        this.f3044a.a("$" + intent.getStringExtra("event_name"), jSONObject);
    }
}
