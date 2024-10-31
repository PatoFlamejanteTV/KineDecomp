package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.AsyncTask;

/* loaded from: classes.dex */
class b extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1413a;
    final /* synthetic */ GcmListenerService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GcmListenerService gcmListenerService, Intent intent) {
        this.b = gcmListenerService;
        this.f1413a = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.b.a(this.f1413a);
        return null;
    }
}
