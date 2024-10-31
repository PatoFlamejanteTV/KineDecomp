package com.firebase.ui.auth.ui.accountlink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.ImeHelper;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.firebase.ui.auth.ui.email.RecoverPasswordActivity;
import com.firebase.ui.auth.util.signincontainer.SaveSmartLock;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class WelcomeBackPasswordPrompt extends AppCompatBase implements View.OnClickListener, ImeHelper.DonePressedListener {
    private static final String TAG = "WelcomeBackPassword";
    private String mEmail;
    private IdpResponse mIdpResponse;
    private EditText mPasswordField;
    private TextInputLayout mPasswordLayout;
    private SaveSmartLock mSaveSmartLock;

    public static Intent createIntent(Context context, FlowParameters flowParameters, IdpResponse idpResponse) {
        return HelperActivityBase.createBaseIntent(context, WelcomeBackPasswordPrompt.class, flowParameters).putExtra(ExtraConstants.EXTRA_IDP_RESPONSE, idpResponse);
    }

    private void validateAndSignIn() {
        validateAndSignIn(this.mEmail, this.mPasswordField.getText().toString());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_done) {
            validateAndSignIn();
        } else if (id == R.id.trouble_signing_in) {
            startActivity(RecoverPasswordActivity.createIntent(this, getFlowParams(), this.mEmail));
            finish(0, IdpResponse.getErrorCodeIntent(20));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, com.firebase.ui.auth.ui.HelperActivityBase, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.fui_welcome_back_password_prompt_layout);
        setSubtitle(getString(R.string.service_login_required));
        this.mSaveSmartLock = getAuthHelper().getSaveSmartLockInstance(this);
        this.mIdpResponse = IdpResponse.fromResultIntent(getIntent());
        this.mEmail = this.mIdpResponse.getEmail();
        this.mPasswordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        this.mPasswordField = (EditText) findViewById(R.id.password);
        ImeHelper.setImeOnDoneListener(this.mPasswordField, 6, this);
        String string = getString(R.string.signin_explain, new Object[]{this.mEmail});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(this.mEmail);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.mEmail.length() + indexOf, 18);
        ((TextView) findViewById(R.id.welcome_back_password_body)).setText(spannableStringBuilder);
        findViewById(R.id.button_done).setOnClickListener(this);
        findViewById(R.id.trouble_signing_in).setOnClickListener(this);
    }

    @Override // com.firebase.ui.auth.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        hideSoftInput();
    }

    private void validateAndSignIn(String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.mPasswordLayout.setError(getString(R.string.required_field));
            return;
        }
        this.mPasswordLayout.setError(null);
        getDialogHolder().showLoadingDialog(R.string.progress_dialog_signing_in);
        final IdpResponse build = new IdpResponse.Builder(new User.Builder(AuthUI.EMAIL_PROVIDER, str).build()).build();
        getAuthHelper().getFirebaseAuth().b(str, str2).a(new OnSuccessListener<AuthResult>() { // from class: com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AuthResult authResult) {
                WelcomeBackPasswordPrompt welcomeBackPasswordPrompt = WelcomeBackPasswordPrompt.this;
                welcomeBackPasswordPrompt.saveCredentialsOrFinish(welcomeBackPasswordPrompt.mSaveSmartLock, authResult.getUser(), str2, build);
            }
        }).a(new TaskFailureLogger(TAG, "Error signing in with email and password")).a(this, new OnFailureListener() { // from class: com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt.1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                WelcomeBackPasswordPrompt.this.getDialogHolder().dismissDialog();
                WelcomeBackPasswordPrompt.this.mPasswordLayout.setError(exc.getLocalizedMessage());
            }
        });
    }
}
