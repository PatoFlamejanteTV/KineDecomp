package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.nf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1964nf extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1964nf(ProjectEditActivity projectEditActivity) {
        this.f22460a = projectEditActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InterfaceC2025f interfaceC2025f;
        InterfaceC2025f interfaceC2025f2;
        MediaPrepManager mediaPrepManager;
        MediaPrepManager mediaPrepManager2;
        InterfaceC2025f interfaceC2025f3;
        String action = intent.getAction();
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") && c.d.b.m.i.f(context)) {
            mediaPrepManager = this.f22460a.ya;
            mediaPrepManager.b();
            mediaPrepManager2 = this.f22460a.ya;
            interfaceC2025f3 = this.f22460a.T;
            mediaPrepManager2.a(interfaceC2025f3.getTimeline());
            return;
        }
        if (action.equals("com.nextreaming.kinemaster.asset.install.completed") || action.equals("com.nextreaming.kinemaster.asset.uninstall.completed")) {
            String stringExtra = intent.getStringExtra("asset_idx");
            if (action.equals("com.nextreaming.kinemaster.asset.uninstall.completed") && stringExtra != null) {
                interfaceC2025f = this.f22460a.T;
                if (interfaceC2025f.getTimeline().deleteDependentItemOnAsset(stringExtra, this.f22460a.ja())) {
                    this.f22460a.Oa = true;
                    interfaceC2025f2 = this.f22460a.T;
                    interfaceC2025f2.invalidate();
                    this.f22460a.ja().k();
                    this.f22460a.ja().K();
                }
            }
            Fragment findFragmentById = this.f22460a.getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i) {
                ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById).h(stringExtra);
            }
            Fragment findFragmentById2 = this.f22460a.getSupportFragmentManager().findFragmentById(R.id.aboveTimelineFragmentHolder);
            if (findFragmentById2 instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a) {
                ((com.nexstreaming.kinemaster.ui.audiobrowser.a) findFragmentById2).B();
            }
        }
    }
}
