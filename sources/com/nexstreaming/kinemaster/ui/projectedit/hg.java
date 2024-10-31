package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.os.Looper;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.ReverseController;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* compiled from: ReverseController.kt */
/* loaded from: classes2.dex */
public final class Hg implements NexEditor.s {

    /* renamed from: a */
    final /* synthetic */ ReverseController f21894a;

    public Hg(ReverseController reverseController) {
        this.f21894a = reverseController;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.s
    public void a(int i, int i2, int i3) {
        com.nexstreaming.kinemaster.ui.a.p pVar;
        pVar = this.f21894a.f22058c;
        if (pVar != null) {
            pVar.g(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.s
    public void a(NexEditor.b bVar, int i) {
        long j;
        com.nexstreaming.kinemaster.ui.a.p pVar;
        com.nexstreaming.kinemaster.ui.a.p pVar2;
        com.nexstreaming.kinemaster.ui.a.p pVar3;
        com.nexstreaming.kinemaster.ui.a.p pVar4;
        com.nexstreaming.kinemaster.ui.a.p pVar5;
        com.nexstreaming.kinemaster.ui.a.p pVar6;
        com.nexstreaming.kinemaster.ui.a.p pVar7;
        com.nexstreaming.kinemaster.ui.a.p pVar8;
        com.nexstreaming.kinemaster.ui.a.p pVar9;
        com.nexstreaming.kinemaster.ui.a.p pVar10;
        com.nexstreaming.kinemaster.ui.a.p pVar11;
        com.nexstreaming.kinemaster.ui.a.p pVar12;
        com.nexstreaming.kinemaster.ui.a.p pVar13;
        com.nexstreaming.kinemaster.ui.a.p pVar14;
        com.nexstreaming.kinemaster.ui.a.p pVar15;
        com.nexstreaming.kinemaster.ui.a.p pVar16;
        kotlin.jvm.internal.h.b(bVar, "result");
        ReverseController reverseController = this.f21894a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f21894a.f22059d;
        reverseController.f22059d = currentTimeMillis - j;
        String h2 = this.f21894a.h();
        if (h2 != null) {
            File file = new File(h2);
            if (file.exists()) {
                file.delete();
            }
            if (bVar == NexEditor.b.E) {
                pVar14 = this.f21894a.f22058c;
                if (pVar14 != null) {
                    String string = this.f21894a.a().getString(R.string.reverse_dialog_message_interrupt_error);
                    kotlin.jvm.internal.h.a((Object) string, "context.getString(R.stri…_message_interrupt_error)");
                    pVar14.e(string);
                    pVar15 = this.f21894a.f22058c;
                    if (pVar15 != null) {
                        pVar15.f(0);
                        pVar16 = this.f21894a.f22058c;
                        if (pVar16 != null) {
                            pVar16.k(4);
                            this.f21894a.e().a(ReverseController.ReverseResult.RESULT_ERROR_ENGINE_BUSY, null);
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (bVar == NexEditor.b.N) {
                File file2 = new File(this.f21894a.b() + ".tmp");
                if (file2.exists()) {
                    file2.delete();
                }
                this.f21894a.e().a(ReverseController.ReverseResult.RESULT_CANCEL, null);
                pVar13 = this.f21894a.f22058c;
                if (pVar13 != null) {
                    pVar13.dismiss();
                    return;
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            if (bVar.c()) {
                pVar10 = this.f21894a.f22058c;
                if (pVar10 != null) {
                    String string2 = this.f21894a.a().getString(R.string.reverse_dialog_message_interrupt_error);
                    kotlin.jvm.internal.h.a((Object) string2, "context.getString(R.stri…_message_interrupt_error)");
                    pVar10.e(string2);
                    pVar11 = this.f21894a.f22058c;
                    if (pVar11 != null) {
                        pVar11.f(0);
                        pVar12 = this.f21894a.f22058c;
                        if (pVar12 != null) {
                            pVar12.k(4);
                            this.f21894a.e().a(ReverseController.ReverseResult.RESULT_ERROR_UNKNOWN, null);
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            pVar = this.f21894a.f22058c;
            if (pVar != null) {
                String string3 = this.f21894a.a().getString(R.string.reverse_dialog_message_done);
                kotlin.jvm.internal.h.a((Object) string3, "context.getString(R.stri…erse_dialog_message_done)");
                pVar.e(string3);
                File file3 = new File(this.f21894a.b() + ".tmp");
                if (!file3.exists()) {
                    pVar2 = this.f21894a.f22058c;
                    if (pVar2 != null) {
                        String string4 = this.f21894a.a().getString(R.string.reverse_dialog_message_interrupt_error);
                        kotlin.jvm.internal.h.a((Object) string4, "context.getString(R.stri…_message_interrupt_error)");
                        pVar2.e(string4);
                        pVar3 = this.f21894a.f22058c;
                        if (pVar3 != null) {
                            pVar3.f(0);
                            pVar4 = this.f21894a.f22058c;
                            if (pVar4 != null) {
                                pVar4.k(4);
                                this.f21894a.e().a(ReverseController.ReverseResult.RESULT_ERROR_UNKNOWN, null);
                                return;
                            } else {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                file3.renameTo(new File(this.f21894a.b()));
                this.f21894a.e().a(ReverseController.ReverseResult.RESULT_OK, new File(this.f21894a.b()));
                pVar5 = this.f21894a.f22058c;
                if (pVar5 != null) {
                    String string5 = this.f21894a.a().getString(R.string.reverse_dialog_title_complete);
                    kotlin.jvm.internal.h.a((Object) string5, "context.getString(R.stri…se_dialog_title_complete)");
                    pVar5.c(string5);
                    pVar6 = this.f21894a.f22058c;
                    if (pVar6 != null) {
                        String string6 = this.f21894a.a().getString(R.string.reverse_dialog_message_done);
                        kotlin.jvm.internal.h.a((Object) string6, "context.getString(R.stri…erse_dialog_message_done)");
                        pVar6.e(string6);
                        pVar7 = this.f21894a.f22058c;
                        if (pVar7 != null) {
                            pVar7.c(4);
                            pVar8 = this.f21894a.f22058c;
                            if (pVar8 != null) {
                                pVar8.f(4);
                                pVar9 = this.f21894a.f22058c;
                                if (pVar9 != null) {
                                    pVar9.k(4);
                                    new Handler(Looper.getMainLooper()).postDelayed(new Gg(this), 750L);
                                    return;
                                } else {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                            }
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
