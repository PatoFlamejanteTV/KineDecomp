package com.firebase.ui.auth;

import android.content.Intent;
import android.text.TextUtils;
import com.firebase.ui.auth.ui.ExtraConstants;
import java.io.Serializable;

/* loaded from: classes.dex */
public class IdpResponse implements Serializable {
    private final int mErrorCode;
    private final String mSecret;
    private final String mToken;
    private final User mUser;

    /* loaded from: classes.dex */
    public static class Builder {
        private String mSecret;
        private String mToken;
        private User mUser;

        public Builder(User user) {
            this.mUser = user;
        }

        public IdpResponse build() {
            String providerId = this.mUser.getProviderId();
            if ((!providerId.equalsIgnoreCase("google.com") && !providerId.equalsIgnoreCase("facebook.com") && !providerId.equalsIgnoreCase("twitter.com")) || !TextUtils.isEmpty(this.mToken)) {
                if (providerId.equalsIgnoreCase("twitter.com") && TextUtils.isEmpty(this.mSecret)) {
                    throw new IllegalStateException("Secret cannot be null when using the Twitter provider.");
                }
                return new IdpResponse(this.mUser, this.mToken, this.mSecret, -1);
            }
            throw new IllegalStateException("Token cannot be null when using a non-email provider.");
        }

        public Builder setSecret(String str) {
            this.mSecret = str;
            return this;
        }

        public Builder setToken(String str) {
            this.mToken = str;
            return this;
        }
    }

    /* synthetic */ IdpResponse(User user, String str, String str2, int i, AnonymousClass1 anonymousClass1) {
        this(user, str, str2, i);
    }

    public static IdpResponse fromResultIntent(Intent intent) {
        if (intent != null) {
            return (IdpResponse) intent.getSerializableExtra(ExtraConstants.EXTRA_IDP_RESPONSE);
        }
        return null;
    }

    public static Intent getErrorCodeIntent(int i) {
        return new IdpResponse(i).toIntent();
    }

    public String getEmail() {
        return this.mUser.getEmail();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getIdpSecret() {
        return this.mSecret;
    }

    public String getIdpToken() {
        return this.mToken;
    }

    public String getPhoneNumber() {
        return this.mUser.getPhoneNumber();
    }

    public String getProviderType() {
        return this.mUser.getProviderId();
    }

    public User getUser() {
        return this.mUser;
    }

    public Intent toIntent() {
        return new Intent().putExtra(ExtraConstants.EXTRA_IDP_RESPONSE, this);
    }

    private IdpResponse(int i) {
        this(null, null, null, i);
    }

    private IdpResponse(User user, String str, String str2, int i) {
        this.mUser = user;
        this.mToken = str;
        this.mSecret = str2;
        this.mErrorCode = i;
    }
}
