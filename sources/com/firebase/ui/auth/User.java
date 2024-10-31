package com.firebase.ui.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.firebase.ui.auth.ui.ExtraConstants;
import java.io.Serializable;

/* loaded from: classes.dex */
public class User implements Serializable {
    private final String mEmail;
    private final String mName;
    private final String mPhoneNumber;
    private final Uri mPhotoUri;
    private final String mProviderId;

    /* loaded from: classes.dex */
    public static class Builder {
        private String mEmail;
        private String mName;
        private String mPhoneNumber;
        private Uri mPhotoUri;
        private String mProviderId;

        public Builder(String str, String str2) {
            this.mProviderId = str;
            this.mEmail = str2;
        }

        public User build() {
            return new User(this.mProviderId, this.mEmail, this.mPhoneNumber, this.mName, this.mPhotoUri);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.mPhoneNumber = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            this.mPhotoUri = uri;
            return this;
        }
    }

    /* synthetic */ User(String str, String str2, String str3, String str4, Uri uri, AnonymousClass1 anonymousClass1) {
        this(str, str2, str3, str4, uri);
    }

    public static User getUser(Intent intent) {
        return (User) intent.getSerializableExtra(ExtraConstants.EXTRA_USER);
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.mProviderId.equals(user.mProviderId) && ((str = this.mEmail) != null ? str.equals(user.mEmail) : user.mEmail == null) && ((str2 = this.mName) != null ? str2.equals(user.mName) : user.mName == null)) {
            Uri uri = this.mPhotoUri;
            if (uri == null) {
                if (user.mPhotoUri == null) {
                    return true;
                }
            } else if (uri.equals(user.mPhotoUri)) {
                return true;
            }
        }
        return false;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public Uri getPhotoUri() {
        return this.mPhotoUri;
    }

    public String getProviderId() {
        return this.mProviderId;
    }

    public int hashCode() {
        int hashCode = this.mProviderId.hashCode() * 31;
        String str = this.mEmail;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Uri uri = this.mPhotoUri;
        return hashCode3 + (uri != null ? uri.hashCode() : 0);
    }

    public String toString() {
        return "User{mProviderId='" + this.mProviderId + "', mEmail='" + this.mEmail + "', mName='" + this.mName + "', mPhotoUri=" + this.mPhotoUri + '}';
    }

    private User(String str, String str2, String str3, String str4, Uri uri) {
        this.mProviderId = str;
        this.mEmail = str2;
        this.mPhoneNumber = str3;
        this.mName = str4;
        this.mPhotoUri = uri;
    }

    public static User getUser(Bundle bundle) {
        return (User) bundle.getSerializable(ExtraConstants.EXTRA_USER);
    }
}
