package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.SharedPreferences;

/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
final class ae implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4512a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SharedPreferences sharedPreferences, int i) {
        this.f4512a = sharedPreferences;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4512a.edit().putInt("beta_days_remaining_last_shown", this.b).apply();
        this.f4512a.edit().putInt("beta_days_remaining_last_shown_ver", 8291).apply();
        dialogInterface.dismiss();
    }
}
