package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Rd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22048a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f22049b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicInteger f22050c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f22051d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f22052e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22053f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f22054g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rd(Bd bd, File file, AtomicInteger atomicInteger, Handler handler, String str, VideoEditor videoEditor, boolean z) {
        this.f22048a = bd;
        this.f22049b = file;
        this.f22050c = atomicInteger;
        this.f22051d = handler;
        this.f22052e = str;
        this.f22053f = videoEditor;
        this.f22054g = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String string;
        boolean b2;
        if (!this.f22049b.exists()) {
            if (this.f22050c.incrementAndGet() < 10) {
                this.f22051d.postDelayed(this, 500L);
                return;
            }
            return;
        }
        MediaInfo a2 = MediaInfo.a(this.f22052e);
        kotlin.jvm.internal.h.a((Object) a2, "info");
        if (!a2.Z()) {
            string = this.f22048a.getResources().getString(R.string.rec_video_fail_formaterr);
        } else if (a2.r() < 100) {
            string = this.f22048a.getResources().getString(R.string.rec_video_fail_tooshort, Float.valueOf(0.1f));
        } else {
            string = a2.D() * a2.C() > 8294400 ? this.f22048a.getResources().getString(R.string.rec_video_fail_toolarge, 3840, 2160) : null;
        }
        if (string != null) {
            return;
        }
        if (!(this.f22052e.length() > 0) || !new File(this.f22052e).exists()) {
            b2 = kotlin.text.v.b(this.f22052e, "@solid:", false, 2, null);
            if (!b2) {
                return;
            }
        }
        if (EditorGlobal.c(this.f22052e)) {
            File file = new File(this.f22052e);
            com.nexstreaming.kinemaster.mediastore.scanner.e h2 = KineMasterApplication.f24058f.c().h();
            if (h2 != null) {
                h2.a(file).onComplete(new Qd(this, file));
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
