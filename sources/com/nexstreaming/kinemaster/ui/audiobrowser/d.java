package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3669a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AudioCategory[] audioCategoryArr;
        AudioCategory[] audioCategoryArr2;
        KMUsage kMUsage = KMUsage.AudioBrowser_ChooseCategory;
        audioCategoryArr = a.g;
        kMUsage.logEvent("category", audioCategoryArr[i].name());
        a aVar = this.f3669a;
        audioCategoryArr2 = a.g;
        aVar.a(audioCategoryArr2[i]);
    }
}
