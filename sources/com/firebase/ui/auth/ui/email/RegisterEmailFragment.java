package com.firebase.ui.auth.ui.email;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.provider.ProviderUtils;
import com.firebase.ui.auth.ui.AppCompatBase;
import com.firebase.ui.auth.ui.ExtraConstants;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.ImeHelper;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.firebase.ui.auth.ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.ui.auth.ui.email.fieldvalidators.EmailFieldValidator;
import com.firebase.ui.auth.ui.email.fieldvalidators.PasswordFieldValidator;
import com.firebase.ui.auth.ui.email.fieldvalidators.RequiredFieldValidator;
import com.firebase.ui.auth.util.accountlink.ProfileMerger;
import com.firebase.ui.auth.util.signincontainer.SaveSmartLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.b;

/* loaded from: classes.dex */
public class RegisterEmailFragment extends FragmentBase implements View.OnClickListener, View.OnFocusChangeListener, ImeHelper.DonePressedListener {
    public static final String TAG = "RegisterEmailFragment";
    private HelperActivityBase mActivity;
    private TextView mAgreementText;
    private EditText mEmailEditText;
    private EmailFieldValidator mEmailFieldValidator;
    private TextInputLayout mEmailInput;
    private EditText mNameEditText;
    private RequiredFieldValidator mNameValidator;
    private EditText mPasswordEditText;
    private PasswordFieldValidator mPasswordFieldValidator;
    private TextInputLayout mPasswordInput;
    private SaveSmartLock mSaveSmartLock;
    private ScrollView mScroller;
    private User mUser;

