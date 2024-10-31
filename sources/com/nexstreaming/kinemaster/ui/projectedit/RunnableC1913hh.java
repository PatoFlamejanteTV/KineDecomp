package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1913hh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f22372a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f22373b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f22374c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C1939kh f22375d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1913hh(C1939kh c1939kh, Intent intent, int i, int i2) {
        this.f22375d = c1939kh;
        this.f22372a = intent;
        this.f22373b = i;
        this.f22374c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextLayer Aa;
        TextLayer Aa2;
        TextLayer Aa3;
        TextLayer Aa4;
        TextLayer Aa5;
        TextLayer Aa6;
        TextLayer Aa7;
        TextLayer Aa8;
        if (this.f22372a != null && this.f22373b == FullScreenInputActivity.s()) {
            String stringExtra = this.f22372a.getStringExtra("text");
            if (stringExtra != null) {
                stringExtra = C1939kh.h(stringExtra);
            }
            if (stringExtra != null && !stringExtra.equals("") && !stringExtra.trim().equals("")) {
                Aa6 = this.f22375d.Aa();
                if (Aa6 == null) {
                    return;
                }
                Aa7 = this.f22375d.Aa();
                if (!stringExtra.equals(Aa7.getText())) {
                    Aa8 = this.f22375d.Aa();
                    Aa8.setText(stringExtra);
                    this.f22375d.G();
                    this.f22375d.da().a(NexEditor.FastPreviewOption.normal, 0, true);
                } else {
                    this.f22375d.d(OptionTabFragment.TabId.ItemOptionTab);
                    this.f22375d.T = true;
                    this.f22375d.Q().requestLayout();
                    return;
                }
            } else {
                this.f22375d.d(OptionTabFragment.TabId.ItemOptionTab);
                this.f22375d.T = true;
                this.f22375d.Q().requestLayout();
                return;
            }
        } else if (this.f22372a != null && this.f22373b == 100 && this.f22374c == -1) {
            Aa3 = this.f22375d.Aa();
            if (Aa3 == null) {
                return;
            }
            String stringExtra2 = this.f22372a.getStringExtra("selected_font_id");
            if (stringExtra2 != null) {
                Aa4 = this.f22375d.Aa();
                if (!stringExtra2.equals(Aa4.getFontId())) {
                    Aa5 = this.f22375d.Aa();
                    Aa5.setFontId(stringExtra2);
                    this.f22375d.G();
                }
            }
        } else if (this.f22372a != null && this.f22373b == 100 && this.f22374c == 1) {
            Aa = this.f22375d.Aa();
            if (Aa == null) {
                return;
            }
            Aa2 = this.f22375d.Aa();
            Aa2.setFontId(null);
            this.f22375d.G();
        }
        this.f22375d.T = true;
        this.f22375d.Q().requestLayout();
        this.f22375d.d(OptionTabFragment.TabId.ItemOptionTab);
        this.f22375d.c(OptionTabFragment.TabId.ItemOptionTab);
    }
}
