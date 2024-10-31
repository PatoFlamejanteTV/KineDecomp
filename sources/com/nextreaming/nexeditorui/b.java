package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
public class B implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f23979a;

    /* renamed from: b */
    final /* synthetic */ int f23980b;

    /* renamed from: c */
    final /* synthetic */ Task f23981c;

    public B(SharedPreferences sharedPreferences, int i, Task task) {
        this.f23979a = sharedPreferences;
        this.f23980b = i;
        this.f23981c = task;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23979a.edit().putInt("beta_days_remaining_last_shown", this.f23980b).apply();
        this.f23979a.edit().putInt("beta_days_remaining_last_shown_ver", 14242).apply();
        dialogInterface.dismiss();
        this.f23981c.signalEvent(Task.Event.COMPLETE);
    }
}
