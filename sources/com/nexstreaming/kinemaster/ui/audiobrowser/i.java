package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
final class i implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f21443a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AudioCategory[] audioCategoryArr;
        this.f21443a.w = i;
        a aVar = this.f21443a;
        audioCategoryArr = a.f21405a;
        AudioCategory audioCategory = audioCategoryArr[i];
        kotlin.jvm.internal.h.a((Object) audioCategory, "CATEGORIES[position]");
        aVar.a(audioCategory);
    }
}
