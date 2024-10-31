package com.firebase.ui.auth.ui.email.fieldvalidators;

import android.support.design.widget.TextInputLayout;

/* loaded from: classes.dex */
public class BaseValidator {
    protected String mEmptyMessage;
    protected TextInputLayout mErrorContainer;
    protected String mErrorMessage = "";

    public BaseValidator(TextInputLayout textInputLayout) {
        this.mErrorContainer = textInputLayout;
    }

    protected boolean isValid(CharSequence charSequence) {
        return true;
    }

    public boolean validate(CharSequence charSequence) {
        if (this.mEmptyMessage != null && (charSequence == null || charSequence.length() == 0)) {
            this.mErrorContainer.setError(this.mEmptyMessage);
            return false;
        }
        if (isValid(charSequence)) {
            this.mErrorContainer.setError("");
            return true;
        }
        this.mErrorContainer.setError(this.mErrorMessage);
        return false;
    }
}
