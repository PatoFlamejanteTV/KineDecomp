package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.settings.C2202xa;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewSettingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC2175ja implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2202xa f23157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2175ja(C2202xa c2202xa) {
        this.f23157a = c2202xa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimeline nexTimeline;
        NexTimeline nexTimeline2;
        int i;
        NexTimeline nexTimeline3;
        boolean z;
        NexTimeline nexTimeline4;
        int i2;
        NexTimeline nexTimeline5;
        boolean z2;
        NexTimeline nexTimeline6;
        int i3;
        NexTimeline nexTimeline7;
        boolean z3;
        NexTimeline nexTimeline8;
        int i4;
        NexTimeline nexTimeline9;
        boolean z4;
        NexTimeline nexTimeline10;
        NexVideoClipItem.CropMode cropMode;
        NexTimeline nexTimeline11;
        int i5;
        NexTimeline nexTimeline12;
        int i6;
        NexTimeline nexTimeline13;
        boolean z5;
        NexTimeline nexTimeline14;
        int i7;
        C2202xa.c cVar;
        C2202xa.c cVar2;
        if (view.getId() != R.id.accept_button) {
            return;
        }
        nexTimeline = this.f23157a.u;
        if (nexTimeline != null) {
            nexTimeline2 = this.f23157a.u;
            i = this.f23157a.f23234h;
            nexTimeline2.setProjectAudioFadeInTimeMillis(i);
            nexTimeline3 = this.f23157a.u;
            z = this.f23157a.l;
            nexTimeline3.setProjectAudioFadeInTimeOn(z);
            nexTimeline4 = this.f23157a.u;
            i2 = this.f23157a.i;
            nexTimeline4.setProjectAudioFadeOutTimeMillis(i2);
            nexTimeline5 = this.f23157a.u;
            z2 = this.f23157a.m;
            nexTimeline5.setProjectAudioFadeOutTimeOn(z2);
            nexTimeline6 = this.f23157a.u;
            i3 = this.f23157a.j;
            nexTimeline6.setProjectVideoFadeInTimeMillis(i3);
            nexTimeline7 = this.f23157a.u;
            z3 = this.f23157a.n;
            nexTimeline7.setProjectVideoFadeInTimeOn(z3);
            nexTimeline8 = this.f23157a.u;
            i4 = this.f23157a.k;
            nexTimeline8.setProjectVideoFadeOutTimeMillis(i4);
            nexTimeline9 = this.f23157a.u;
            z4 = this.f23157a.o;
            nexTimeline9.setProjectVideoFadeOutTimeOn(z4);
            nexTimeline10 = this.f23157a.u;
            cropMode = this.f23157a.r;
            nexTimeline10.setProjectDefaultCropMode(cropMode);
            nexTimeline11 = this.f23157a.u;
            i5 = this.f23157a.p;
            nexTimeline11.setProjectDefaultPhotoDuration(i5);
            nexTimeline12 = this.f23157a.u;
            i6 = this.f23157a.q;
            nexTimeline12.setProjectDefaultLayerDuration(i6);
            nexTimeline13 = this.f23157a.u;
            z5 = this.f23157a.s;
            nexTimeline13.setAutoMaster(z5);
            nexTimeline14 = this.f23157a.u;
            i7 = this.f23157a.t;
            nexTimeline14.setProjectMasterVolume(i7);
            cVar = this.f23157a.v;
            if (cVar != null) {
                cVar2 = this.f23157a.v;
                cVar2.c(true);
            }
        }
        this.f23157a.getFragmentManager().popBackStack();
    }
}
