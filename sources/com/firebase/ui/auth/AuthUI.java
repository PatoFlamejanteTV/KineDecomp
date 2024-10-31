package com.firebase.ui.auth;

import android.content.Intent;
import android.os.Parcel;
import android.support.v4.app.FragmentActivity;
import com.firebase.ui.auth.ui.FlowParameters;
import com.firebase.ui.auth.util.GoogleSignInHelper;
import com.firebase.ui.auth.util.Preconditions;
import com.firebase.ui.auth.util.signincontainer.SmartLockBase;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class AuthUI {
    public static final int NO_LOGO = -1;
    private final FirebaseApp mApp;
    private final FirebaseAuth mAuth;
    public static final String EMAIL_PROVIDER = "password";
    public static final Set<String> SUPPORTED_PROVIDERS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EMAIL_PROVIDER)));
    private static final IdentityHashMap<FirebaseApp, AuthUI> INSTANCES = new IdentityHashMap<>();

    /* loaded from: classes.dex */
    private abstract class AuthIntentBuilder<T extends AuthIntentBuilder> {
        boolean mEnableCredentials;
        boolean mEnableHints;
        int mLogo;
        String mPrivacyPolicyUrl;
        List<IdpConfig> mProviders;
        int mTheme;
        String mTitle;
        String mTosUrl;

        public Intent build() {
            if (this.mProviders.isEmpty()) {
                this.mProviders.add(new IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());
            }
            return KickoffActivity.createIntent(AuthUI.this.mApp.b(), getFlowParams());
        }

        protected abstract FlowParameters getFlowParams();

        public T setAvailableProviders(List<IdpConfig> list) {
            this.mProviders.clear();
            for (IdpConfig idpConfig : list) {
                if (!this.mProviders.contains(idpConfig)) {
                    this.mProviders.add(idpConfig);
                } else {
                    throw new IllegalArgumentException("Each provider can only be set once. " + idpConfig.getProviderId() + " was set twice.");
                }
            }
            return this;
        }

        public T setIsSmartLockEnabled(boolean z) {
            setIsSmartLockEnabled(z, z);
            return this;
        }

        public T setLogo(int i) {
            this.mLogo = i;
            return this;
        }

        public T setPrivacyPolicyUrl(String str) {
            this.mPrivacyPolicyUrl = str;
            return this;
        }

        @Deprecated
        public T setProviders(List<IdpConfig> list) {
            setAvailableProviders(list);
            int indexOf = this.mProviders.indexOf(new IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());
            if (indexOf != -1) {
                List<IdpConfig> list2 = this.mProviders;
                list2.add(0, list2.remove(indexOf));
            }
            Collections.reverse(this.mProviders);
            return this;
        }

        public T setTheme(int i) {
            Preconditions.checkValidStyle(AuthUI.this.mApp.b(), i, "theme identifier is unknown or not a style definition", new Object[0]);
            this.mTheme = i;
            return this;
        }

        public T setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public T setTosUrl(String str) {
            this.mTosUrl = str;
            return this;
        }

        private AuthIntentBuilder() {
            this.mLogo = -1;
            this.mTheme = AuthUI.getDefaultTheme();
            this.mProviders = new ArrayList();
            this.mEnableCredentials = true;
            this.mEnableHints = true;
        }

        public T setIsSmartLockEnabled(boolean z, boolean z2) {
            this.mEnableCredentials = z;
            this.mEnableHints = z2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class IdpConfig implements Serializable {
        private final String mProviderId;
        private final List<String> mScopes;

        /* loaded from: classes.dex */
        public static class Builder {
            private String mProviderId;
            private List<String> mScopes = new ArrayList();

            public Builder(String str) {
                if (AuthUI.SUPPORTED_PROVIDERS.contains(str)) {
                    this.mProviderId = str;
                    return;
                }
                throw new IllegalArgumentException("Unkown provider: " + str);
            }

            public IdpConfig build() {
                return new IdpConfig(this.mProviderId, this.mScopes);
            }

            public Builder setPermissions(List<String> list) {
                this.mScopes = list;
                return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || IdpConfig.class != obj.getClass()) {
                return false;
            }
            return this.mProviderId.equals(((IdpConfig) obj).mProviderId);
        }

        public String getProviderId() {
            return this.mProviderId;
        }

        public List<String> getScopes() {
            return this.mScopes;
        }

        public int hashCode() {
            return this.mProviderId.hashCode();
        }

        public String toString() {
            return "IdpConfig{mProviderId='" + this.mProviderId + "', mScopes=" + this.mScopes + '}';
        }

        private IdpConfig(String str, List<String> list) {
            this.mProviderId = str;
            this.mScopes = Collections.unmodifiableList(list);
        }

        private IdpConfig(Parcel parcel) {
            this.mProviderId = parcel.readString();
            this.mScopes = Collections.unmodifiableList(parcel.createStringArrayList());
        }
    }

    /* loaded from: classes.dex */
    public final class SignInIntentBuilder extends AuthIntentBuilder<SignInIntentBuilder> {
        private boolean mAllowNewEmailAccounts;

        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* bridge */ /* synthetic */ Intent build() {
            return super.build();
        }

        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        protected FlowParameters getFlowParams() {
            return new FlowParameters(AuthUI.this.mApp.d(), this.mProviders, this.mTheme, this.mLogo, this.mTosUrl, this.mPrivacyPolicyUrl, this.mEnableCredentials, this.mEnableHints, this.mAllowNewEmailAccounts, this.mTitle);
        }

        public SignInIntentBuilder setAllowNewEmailAccounts(boolean z) {
            this.mAllowNewEmailAccounts = z;
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: (Ljava/util/List<Lcom/firebase/ui/auth/AuthUI$IdpConfig;>;)TT; */
        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* synthetic */ SignInIntentBuilder setAvailableProviders(List list) {
            super.setAvailableProviders(list);
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: (Z)TT; */
        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* synthetic */ SignInIntentBuilder setIsSmartLockEnabled(boolean z) {
            super.setIsSmartLockEnabled(z);
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* synthetic */ SignInIntentBuilder setPrivacyPolicyUrl(String str) {
            super.setPrivacyPolicyUrl(str);
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* synthetic */ SignInIntentBuilder setTitle(String str) {
            super.setTitle(str);
            return this;
        }

        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
        @Override // com.firebase.ui.auth.AuthUI.AuthIntentBuilder
        public /* synthetic */ SignInIntentBuilder setTosUrl(String str) {
            super.setTosUrl(str);
            return this;
        }

        private SignInIntentBuilder() {
            super();
            this.mAllowNewEmailAccounts = true;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SupportedProvider {
    }

    private AuthUI(FirebaseApp firebaseApp) {
        this.mApp = firebaseApp;
        this.mAuth = FirebaseAuth.getInstance(this.mApp);
    }

    public static int getDefaultTheme() {
        return R.style.FirebaseUI;
    }

    public static AuthUI getInstance() {
        return getInstance(FirebaseApp.c());
    }

    public SignInIntentBuilder createSignInIntentBuilder() {
        return new SignInIntentBuilder();
    }

    public Task<Void> delete(FragmentActivity fragmentActivity) {
        GoogleSignInHelper googleSignInHelper = GoogleSignInHelper.getInstance(fragmentActivity);
        FirebaseUser a2 = FirebaseAuth.getInstance().a();
        if (a2 == null) {
            return Tasks.a(new Exception("No currently signed in user."));
        }
        Task<Void> a3 = a2.a();
        List<Credential> credentialsFromFirebaseUser = SmartLockBase.credentialsFromFirebaseUser(a2);
        ArrayList arrayList = new ArrayList();
        Iterator<Credential> it = credentialsFromFirebaseUser.iterator();
        while (it.hasNext()) {
            arrayList.add(googleSignInHelper.delete(it.next()));
        }
        final Task<Void> a4 = Tasks.a((Collection<? extends Task<?>>) arrayList);
        return a3.b(new Continuation<Void, Task<Void>>() { // from class: com.firebase.ui.auth.AuthUI.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.gms.tasks.Continuation
            public Task<Void> then(Task<Void> task) throws Exception {
                task.a(Exception.class);
                return a4;
            }
        });
    }

    public Task<Void> signOut(FragmentActivity fragmentActivity) {
        GoogleSignInHelper googleSignInHelper = GoogleSignInHelper.getInstance(fragmentActivity);
        this.mAuth.b();
        return Tasks.a((Task<?>[]) new Task[]{googleSignInHelper.disableAutoSignIn(), googleSignInHelper.signOut()});
    }

    public static AuthUI getInstance(FirebaseApp firebaseApp) {
        AuthUI authUI;
        synchronized (INSTANCES) {
            authUI = INSTANCES.get(firebaseApp);
            if (authUI == null) {
                authUI = new AuthUI(firebaseApp);
                INSTANCES.put(firebaseApp, authUI);
            }
        }
        return authUI;
    }
}
