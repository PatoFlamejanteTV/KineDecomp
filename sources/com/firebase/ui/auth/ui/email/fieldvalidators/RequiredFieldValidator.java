package com.firebase.ui.auth.ui.email.fieldvalidators;

import android.support.design.widget.TextInputLayout;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class RequiredFieldValidator extends BaseValidator {
    public RequiredFieldValidator(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.mErrorMessage = this.mErrorContainer.getResources().getString(R.string.required_field);
    }

    @Override // com.firebase.ui.auth.ui.email.fieldvalidators.BaseValidator
    protected boolean isValid(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }
}
