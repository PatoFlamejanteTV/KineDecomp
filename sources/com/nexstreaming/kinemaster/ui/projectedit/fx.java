package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.TextLayer;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3914a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(ez ezVar, String str) {
        this.b = ezVar;
        this.f3914a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this.b.getActivity()).getString("add_layer_def_duration", "6000"));
        TextLayer newInstance = TextLayer.newInstance(this.f3914a, this.b.o().u(), parseInt);
        this.b.o().a((NexLayerItem) newInstance);
        this.b.b(newInstance);
        new Handler().post(new fy(this, newInstance));
        this.b.d(newInstance);
    }
}
