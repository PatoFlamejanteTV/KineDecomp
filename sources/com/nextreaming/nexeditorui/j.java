package com.nextreaming.nexeditorui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.g;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
class j implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextView f4652a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, TextView textView) {
        this.b = iVar;
        this.f4652a = textView;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        Context context;
        String str;
        Context context2;
        Context context3;
        ColorPickerPopup.a aVar;
        ColorPickerPopup.a aVar2;
        int i2;
        context = this.b.f4651a.f4464a;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        switch (i) {
            case R.id.color_value_copy /* 2131820587 */:
                clipboardManager.setPrimaryClip(ClipData.newPlainText("Color Value", this.f4652a.getText()));
                return;
            case R.id.color_value_paste /* 2131820588 */:
                if (clipboardManager.hasPrimaryClip()) {
                    ClipData.Item itemAt = clipboardManager.getPrimaryClip().getItemAt(0);
                    if (itemAt.getText() instanceof SpannableString) {
                        str = ((SpannableString) itemAt.getText()).toString();
                    } else {
                        str = (String) itemAt.getText();
                    }
                    if (str != null) {
                        String trim = str.trim();
                        if (!trim.startsWith("#")) {
                            trim = "#" + trim;
                        }
                        try {
                            this.b.f4651a.f = Color.parseColor(trim);
                            this.b.f4651a.a(true);
                            aVar = this.b.f4651a.h;
                            if (aVar != null) {
                                aVar2 = this.b.f4651a.h;
                                i2 = this.b.f4651a.f;
                                aVar2.a(i2);
                                return;
                            }
                            return;
                        } catch (IllegalArgumentException e) {
                            context2 = this.b.f4651a.f4464a;
                            context3 = this.b.f4651a.f4464a;
                            Toast.makeText(context2, context3.getResources().getString(R.string.paste_color_fail), 1).show();
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
