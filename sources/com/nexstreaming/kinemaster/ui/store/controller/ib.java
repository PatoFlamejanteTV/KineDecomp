package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StoreActivity.java */
/* loaded from: classes2.dex */
public class ib extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StoreActivity f23568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(StoreActivity storeActivity) {
        this.f23568a = storeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            View findViewById = this.f23568a.findViewById(R.id.network_connection_error_bar);
            View findViewById2 = this.f23568a.findViewById(R.id.networkErrorHolder);
            Fragment findFragmentById = this.f23568a.getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") && c.d.b.m.i.f(context)) {
                findViewById.setVisibility(8);
                if (findViewById2.getVisibility() == 0) {
                    findViewById2.setVisibility(8);
                }
                if (this.f23568a.getSupportFragmentManager() == null || findFragmentById == null || !(findFragmentById instanceof ob)) {
                    return;
                }
                ((ob) findFragmentById).A();
                return;
            }
            if (this.f23568a.findViewById(R.id.networkErrorHolder).getVisibility() == 0 || this.f23568a.getSupportFragmentManager() == null || findFragmentById == null || (findFragmentById instanceof eb)) {
                return;
            }
            findViewById.setVisibility(0);
        }
    }
}
