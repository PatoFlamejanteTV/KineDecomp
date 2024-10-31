package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3667a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3667a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3667a.d();
    }
}
