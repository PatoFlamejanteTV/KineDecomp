package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.ReverseController;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexvideoeditor.NexClipInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ReverseController.kt */
/* loaded from: classes2.dex */
public final class Ig implements ReverseController.a.InterfaceC0115a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ReverseController f21905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ig(ReverseController reverseController) {
        this.f21905a = reverseController;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ReverseController.a.InterfaceC0115a
    public void a(NexClipInfo nexClipInfo, int i) {
        com.nexstreaming.kinemaster.ui.a.p pVar;
        com.nexstreaming.kinemaster.ui.a.p pVar2;
        com.nexstreaming.kinemaster.ui.a.p pVar3;
        com.nexstreaming.kinemaster.ui.a.p pVar4;
        com.nexstreaming.kinemaster.ui.a.p pVar5;
        NexEditor i2;
        com.nexstreaming.kinemaster.ui.a.p pVar6;
        NexEditor i3;
        Hg hg;
        NexEditor i4;
        NexEditor i5;
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
        com.nexstreaming.kinemaster.ui.a.p pVar17;
        if (nexClipInfo != null && i != 0) {
            double c2 = ((this.f21905a.c() - this.f21905a.g()) / 1000) * (nexClipInfo.mVideoBitRate / 8);
            Double.isNaN(c2);
            double d2 = this.f21905a.d();
            double d3 = i;
            Double.isNaN(d3);
            if (d2 < d3 + (c2 * 1.2d)) {
                pVar14 = this.f21905a.f22058c;
                if (pVar14 != null) {
                    String string = this.f21905a.a().getString(R.string.reverse_dialog_message_stroage_error);
                    kotlin.jvm.internal.h.a((Object) string, "context.getString(R.stri…og_message_stroage_error)");
                    pVar14.e(string);
                    pVar15 = this.f21905a.f22058c;
                    if (pVar15 != null) {
                        pVar15.f(0);
                        pVar16 = this.f21905a.f22058c;
                        if (pVar16 != null) {
                            pVar16.k(4);
                            pVar17 = this.f21905a.f22058c;
                            if (pVar17 != null) {
                                pVar17.e(4);
                                this.f21905a.e().a(ReverseController.ReverseResult.RESULT_NO_SPACE, null);
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
            i2 = this.f21905a.i();
            if (i2.l()) {
                pVar11 = this.f21905a.f22058c;
                if (pVar11 != null) {
                    String string2 = this.f21905a.a().getString(R.string.reverse_dialog_message_prepare_error);
                    kotlin.jvm.internal.h.a((Object) string2, "context.getString(R.stri…og_message_prepare_error)");
                    pVar11.e(string2);
                    pVar12 = this.f21905a.f22058c;
                    if (pVar12 != null) {
                        pVar12.f(0);
                        pVar13 = this.f21905a.f22058c;
                        if (pVar13 != null) {
                            pVar13.k(4);
                            this.f21905a.e().a(ReverseController.ReverseResult.RESULT_ERROR_UNKNOWN, null);
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
            pVar6 = this.f21905a.f22058c;
            if (pVar6 != null) {
                pVar6.g(0);
                i3 = this.f21905a.i();
                hg = this.f21905a.f22060e;
                i3.a(hg);
                int i6 = nexClipInfo.mVideoWidth;
                int i7 = nexClipInfo.mVideoHeight;
                int i8 = nexClipInfo.mAudioBitRate;
                NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
                i4 = this.f21905a.i();
                int maxExportHeight = deviceProfile.getMaxExportHeight(i4.b());
                int i9 = i6;
                int i10 = i7;
                while (i9 * i10 > ((maxExportHeight * 16) / 9) * maxExportHeight) {
                    i9 /= 2;
                    i10 /= 2;
                    i8 /= 2;
                }
                i5 = this.f21905a.i();
                NexEditor.b a2 = i5.a(this.f21905a.f(), this.f21905a.b() + ".tmp", this.f21905a.h(), i9, i10, nexClipInfo.mVideoBitRate, this.f21905a.d(), this.f21905a.g(), this.f21905a.c());
                kotlin.jvm.internal.h.a((Object) a2, "result");
                if (a2.c()) {
                    pVar8 = this.f21905a.f22058c;
                    if (pVar8 != null) {
                        String string3 = this.f21905a.a().getString(R.string.reverse_dialog_message_prepare_error);
                        kotlin.jvm.internal.h.a((Object) string3, "context.getString(R.stri…og_message_prepare_error)");
                        pVar8.e(string3);
                        pVar9 = this.f21905a.f22058c;
                        if (pVar9 != null) {
                            pVar9.f(0);
                            pVar10 = this.f21905a.f22058c;
                            if (pVar10 != null) {
                                pVar10.k(4);
                                this.f21905a.e().a(ReverseController.ReverseResult.RESULT_ERROR_UNKNOWN, null);
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
                pVar7 = this.f21905a.f22058c;
                if (pVar7 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                String string4 = this.f21905a.a().getString(R.string.reverse_dialog_message_doing);
                kotlin.jvm.internal.h.a((Object) string4, "context.getString(R.stri…rse_dialog_message_doing)");
                pVar7.e(string4);
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (this.f21905a.c() - this.f21905a.g() < 1000) {
            pVar5 = this.f21905a.f22058c;
            if (pVar5 != null) {
                String string5 = this.f21905a.a().getString(R.string.reverse_dialog_message_too_short_error);
                kotlin.jvm.internal.h.a((Object) string5, "context.getString(R.stri…_message_too_short_error)");
                pVar5.e(string5);
                this.f21905a.e().a(ReverseController.ReverseResult.RESULT_UNSUPPORT_DURATION, null);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        } else {
            pVar = this.f21905a.f22058c;
            if (pVar != null) {
                String string6 = this.f21905a.a().getString(R.string.reverse_dialog_message_prepare_error);
                kotlin.jvm.internal.h.a((Object) string6, "context.getString(R.stri…og_message_prepare_error)");
                pVar.e(string6);
                this.f21905a.e().a(ReverseController.ReverseResult.RESULT_CLIP_INFO_ERROR, null);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
        pVar2 = this.f21905a.f22058c;
        if (pVar2 != null) {
            pVar2.f(0);
            pVar3 = this.f21905a.f22058c;
            if (pVar3 != null) {
                pVar3.k(4);
                pVar4 = this.f21905a.f22058c;
                if (pVar4 != null) {
                    pVar4.e(4);
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
}