    public static RegisterEmailFragment newInstance(FlowParameters flowParameters, User user) {
        RegisterEmailFragment registerEmailFragment = new RegisterEmailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ExtraConstants.EXTRA_FLOW_PARAMS, flowParameters);
        bundle.putSerializable(ExtraConstants.EXTRA_USER, user);
        registerEmailFragment.setArguments(bundle);
        return registerEmailFragment;
    }

    private void registerUser(final String str, String str2, final String str3) {
        final IdpResponse build = new IdpResponse.Builder(new User.Builder(AuthUI.EMAIL_PROVIDER, str).setName(str2).setPhotoUri(this.mUser.getPhotoUri()).build()).build();
        getAuthHelper().getFirebaseAuth().a(str, str3).b(new ProfileMerger(build)).a(new TaskFailureLogger(TAG, "Error creating user")).a(getActivity(), new OnSuccessListener<AuthResult>() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailFragment.3
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AuthResult authResult) {
                RegisterEmailFragment.this.mActivity.saveCredentialsOrFinish(RegisterEmailFragment.this.mSaveSmartLock, authResult.getUser(), str3, build);
            }
        }).a(getActivity(), new OnFailureListener() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailFragment.2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                if (exc instanceof FirebaseAuthWeakPasswordException) {
                    RegisterEmailFragment.this.mPasswordInput.setError(RegisterEmailFragment.this.getResources().getQuantityString(R.plurals.error_weak_password, R.integer.fui_min_password_length));
                } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
                    RegisterEmailFragment.this.mEmailInput.setError(RegisterEmailFragment.this.getString(R.string.invalid_email_address));
                } else if (!(exc instanceof FirebaseAuthUserCollisionException)) {
                    RegisterEmailFragment.this.mEmailInput.setError(RegisterEmailFragment.this.getString(R.string.email_account_creation_error));
                } else {
                    ProviderUtils.fetchTopProvider(RegisterEmailFragment.this.getAuthHelper().getFirebaseAuth(), str).a(RegisterEmailFragment.this.getActivity(), new OnSuccessListener<String>() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailFragment.2.2
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public void onSuccess(String str4) {
                            Toast.makeText(RegisterEmailFragment.this.getContext(), R.string.error_user_collision, 1).show();
                            if (str4 != null) {
                                if (AuthUI.EMAIL_PROVIDER.equalsIgnoreCase(str4)) {
                                    RegisterEmailFragment.this.getActivity().startActivityForResult(WelcomeBackPasswordPrompt.createIntent(RegisterEmailFragment.this.getContext(), RegisterEmailFragment.this.getFlowParams(), new IdpResponse.Builder(new User.Builder(AuthUI.EMAIL_PROVIDER, str).build()).build()), 18);
                                    return;
                                }
                                return;
                            }
                            throw new IllegalStateException("User has no providers even though we got a FirebaseAuthUserCollisionException");
                        }
                    }).a(new OnCompleteListener<String>() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailFragment.2.1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<String> task) {
                            RegisterEmailFragment.this.getDialogHolder().dismissDialog();
                        }
                    });
                    return;
                }
                RegisterEmailFragment.this.getDialogHolder().dismissDialog();
            }
        });
    }

    private void safeRequestFocus(final View view) {
        view.post(new Runnable() { // from class: com.firebase.ui.auth.ui.email.RegisterEmailFragment.1
            @Override // java.lang.Runnable
            public void run() {
                view.requestFocus();
            }
        });
    }

    private void validateAndRegisterUser() {
        String obj = this.mEmailEditText.getText().toString();
        String obj2 = this.mPasswordEditText.getText().toString();
        String obj3 = this.mNameEditText.getText().toString();
        boolean validate = this.mEmailFieldValidator.validate(obj);
        boolean validate2 = this.mPasswordFieldValidator.validate(obj2);
        boolean validate3 = this.mNameValidator.validate(obj3);
        if (validate && validate2 && validate3) {
            getDialogHolder().showLoadingDialog(R.string.progress_dialog_signing_up);
            registerUser(obj, obj3, obj2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof AppCompatBase) {
            ((AppCompatBase) getActivity()).setSubtitle(getString(R.string.btn_signup));
        } else {
            getActivity().setTitle(R.string.btn_signup);
        }
        this.mActivity = (HelperActivityBase) getActivity();
        this.mSaveSmartLock = getAuthHelper().getSaveSmartLockInstance(this.mActivity);
        new PreambleHandler(getContext(), getFlowParams(), R.string.btn_signup).setPreamble(this.mAgreementText);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_create) {
            validateAndRegisterUser();
        }
    }

    @Override // com.firebase.ui.auth.ui.FragmentBase, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mUser = User.getUser(getArguments());
        } else {
            this.mUser = User.getUser(bundle);
        }
    }

    @Override // android.support.v4.app.Fragment
    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b.a(RegisterEmailFragment.class.getName());
        View inflate = layoutInflater.inflate(R.layout.fui_register_email_layout, viewGroup, false);
        this.mScroller = (ScrollView) inflate.findViewById(R.id.scroller);
        this.mEmailEditText = (EditText) inflate.findViewById(R.id.email);
        this.mNameEditText = (EditText) inflate.findViewById(R.id.name);
        this.mPasswordEditText = (EditText) inflate.findViewById(R.id.password);
        this.mAgreementText = (TextView) inflate.findViewById(R.id.create_account_text);
        this.mEmailInput = (TextInputLayout) inflate.findViewById(R.id.email_layout);
        this.mPasswordInput = (TextInputLayout) inflate.findViewById(R.id.password_layout);
        this.mPasswordFieldValidator = new PasswordFieldValidator(this.mPasswordInput, getResources().getInteger(R.integer.fui_min_password_length));
        this.mNameValidator = new RequiredFieldValidator((TextInputLayout) inflate.findViewById(R.id.name_layout));
        this.mEmailFieldValidator = new EmailFieldValidator(this.mEmailInput);
        ImeHelper.setImeOnDoneListener(this.mPasswordEditText, 6, this);
        this.mEmailEditText.setOnFocusChangeListener(this);
        this.mNameEditText.setOnFocusChangeListener(this);
        this.mPasswordEditText.setOnFocusChangeListener(this);
        inflate.findViewById(R.id.button_create).setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 26 && getFlowParams().enableCredentials) {
            this.mEmailEditText.setImportantForAutofill(2);
        }
        if (bundle != null) {
            return inflate;
        }
        String email = this.mUser.getEmail();
        if (!TextUtils.isEmpty(email)) {
            this.mEmailEditText.setText(email);
        }
        String name = this.mUser.getName();
        if (!TextUtils.isEmpty(name)) {
            this.mNameEditText.setText(name);
        }
        if (!TextUtils.isEmpty(this.mNameEditText.getText())) {
            safeRequestFocus(this.mPasswordEditText);
        } else if (!TextUtils.isEmpty(this.mEmailEditText.getText())) {
            safeRequestFocus(this.mNameEditText);
        } else {
            safeRequestFocus(this.mEmailEditText);
        }
        return inflate;
    }

    @Override // com.firebase.ui.auth.ui.ImeHelper.DonePressedListener
    public void onDonePressed() {
        hideSoftInput();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        int id = view.getId();
        if (id == R.id.email) {
            this.mEmailFieldValidator.validate(this.mEmailEditText.getText());
        } else if (id == R.id.name) {
            this.mNameValidator.validate(this.mNameEditText.getText());
        } else if (id == R.id.password) {
            this.mPasswordFieldValidator.validate(this.mPasswordEditText.getText());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(ExtraConstants.EXTRA_USER, new User.Builder(AuthUI.EMAIL_PROVIDER, this.mEmailEditText.getText().toString()).setName(this.mNameEditText.getText().toString()).setPhotoUri(this.mUser.getPhotoUri()).build());
        super.onSaveInstanceState(bundle);
    }
}
