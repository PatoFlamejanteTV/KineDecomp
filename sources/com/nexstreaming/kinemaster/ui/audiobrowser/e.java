package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
class e implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3670a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3670a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3670a.a(j);
    }
}
