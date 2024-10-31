package com.nextreaming.nexeditorui;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorPickerPopup.java */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorPickerPopup f4651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ColorPickerPopup colorPickerPopup) {
        this.f4651a = colorPickerPopup;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        Context context3;
        TextView textView = (TextView) view;
        context = this.f4651a.f4464a;
        textView.setBackgroundColor(context.getResources().getColor(R.color.color_value_bg));
        context2 = this.f4651a.f4464a;
        ClipboardManager clipboardManager = (ClipboardManager) context2.getSystemService("clipboard");
        context3 = this.f4651a.f4464a;
        com.nexstreaming.kinemaster.ui.widget.g gVar = new com.nexstreaming.kinemaster.ui.widget.g(context3);
        gVar.a(R.id.color_value_copy, R.string.color_value_copy);
        if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemAt(0).getText() != null) {
            gVar.a(R.id.color_value_paste, R.string.color_value_paste);
        }
        gVar.a(view, 21);
        gVar.a(new j(this, textView));
        gVar.a(new k(this, textView));
        return false;
    }
}
