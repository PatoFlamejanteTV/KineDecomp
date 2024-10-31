package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.util.Log;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.usage.KMUsage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class km implements VideoEditor.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4037a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public km(ProjectEditActivity projectEditActivity, Intent intent) {
        this.b = projectEditActivity;
        this.f4037a = intent;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.c
    public void a(boolean z) {
        String action = this.f4037a.getAction();
        String str = "Empty";
        if (action != null) {
            if (action.equals(KMIntentData.ACTION_KINEMASTER_NEW_PROJECT_INTENT)) {
                str = this.f4037a.getBooleanExtra(KMIntentData.KEY_FROM_SDK, false) ? "SDK" : "Share";
            } else if (action.equals("assistant")) {
                str = "Assistant";
            }
        }
        Log.i("ProjectEditActivity", "create project by " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Type", str);
            jSONObject.put("Project Added", z ? "True" : "False");
        } catch (JSONException e) {
            Log.e("ProjectEditActivity", "MixPanel json err", e);
        }
        KMUsage.getMixpanelInstanceFromContext(this.b).a("Add Project", jSONObject);
        KMUsage.getMixpanelPeople(this.b).a("Project Count", 1.0d);
    }
}
