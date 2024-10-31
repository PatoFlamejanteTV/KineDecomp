package com.nextreaming.nexeditorui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.widget.TextView;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import com.nextreaming.nexeditorui.ColorPickerPopup;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.j */
/* loaded from: classes.dex */
class C2314j implements PopoutListMenu.b {

    /* renamed from: a */
    final /* synthetic */ TextView f24300a;

    /* renamed from: b */
    final /* synthetic */ ViewOnLongClickListenerC2318l f24301b;

    public C2314j(ViewOnLongClickListenerC2318l viewOnLongClickListenerC2318l, TextView textView) {
        this.f24301b = viewOnLongClickListenerC2318l;
        this.f24300a = textView;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutListMenu.b
    public void a(PopoutListMenu popoutListMenu, int i) {
        Context context;
        String str;
        Context context2;
        Context context3;
        ColorPickerPopup.a aVar;
        ColorPickerPopup.a aVar2;
        int i2;
        context = this.f24301b.f24311a.f23993c;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        switch (i) {
            case R.id.color_value_copy /* 2131362456 */:
                clipboardManager.setPrimaryClip(ClipData.newPlainText("Color Value", this.f24300a.getText()));
                return;
            case R.id.color_value_paste /* 2131362457 */:
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
                            this.f24301b.f24311a.f23998h = Color.parseColor(trim);
                            this.f24301b.f24311a.a(true);
                            aVar = this.f24301b.f24311a.j;
                            if (aVar != null) {
                                aVar2 = this.f24301b.f24311a.j;
                                i2 = this.f24301b.f24311a.f23998h;
                                aVar2.a(i2);
                                return;
                            }
                            return;
                        } catch (IllegalArgumentException unused) {
                            context2 = this.f24301b.f24311a.f23993c;
                            context3 = this.f24301b.f24311a.f23993c;
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
