package com.nextreaming.nexeditorui;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;

/* compiled from: ColorPickerPopup.java */
/* renamed from: com.nextreaming.nexeditorui.l */
/* loaded from: classes.dex */
public class ViewOnLongClickListenerC2318l implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ColorPickerPopup f24311a;

    public ViewOnLongClickListenerC2318l(ColorPickerPopup colorPickerPopup) {
        this.f24311a = colorPickerPopup;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        Context context3;
        TextView textView = (TextView) view;
        context = this.f24311a.f23993c;
        textView.setBackgroundColor(context.getResources().getColor(R.color.color_value_bg));
        context2 = this.f24311a.f23993c;
        ClipboardManager clipboardManager = (ClipboardManager) context2.getSystemService("clipboard");
        context3 = this.f24311a.f23993c;
        PopoutListMenu popoutListMenu = new PopoutListMenu(context3);
        popoutListMenu.a(R.id.color_value_copy, R.string.color_value_copy);
        if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemAt(0).getText() != null) {
            popoutListMenu.a(R.id.color_value_paste, R.string.color_value_paste);
        }
        popoutListMenu.a(view, 21);
        popoutListMenu.a(new C2314j(this, textView));
        popoutListMenu.a(new C2316k(this, textView));
        return false;
    }
}
