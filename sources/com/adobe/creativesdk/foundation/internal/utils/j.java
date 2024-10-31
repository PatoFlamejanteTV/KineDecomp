package com.adobe.creativesdk.foundation.internal.utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: AdobeDialogFragment.java */
/* loaded from: classes.dex */
public class j extends DialogFragment {

    /* renamed from: a */
    protected TextView f6858a;

    /* renamed from: b */
    protected TextView f6859b;

    /* renamed from: c */
    protected EditText f6860c;

    /* renamed from: d */
    private LinearLayout f6861d;

    /* renamed from: e */
    private TextView f6862e;

    /* renamed from: h */
    private String f6865h;
    private String i;
    private String j;
    private String k;

    /* renamed from: f */
    private boolean f6863f = false;

    /* renamed from: g */
    private boolean f6864g = false;
    private String l = null;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdobeDialogFragment.java */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            j.this.a(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.J();
            j.this.H();
        }
    }

    public void J() {
        if (E() != null && E().trim().length() > 0) {
            EditText editText = this.f6860c;
            if (editText != null) {
                editText.setBackgroundResource(com.adobe.creativesdk.foundation.auth.o.adobe_csdk_edittext_background_with_text);
                return;
            }
            return;
        }
        EditText editText2 = this.f6860c;
        if (editText2 != null) {
            editText2.setBackgroundResource(com.adobe.creativesdk.foundation.auth.o.adobe_csdk_edittext_background);
        }
    }

    public void A() {
        this.f6864g = false;
        TextView textView = this.f6858a;
        if (textView != null) {
            textView.setEnabled(false);
        }
    }

    public void B() {
        InputMethodManager inputMethodManager;
        EditText editText;
        if (getActivity() == null || (inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method")) == null || (editText = this.f6860c) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void C() {
        TextView textView = this.f6859b;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    public void D() {
        this.f6864g = true;
        TextView textView = this.f6858a;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    public String E() {
        EditText editText = this.f6860c;
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public void F() {
        throw null;
    }

    public void G() {
        throw null;
    }

    public void H() {
        throw null;
    }

    public void I() {
        this.f6861d.setVisibility(8);
    }

    public void a(Editable editable) {
        throw null;
    }

    public void d(String str) {
        A();
        this.f6862e.setText(str);
        this.f6861d.setVisibility(0);
    }

    public void f(String str) {
        this.f6865h = str;
    }

    public void g(String str) {
        this.l = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.j = str;
    }

    public void j(String str) {
        this.i = str;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        setStyle(0, com.adobe.creativesdk.foundation.auth.s.AdobeCSDKDialogWithTitle);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_common_dialog_fragment, viewGroup);
        this.f6858a = (TextView) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_generic_dialog_fragment_postive_button);
        this.f6858a.setOnClickListener(new e(this));
        this.f6859b = (TextView) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_generic_dialog_fragment_negative_button);
        this.f6859b.setOnClickListener(new f(this));
        this.f6860c = (EditText) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_generic_dialog_fragment_edit_text);
        this.f6861d = (LinearLayout) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_generic_dialog_fragment_error_container);
        this.f6862e = (TextView) inflate.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_generic_dialog_fragment_error_text);
        this.f6860c.addTextChangedListener(new a());
        A();
        this.f6860c.setOnFocusChangeListener(new h(this));
        this.f6860c.setOnKeyListener(new i(this));
        this.f6858a.setText(this.i);
        this.f6859b.setText(this.j);
        this.f6860c.setHint(this.k);
        this.f6860c.setSingleLine(this.m);
        String str = this.l;
        if (str != null) {
            this.f6860c.setText(str);
            this.f6860c.setSelection(this.l.length());
        }
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        SpannableString spannableString = new SpannableString(this.f6865h);
        spannableString.setSpan(new d(null, c.a(getActivity())), 0, spannableString.length(), 18);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(com.adobe.creativesdk.foundation.auth.m.adobe_csdk_asset_browser_dark_text)), 0, spannableString.length(), 18);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 18);
        getDialog().setTitle(spannableString);
        Dialog dialog = getDialog();
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById == null) {
            findViewById = dialog.findViewById(getResources().getIdentifier("titleDivider", "id", "android"));
        }
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(com.adobe.creativesdk.foundation.auth.m.adobe_csdk_actionbar_background_color);
        }
        if (findViewById != null) {
            findViewById.setBackgroundColor(getResources().getColor(com.adobe.creativesdk.foundation.auth.m.adobe_csdk_actionbar_background_color));
        }
    }

    public void z() {
        TextView textView = this.f6859b;
        if (textView != null) {
            textView.setEnabled(false);
        }
    }
}
