package com.firebase.ui.auth.ui.email.fieldvalidators;

import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class EmailFieldValidator extends BaseValidator {
    public EmailFieldValidator(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.mErrorMessage = this.mErrorContainer.getResources().getString(R.string.invalid_email_address);
        this.mEmptyMessage = this.mErrorContainer.getResources().getString(R.string.missing_email_address);
    }

    @Override // com.firebase.ui.auth.ui.email.fieldvalidators.BaseValidator
    protected boolean isValid(CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
