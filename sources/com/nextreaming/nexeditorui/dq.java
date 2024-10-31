package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ProjectSettingsPopup;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectSettingsPopup.java */
/* loaded from: classes.dex */
public class dq implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4606a;
    final /* synthetic */ ProjectSettingsPopup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(ProjectSettingsPopup projectSettingsPopup, Context context) {
        this.b = projectSettingsPopup;
        this.f4606a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NexTimeline nexTimeline;
        ProjectSettingsPopup.a aVar;
        NexTimeline nexTimeline2;
        int i2;
        NexTimeline nexTimeline3;
        boolean z;
        NexTimeline nexTimeline4;
        int i3;
        NexTimeline nexTimeline5;
        boolean z2;
        NexTimeline nexTimeline6;
        int i4;
        NexTimeline nexTimeline7;
        boolean z3;
        NexTimeline nexTimeline8;
        int i5;
        NexTimeline nexTimeline9;
        boolean z4;
        boolean z5;
        String str;
        boolean z6;
        String str2;
        boolean z7;
        String str3;
        boolean z8;
        String str4;
        int i6;
        int i7;
        int i8;
        int i9;
        nexTimeline = this.b.k;
        if (nexTimeline != null) {
            nexTimeline2 = this.b.k;
            i2 = this.b.b;
            nexTimeline2.setProjectAudioFadeInTimeMillis(i2);
            nexTimeline3 = this.b.k;
            z = this.b.f;
            nexTimeline3.setProjectAudioFadeInTimeOn(z);
            nexTimeline4 = this.b.k;
            i3 = this.b.c;
            nexTimeline4.setProjectAudioFadeOutTimeMillis(i3);
            nexTimeline5 = this.b.k;
            z2 = this.b.g;
            nexTimeline5.setProjectAudioFadeOutTimeOn(z2);
            nexTimeline6 = this.b.k;
            i4 = this.b.d;
            nexTimeline6.setProjectVideoFadeInTimeMillis(i4);
            nexTimeline7 = this.b.k;
            z3 = this.b.h;
            nexTimeline7.setProjectVideoFadeInTimeOn(z3);
            nexTimeline8 = this.b.k;
            i5 = this.b.e;
            nexTimeline8.setProjectVideoFadeOutTimeMillis(i5);
            nexTimeline9 = this.b.k;
            z4 = this.b.i;
            nexTimeline9.setProjectVideoFadeOutTimeOn(z4);
            try {
                com.mixpanel.android.mpmetrics.n mixpanelInstanceFromContext = KMUsage.getMixpanelInstanceFromContext(this.f4606a);
                JSONObject jSONObject = new JSONObject();
                z5 = this.b.f;
                if (z5) {
                    StringBuilder sb = new StringBuilder();
                    i9 = this.b.b;
                    str = sb.append(i9).append("ms").toString();
                } else {
                    str = "Disabled";
                }
                JSONObject put = jSONObject.put("Audio Fade In", str);
                z6 = this.b.g;
                if (z6) {
                    StringBuilder sb2 = new StringBuilder();
                    i8 = this.b.c;
                    str2 = sb2.append(i8).append("ms").toString();
                } else {
                    str2 = "Disabled";
                }
                JSONObject put2 = put.put("Audio Fade Out", str2);
                z7 = this.b.h;
                if (z7) {
                    StringBuilder sb3 = new StringBuilder();
                    i7 = this.b.d;
                    str3 = sb3.append(i7).append("ms").toString();
                } else {
                    str3 = "Disabled";
                }
                JSONObject put3 = put2.put("Video Fade In", str3);
                z8 = this.b.i;
                if (z8) {
                    StringBuilder sb4 = new StringBuilder();
                    i6 = this.b.e;
                    str4 = sb4.append(i6).append("ms").toString();
                } else {
                    str4 = "Disabled";
                }
                mixpanelInstanceFromContext.a("Project Settings Change", put3.put("Video Fade Out", str4));
            } catch (JSONException e) {
                Log.e("LOG_TAG", "MixPanel json err", e);
            }
        }
        aVar = this.b.j;
        aVar.a();
        this.b.dismiss();
    }
}
