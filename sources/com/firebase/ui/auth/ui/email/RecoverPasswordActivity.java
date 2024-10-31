package com.firebase.ui.auth.ui.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.firebase.ui.auth.ui.email.fieldvalidators.EmailFieldValidator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class RecoverPasswordActivity extends AppCompatBase implements View.OnClickListener {
    private static final String TAG = "RecoverPasswordActivity";
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;

    public static Intent createIntent(Context context, FlowParameters flowParameters, String str) {
        return HelperActivityBase.createBaseIntent(context, RecoverPasswordActivity.class, flowParameters).putExtra(ExtraConstants.EXTRA_EMAIL, str);
    }

    private void next(final String str) {
        getAuthHelper().getFirebaseAuth().b(str).a(new TaskFailureLogger(TAG, "Error sending password reset email")).a(new OnSuccessListener<Void>() { // from class: com.firebase.ui.auth.ui.email.RecoverPasswordActivity.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Void r2) {
                RecoverPasswordActivity.this.getDialogHolder().dismissDialog();
                RecoveryEmailSentDialog.show(str, RecoverPasswordActivity.this.getSupportFragmentManager());
            }
        }).a(this, new OnFailureListener() { // from class: com.firebase.ui.auth.ui.email.RecoverPasswordActivity.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                RecoverPasswordActivity.this.getDialogHolder().dismissDialog();
                if (exc instanceof FirebaseAuthInvalidUserException) {
                    RecoverPasswordActivity.this.mEmailEditText.setError(RecoverPasswordActivity.this.getString(R.string.error_email_does_not_exist));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_done && this.mEmailFieldValidator.validate(this.mEmailEditText.getText())) {
            getDialogHolder().showLoadingDialog(R.string.progress_dialog_sending);
            next(this.mEmailEditText.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, com.firebase.ui.auth.ui.HelperActivityBase, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.fui_forgot_password_layout);
        this.mEmailFieldValidator = new EmailFieldValidator((TextInputLayout) findViewById(R.id.email_layout));
        this.mEmailEditText = (EditText) findViewById(R.id.email);
        String stringExtra = getIntent().getStringExtra(ExtraConstants.EXTRA_EMAIL);
        if (stringExtra != null) {
            this.mEmailEditText.setText(stringExtra);
        }
        findViewById(R.id.button_done).setOnClickListener(this);
    }
}
