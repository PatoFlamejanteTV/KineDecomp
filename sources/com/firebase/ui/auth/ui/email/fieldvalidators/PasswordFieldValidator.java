package com.firebase.ui.auth.ui.email.fieldvalidators;

import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class PasswordFieldValidator extends BaseValidator {
    private int mMinLength;

    public PasswordFieldValidator(TextInputLayout textInputLayout, int i) {
        super(textInputLayout);
        this.mMinLength = i;
        Resources resources = this.mErrorContainer.getResources();
        int i2 = this.mMinLength;
        this.mErrorMessage = resources.getQuantityString(R.plurals.error_weak_password, i2, Integer.valueOf(i2));
    }

    @Override // com.firebase.ui.auth.ui.email.fieldvalidators.BaseValidator
    protected boolean isValid(CharSequence charSequence) {
        return charSequence.length() >= this.mMinLength;
    }
}
