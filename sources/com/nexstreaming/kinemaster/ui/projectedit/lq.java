package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* loaded from: classes.dex */
class lq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4071a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ lo d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lq(lo loVar, Intent intent, int i, int i2) {
        this.d = loVar;
        this.f4071a = intent;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextLayer H;
        TextLayer H2;
        TextLayer H3;
        TextLayer H4;
        TextLayer H5;
        TextLayer H6;
        TextLayer H7;
        TextLayer H8;
        if (this.f4071a != null && this.b == FullScreenInputActivity.a()) {
            String stringExtra = this.f4071a.getStringExtra("text");
            if (stringExtra != null) {
                stringExtra = lo.a(stringExtra);
            }
            if (stringExtra != null && !stringExtra.equals("") && !stringExtra.trim().equals("")) {
                H6 = this.d.H();
                if (H6 != null) {
                    H7 = this.d.H();
                    if (!stringExtra.equals(H7.getText())) {
                        H8 = this.d.H();
                        H8.setText(stringExtra);
                        this.d.d();
                        this.d.o().a(NexEditor.FastPreviewOption.normal, 0, true);
                    } else {
                        this.d.b(OptionTabFragment.TabId.ItemOptionTab);
                        this.d.o = true;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                this.d.b(OptionTabFragment.TabId.ItemOptionTab);
                return;
            }
        } else if (this.f4071a != null && this.b == 100 && this.c == -1) {
            H3 = this.d.H();
            if (H3 != null) {
                String stringExtra2 = this.f4071a.getStringExtra("selected_font_id");
                if (stringExtra2 != null) {
                    H4 = this.d.H();
                    if (!stringExtra2.equals(H4.getFontId())) {
                        H5 = this.d.H();
                        H5.setFontId(stringExtra2);
                        this.d.d();
                    }
                }
            } else {
                return;
            }
        } else if (this.f4071a != null && this.b == 100 && this.c == 1) {
            H = this.d.H();
            if (H != null) {
                H2 = this.d.H();
                H2.setFontId(null);
                this.d.d();
            } else {
                return;
            }
        }
        this.d.o = true;
        this.d.b(OptionTabFragment.TabId.ItemOptionTab);
        this.d.a(OptionTabFragment.TabId.ItemOptionTab);
    }
}
