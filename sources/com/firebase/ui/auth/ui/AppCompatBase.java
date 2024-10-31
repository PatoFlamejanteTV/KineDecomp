package com.firebase.ui.auth.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class AppCompatBase extends HelperActivityBase {
    private View toolbarLayout;

    private void configureTheme() {
        setTheme(R.style.FirebaseUI);
        setTheme(getFlowParams().themeId);
    }

    protected View getToolbarLayout() {
        if (this.toolbarLayout == null) {
            this.toolbarLayout = findViewById(R.id.toolbar_layout);
        }
        return this.toolbarLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideSoftInput() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.HelperActivityBase, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        configureTheme();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        setTitle(getFlowParams().title);
    }

    public void setSubtitle(CharSequence charSequence) {
        View toolbarLayout = getToolbarLayout();
        if (toolbarLayout == null) {
            return;
        }
        View findViewById = toolbarLayout.findViewById(R.id.toolbar_subtitle);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(charSequence);
        }
        View findViewById2 = toolbarLayout.findViewById(R.id.toolbar_arrow);
        if (findViewById2 != null) {
            findViewById2.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        View toolbarLayout = getToolbarLayout();
        if (toolbarLayout == null) {
            super.setTitle(charSequence);
            return;
        }
        View findViewById = toolbarLayout.findViewById(R.id.toolbar_title);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(charSequence);
        }
    }
}
