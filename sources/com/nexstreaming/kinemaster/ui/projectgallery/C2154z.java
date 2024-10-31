package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2154z extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f23007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2154z(O o) {
        this.f23007a = o;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Map map;
        if (intent == null || intent.getAction() == null || intent.getAction().equals("com.nextreaming.kinemaster.asset.install.completed") || !intent.getAction().equals("com.nextreaming.kinemaster.asset.uninstall.completed")) {
            return;
        }
        map = this.f23007a.f22869d;
        map.clear();
        this.f23007a.f22870e = null;
    }
}
