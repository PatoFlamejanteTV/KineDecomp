package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.ClipDrawable;
import android.widget.Button;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Oh;
import java.io.File;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
public final class Ih implements Oh.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zh f21906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ih(zh zhVar) {
        this.f21906a = zhVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(Oh.a aVar) {
        boolean z;
        int i;
        kotlin.jvm.internal.h.b(aVar, "cueCallback");
        z = this.f21906a.w;
        if (!z && this.f21906a.isAdded()) {
            this.f21906a.w = true;
            VideoEditor da = this.f21906a.da();
            if (da != null) {
                da.M();
                i = this.f21906a.r;
                da.a(i, true).onComplete(new Gh(this, da, aVar)).onFailure(new Hh(this, aVar));
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(File file) {
        kotlin.jvm.internal.h.b(file, "recordedFile");
        VideoEditor da = this.f21906a.da();
        if (da != null) {
            da.M().onComplete(new Ch(this, file, da));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(boolean z) {
        Oh oh;
        Oh oh2;
        Oh oh3;
        VideoEditor da = this.f21906a.da();
        if (da != null) {
            da.M();
            VideoEditor da2 = this.f21906a.da();
            if (da2 != null) {
                da2.b(this.f21906a);
                this.f21906a.c(R.id.action_play_pause, true);
                this.f21906a.l(true);
                this.f21906a.k(true);
                this.f21906a.j(true);
                this.f21906a.h(true);
                this.f21906a.i(true);
                this.f21906a.J();
                this.f21906a.x = true;
                this.f21906a.F();
                if (z) {
                    this.f21906a.u = true;
                }
                oh = this.f21906a.q;
                if (oh != null) {
                    oh2 = this.f21906a.q;
                    if (oh2 != null) {
                        oh2.c();
                        oh3 = this.f21906a.q;
                        if (oh3 != null) {
                            oh3.d();
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Oh.b
    public void a(boolean z, boolean z2, int i) {
        ClipDrawable clipDrawable;
        Button button;
        ClipDrawable clipDrawable2;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        if (this.f21906a.isAdded()) {
            if (z) {
                button2 = this.f21906a.o;
                if (button2 != null) {
                    button3 = this.f21906a.o;
                    if (button3 != null) {
                        button3.setEnabled(false);
                        button4 = this.f21906a.o;
                        if (button4 != null) {
                            button4.setText(this.f21906a.getResources().getText(R.string.voicerec_btn_wait));
                            button5 = this.f21906a.o;
                            if (button5 == null) {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            button5.setTextColor(-1);
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            }
            if (!z && !z2) {
                String string = this.f21906a.getResources().getString(R.string.voicerec_btn_start);
                button = this.f21906a.o;
                if (button != null) {
                    button.postDelayed(new Dh(this, string), 500L);
                    this.f21906a.n(R.string.voicerec_desc_title_ready);
                    clipDrawable2 = this.f21906a.n;
                    if (clipDrawable2 != null) {
                        clipDrawable2.setLevel(0);
                        this.f21906a.J();
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (z || !z2 || i <= -1) {
                return;
            }
            clipDrawable = this.f21906a.n;
            if (clipDrawable != null) {
                clipDrawable.setLevel(i);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
