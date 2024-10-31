package com.mixpanel.android.mpmetrics;

import android.content.SharedPreferences;
import com.mixpanel.android.mpmetrics.aa;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
public class o implements aa.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f3043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f3043a = nVar;
    }

    @Override // com.mixpanel.android.mpmetrics.aa.b
    public void a(SharedPreferences sharedPreferences) {
        JSONArray a2 = w.a(sharedPreferences);
        if (a2 != null) {
            this.f3043a.a(a2);
        }
    }
}
