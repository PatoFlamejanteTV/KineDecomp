package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.ClipDrawable;
import android.widget.Button;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.mr;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
public class mh implements mr.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mf f4089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mh(mf mfVar) {
        this.f4089a = mfVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(mr.a aVar) {
        boolean z;
        int i;
        z = this.f4089a.m;
        if (!z && this.f4089a.isAdded()) {
            this.f4089a.m = true;
            VideoEditor o = this.f4089a.o();
            o.p();
            i = this.f4089a.h;
            o.a(i, true).onComplete(new mj(this, o, aVar)).onFailure(new mi(this, aVar));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(File file) {
        VideoEditor o = this.f4089a.o();
        o.p().onComplete(new mm(this, file, o));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(boolean z) {
        mr mrVar;
        mr mrVar2;
        mr mrVar3;
        this.f4089a.o().p();
        this.f4089a.o().b(this.f4089a);
        this.f4089a.d(R.id.action_play_pause, true);
        this.f4089a.i(true);
        this.f4089a.j(true);
        this.f4089a.k(true);
        this.f4089a.l(true);
        this.f4089a.m(true);
        this.f4089a.k();
        this.f4089a.n = true;
        if (z) {
            this.f4089a.k = true;
        }
        mrVar = this.f4089a.g;
        if (mrVar != null) {
            mrVar2 = this.f4089a.g;
            mrVar2.a();
            mrVar3 = this.f4089a.g;
            mrVar3.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.mr.b
    public void a(boolean z, boolean z2, int i) {
        ClipDrawable clipDrawable;
        Button button;
        ClipDrawable clipDrawable2;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        if (this.f4089a.isAdded()) {
            if (z) {
                button2 = this.f4089a.e;
                if (button2 != null) {
                    button3 = this.f4089a.e;
                    button3.setEnabled(false);
                    button4 = this.f4089a.e;
                    button4.setText(this.f4089a.getResources().getText(R.string.voicerec_btn_wait));
                    button5 = this.f4089a.e;
                    button5.setTextColor(-1);
                }
            }
            if (!z && !z2) {
                String string = this.f4089a.getResources().getString(R.string.voicerec_btn_start);
                button = this.f4089a.e;
                button.postDelayed(new mo(this, string), 500L);
                this.f4089a.f(R.string.voicerec_desc_title_ready);
                clipDrawable2 = this.f4089a.d;
                clipDrawable2.setLevel(0);
                this.f4089a.k();
            }
            if (!z && z2 && i > -1) {
                clipDrawable = this.f4089a.d;
                clipDrawable.setLevel(i);
            }
        }
    }
}
