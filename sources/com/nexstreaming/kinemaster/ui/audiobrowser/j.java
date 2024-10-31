package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
final class j implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f21444a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f21444a.a(j);
    }
}
