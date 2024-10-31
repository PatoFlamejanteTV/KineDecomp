package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.ComponentCallbacks2;
import android.media.MediaPlayer;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.audiobrowser.q;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexIndexableListView;
import com.nextreaming.nexeditorui.bp;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class j implements q.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f3675a = aVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.q.a
    public void a(q qVar, n nVar, int i) {
        NexIndexableListView nexIndexableListView;
        NexIndexableListView nexIndexableListView2;
        String str;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        MediaPlayer mediaPlayer5;
        MediaPlayer mediaPlayer6;
        MediaPlayer mediaPlayer7;
        q qVar2;
        MediaPlayer mediaPlayer8;
        String str2;
        MediaPlayer mediaPlayer9;
        MediaPlayer mediaPlayer10;
        q qVar3;
        MediaPlayer mediaPlayer11;
        q qVar4;
        NexIndexableListView nexIndexableListView3;
        MediaPlayer mediaPlayer12;
        MediaPlayer mediaPlayer13;
        q qVar5;
        nexIndexableListView = this.f3675a.e;
        if (nexIndexableListView != null) {
            nexIndexableListView2 = this.f3675a.e;
            if (nexIndexableListView2.getCheckedItemPosition() != i) {
                nexIndexableListView3 = this.f3675a.e;
                nexIndexableListView3.setItemChecked(i, true);
                mediaPlayer12 = this.f3675a.j;
                if (mediaPlayer12.isPlaying()) {
                    mediaPlayer13 = this.f3675a.j;
                    mediaPlayer13.pause();
                    qVar5 = this.f3675a.l;
                    qVar5.a(-1);
                    return;
                }
                return;
            }
            String d = nVar.d();
            str = this.f3675a.k;
            if (str != null) {
                str2 = this.f3675a.k;
                if (str2.equals(d)) {
                    mediaPlayer9 = this.f3675a.j;
                    if (mediaPlayer9.isPlaying()) {
                        mediaPlayer11 = this.f3675a.j;
                        mediaPlayer11.pause();
                        qVar4 = this.f3675a.l;
                        qVar4.a(-1);
                        return;
                    }
                    mediaPlayer10 = this.f3675a.j;
                    mediaPlayer10.start();
                    qVar3 = this.f3675a.l;
                    qVar3.a(i);
                    return;
                }
            }
            KMUsage.AudioBrowser_PreviewPlay.logEvent();
            mediaPlayer = this.f3675a.j;
            if (mediaPlayer != null) {
                mediaPlayer2 = this.f3675a.j;
                if (mediaPlayer2.isPlaying()) {
                    mediaPlayer8 = this.f3675a.j;
                    mediaPlayer8.stop();
                }
                mediaPlayer3 = this.f3675a.j;
                mediaPlayer3.reset();
                mediaPlayer4 = this.f3675a.j;
                mediaPlayer4.setAudioStreamType(3);
                try {
                    mediaPlayer5 = this.f3675a.j;
                    mediaPlayer5.setDataSource(d);
                    mediaPlayer6 = this.f3675a.j;
                    mediaPlayer6.prepare();
                    this.f3675a.k = d;
                    mediaPlayer7 = this.f3675a.j;
                    mediaPlayer7.start();
                    qVar2 = this.f3675a.l;
                    qVar2.a(i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.q.a
    public void b(q qVar, n nVar, int i) {
        NexIndexableListView nexIndexableListView;
        NexIndexableListView nexIndexableListView2;
        boolean z;
        AudioCategory audioCategory;
        int i2;
        Toolbar toolbar;
        String str;
        NexIndexableListView nexIndexableListView3;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        q qVar2;
        nexIndexableListView = this.f3675a.e;
        if (nexIndexableListView != null) {
            nexIndexableListView2 = this.f3675a.e;
            if (nexIndexableListView2.getCheckedItemPosition() != i) {
                nexIndexableListView3 = this.f3675a.e;
                nexIndexableListView3.setItemChecked(i, true);
                mediaPlayer = this.f3675a.j;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer2 = this.f3675a.j;
                    mediaPlayer2.pause();
                    qVar2 = this.f3675a.l;
                    qVar2.a(-1);
                    return;
                }
                return;
            }
            MediaInfo a2 = MediaInfo.a(nVar.d());
            if (a2 == null || a2.l()) {
                z = this.f3675a.q;
                if (z) {
                    this.f3675a.o = nVar.a();
                    toolbar = this.f3675a.r;
                    str = this.f3675a.o;
                    toolbar.a(str, 1);
                }
                KMUsage kMUsage = KMUsage.AudioBrowser_AddOrSelect;
                audioCategory = this.f3675a.f;
                kMUsage.logEvent("category", audioCategory.name(), "durationInSeconds", KMUsage.bucketParam0to300(nVar.b() / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
                this.f3675a.d();
                ComponentCallbacks2 activity = this.f3675a.getActivity();
                if (activity != null && (activity instanceof bp)) {
                    String c = nVar.c();
                    String a3 = nVar.a();
                    i2 = this.f3675a.m;
                    ((bp) activity).a(c, a3, i2);
                    return;
                }
                return;
            }
            new a.C0074a(this.f3675a.getActivity()).a(this.f3675a.getString(R.string.mediabrowser_audio_notsupport)).a(R.string.button_ok, new k(this)).a().show();
        }
    }
}
