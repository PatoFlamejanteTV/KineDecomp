package com.firebase.ui.auth.ui.email;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentTransaction;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.email.CheckEmailFragment;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.k;
import com.nexstreaming.kinemaster.ui.gdpr.l;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class RegisterEmailActivity extends AppCompatBase implements CheckEmailFragment.CheckEmailListener {
    private static final int RC_SIGN_IN = 17;
    public static final int RC_WELCOME_BACK_IDP = 18;

    public static Intent createIntent(Context context, FlowParameters flowParameters) {
        return createIntent(context, flowParameters, null);
    }

    private void setSlideAnimation() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 17 || i == 18) {
            finish(i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.auth.ui.AppCompatBase, com.firebase.ui.auth.ui.HelperActivityBase, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_email);
        setSubtitle(getString(R.string.service_login_required));
        if (bundle != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_register_email, CheckEmailFragment.newInstance(getFlowParams(), getIntent().getExtras().getString(ExtraConstants.EXTRA_EMAIL)), CheckEmailFragment.TAG).disallowAddToBackStack().commit();
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.CheckEmailListener
    public void onExistingEmailUser(User user) {
        startActivityForResult(WelcomeBackPasswordPrompt.createIntent(this, getFlowParams(), new IdpResponse.Builder(user).build()), 17);
        setSlideAnimation();
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.CheckEmailListener
    public void onExistingIdpUser(User user) {
    }

    @Override // com.firebase.ui.auth.ui.email.CheckEmailFragment.CheckEmailListener
    public void onNewUser(final User user) {
        l.a(this, new k.b() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailActivity.1
            @Override // com.nexstreaming.kinemaster.ui.a.k.b
            public void onDialogCanceled(DialogInterface dialogInterface, DialogFragment dialogFragment) {
                RegisterEmailActivity.this.finish();
            }

            @Override // com.nexstreaming.kinemaster.ui.a.k.b
            public void onDialogOk(DialogInterface dialogInterface, DialogFragment dialogFragment) {
                TextInputLayout textInputLayout = (TextInputLayout) RegisterEmailActivity.this.findViewById(R.id.email_layout);
                if (RegisterEmailActivity.this.getFlowParams().allowNewEmailAccounts) {
                    FragmentTransaction replace = RegisterEmailActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_register_email, RegisterEmailFragment.newInstance(RegisterEmailActivity.this.getFlowParams(), user), RegisterEmailFragment.TAG);
                    if (textInputLayout != null) {
                        replace.addSharedElement(textInputLayout, "email_field");
                    }
                    replace.disallowAddToBackStack().commit();
                    return;
                }
                textInputLayout.setError(RegisterEmailActivity.this.getString(R.string.error_email_does_not_exist));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ExtraConstants.HAS_EXISTING_INSTANCE, true);
        super.onSaveInstanceState(bundle);
    }

    public static Intent createIntent(Context context, FlowParameters flowParameters, String str) {
        return HelperActivityBase.createBaseIntent(context, RegisterEmailActivity.class, flowParameters).putExtra(ExtraConstants.EXTRA_EMAIL, str);
    }
}
