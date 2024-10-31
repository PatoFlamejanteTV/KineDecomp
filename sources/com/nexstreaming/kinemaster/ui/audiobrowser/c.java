package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.audiobrowser.x;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.InterfaceC2301ca;
import com.nextreaming.nexeditorui.NexIndexableListView;
import kotlin.TypeCastException;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class c implements x.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21437a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f21437a = aVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.x.b
    public void a(x xVar, u uVar, int i) {
        NexIndexableListView nexIndexableListView;
        NexIndexableListView nexIndexableListView2;
        NexIndexableListView nexIndexableListView3;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        x xVar2;
        boolean b2;
        boolean z;
        AudioCategory audioCategory;
        int i2;
        AudioCategory audioCategory2;
        Toolbar toolbar;
        String str;
        MediaInfo a2;
        kotlin.jvm.internal.h.b(xVar, "adapter");
        kotlin.jvm.internal.h.b(uVar, "trackInfo");
        nexIndexableListView = this.f21437a.f21410f;
        if (nexIndexableListView == null) {
            return;
        }
        nexIndexableListView2 = this.f21437a.f21410f;
        if (nexIndexableListView2 == null || nexIndexableListView2.getCheckedItemPosition() != i) {
            nexIndexableListView3 = this.f21437a.f21410f;
            if (nexIndexableListView3 != null) {
                nexIndexableListView3.setItemChecked(i, true);
            }
            mediaPlayer = this.f21437a.m;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            mediaPlayer2 = this.f21437a.m;
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
            }
            xVar2 = this.f21437a.o;
            if (xVar2 != null) {
                xVar2.b(-1);
                return;
            }
            return;
        }
        String e2 = uVar.e();
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        kotlin.jvm.internal.h.a((Object) e2, "mediaPath");
        b2 = kotlin.text.v.b(e2, "@kmasset:", false, 2, null);
        if (b2 || (a2 = MediaInfo.a(e2)) == null || a2.Z()) {
            z = this.f21437a.u;
            if (z) {
                this.f21437a.s = uVar.b();
                toolbar = this.f21437a.v;
                if (toolbar != null) {
                    str = this.f21437a.s;
                    toolbar.a(str, 1);
                }
            }
            audioCategory = this.f21437a.j;
            if (audioCategory != null) {
                com.nexstreaming.app.general.nexasset.assetpackage.b a3 = uVar.a();
                Log.d("AudioBrowserFragment", String.valueOf(a3 != null ? Integer.valueOf(a3.getAssetIdx()) : null));
                audioCategory2 = this.f21437a.j;
                if (audioCategory2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                com.nexstreaming.kinemaster.usage.analytics.f.a(audioCategory2, uVar);
            }
            this.f21437a.G();
            if (this.f21437a.getActivity() == null || !(this.f21437a.getActivity() instanceof InterfaceC2301ca)) {
                return;
            }
            android.arch.lifecycle.s activity = this.f21437a.getActivity();
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.NexAMediaReceiver");
            }
            String e3 = uVar.e();
            String d2 = uVar.d();
            i2 = this.f21437a.p;
            ((InterfaceC2301ca) activity).a(e3, d2, i2);
            return;
        }
        String string = this.f21437a.getString(R.string.mediabrowser_audio_notsupport);
        kotlin.jvm.internal.h.a((Object) string, "getString(R.string.mediabrowser_audio_notsupport)");
        e.a aVar = new e.a(this.f21437a.getActivity());
        aVar.a(string);
        aVar.c(R.string.button_ok, b.f21436a);
        aVar.a().show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bb, code lost:            r3 = r1.f21437a.m;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c9, code lost:            r3 = r1.f21437a.m;     */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.x.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.nexstreaming.kinemaster.ui.audiobrowser.x r2, com.nexstreaming.kinemaster.ui.audiobrowser.u r3, int r4) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.audiobrowser.c.b(com.nexstreaming.kinemaster.ui.audiobrowser.x, com.nexstreaming.kinemaster.ui.audiobrowser.u, int):void");
    }
}
