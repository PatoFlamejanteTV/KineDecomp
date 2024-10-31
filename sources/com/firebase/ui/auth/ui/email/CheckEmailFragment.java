package com.firebase.ui.auth.ui.email;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.provider.ProviderUtils;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.ImeHelper;
import com.firebase.ui.auth.ui.email.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.util.GoogleApiHelper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class CheckEmailFragment extends FragmentBase implements View.OnClickListener, ImeHelper.DonePressedListener {
    private static final int RC_HINT = 13;
    private static final int RC_SIGN_IN = 16;
    private static final int RC_WELCOME_BACK_IDP = 15;
    public static final String TAG = "CheckEmailFragment";
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailLayout;
    private Credential mLastCredential;
    private CheckEmailListener mListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface CheckEmailListener {
        void onExistingEmailUser(User user);

        void onExistingIdpUser(User user);

        void onNewUser(User user);
    }

    private void checkAccountExists(final String str) {
        final Uri uri;
        getDialogHolder().showLoadingDialog(R.string.progress_dialog_checking_accounts);
        Credential credential = this.mLastCredential;
        final String str2 = null;
        if (credential == null || !credential.getId().equals(str)) {
            uri = null;
        } else {
            str2 = this.mLastCredential.R();
            uri = this.mLastCredential.U();
        }
        ProviderUtils.fetchTopProvider(getAuthHelper().getFirebaseAuth(), str).a(getActivity(), new OnSuccessListener<String>() { // from class: com.firebase.ui.auth.ui.email.CheckEmailFragment.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(String str3) {
                if (str3 == null) {
                    CheckEmailFragment.this.mListener.onNewUser(new User.Builder(AuthUI.EMAIL_PROVIDER, str).setName(str2).setPhotoUri(uri).build());
                } else if (!AuthUI.EMAIL_PROVIDER.equalsIgnoreCase(str3)) {
                    CheckEmailFragment.this.mListener.onExistingIdpUser(new User.Builder(str3, str).build());
                } else {
                    CheckEmailFragment.this.mListener.onExistingEmailUser(new User.Builder(AuthUI.EMAIL_PROVIDER, str).build());
                }
            }
        }).a(getActivity(), new OnCompleteListener<String>() { // from class: com.firebase.ui.auth.ui.email.CheckEmailFragment.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                CheckEmailFragment.this.getDialogHolder().dismissDialog();
            }
        });
    }

    private PendingIntent getEmailHintIntent() {
        return Auth.i.getHintPickerIntent(new GoogleApiClient.Builder(getContext()).a(Auth.f10422f).a(getActivity(), GoogleApiHelper.getSafeAutoManageId(), new GoogleApiClient.OnConnectionFailedListener() { // from class: com.firebase.ui.auth.ui.email.CheckEmailFragment.3
            @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
            public void onConnectionFailed(ConnectionResult connectionResult) {
                Log.e(CheckEmailFragment.TAG, "Client connection failed: " + connectionResult.O());
            }
        }).a(), new HintRequest.Builder().a(new CredentialPickerConfig.Builder().a(true).a()).a(true).a());
    }

    public static CheckEmailFragment newInstance(FlowParameters flowParameters, String str) {
        CheckEmailFragment checkEmailFragment = new CheckEmailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ExtraConstants.EXTRA_FLOW_PARAMS, flowParameters);
        bundle.putString(ExtraConstants.EXTRA_EMAIL, str);
        checkEmailFragment.setArguments(bundle);
        return checkEmailFragment;
    }

    private void showEmailAutoCompleteHint() {
        try {
            startIntentSenderForResult(getEmailHintIntent().getIntentSender(), 13);
        } catch (IntentSender.SendIntentException e2) {
            Log.e(TAG, "Unable to start hint intent", e2);
        }
    }

    private void validateAndProceed() {
        String obj = this.mEmailEditText.getText().toString();
        if (this.mEmailFieldValidator.validate(obj)) {
            checkAccountExists(obj);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof CheckEmailListener) {
            this.mListener = (CheckEmailListener) getActivity();
            if (bundle != null) {
                return;
            }
            String string = getArguments().getString(ExtraConstants.EXTRA_EMAIL);
            if (!TextUtils.isEmpty(string)) {
                this.mEmailEditText.setText(string);
                validateAndProceed();
                return;
            } else {
                if (getFlowParams().enableHints) {
                    showEmailAutoCompleteHint();
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 13) {
            if (i == 15 || i == 16) {
                finish(i2, intent);
                return;
            }
            return;
        }
        if (intent != null) {
            this.mLastCredential = (Credential) intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
            Credential credential = this.mLastCredential;
            if (credential != null) {
                this.mEmailEditText.setText(credential.getId());
                validateAndProceed();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_next) {
            validateAndProceed();
        } else if (id == R.id.email_layout || id == R.id.email) {
            this.mEmailLayout.setError(null);
        }
    }

    @Override // android.support.v4.app.Fragment
    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b.a(CheckEmailFragment.class.getName());
        View inflate = layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
        this.mEmailLayout = (TextInputLayout) inflate.findViewById(R.id.email_layout);
        this.mEmailEditText = (EditText) inflate.findViewById(R.id.email);
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailLayout);
        this.mEmailLayout.setOnClickListener(this);
        this.mEmailEditText.setOnClickListener(this);
        ImeHelper.setImeOnDoneListener(this.mEmailEditText, 5, this);
        if (Build.VERSION.SDK_INT >= 26 && getFlowParams().enableHints) {
            this.mEmailEditText.setImportantForAutofill(2);
        }
        inflate.findViewById(R.id.button_next).setOnClickListener(this);
        return inflate;
    }

    @Override // com.firebase.ui.auth.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        hideSoftInput();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ExtraConstants.HAS_EXISTING_INSTANCE, true);
        super.onSaveInstanceState(bundle);
    }
}
