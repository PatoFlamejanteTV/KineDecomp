package com.firebase.ui.auth.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() { // from class: com.firebase.ui.auth.ui.User.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(Uri.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public User[] newArray(int i) {
            return new User[i];
        }
    };
    private String mEmail;
    private String mName;
    private Uri mPhotoUri;
    private String mProvider;

    /* renamed from: com.firebase.ui.auth.ui.User$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<User> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(Uri.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public User[] newArray(int i) {
            return new User[i];
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String mEmail;
        private String mName;
        private Uri mPhotoUri;
        private String mProvider;

        public Builder(String str) {
            this.mEmail = str;
        }

        public User build() {
            return new User(this.mEmail, this.mName, this.mProvider, this.mPhotoUri);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            this.mPhotoUri = uri;
            return this;
        }

        public Builder setProvider(String str) {
            this.mProvider = str;
            return this;
        }
    }

    /* synthetic */ User(String str, String str2, String str3, Uri uri, AnonymousClass1 anonymousClass1) {
        this(str, str2, str3, uri);
    }

    public static User getUser(Intent intent) {
        return (User) intent.getParcelableExtra(ExtraConstants.EXTRA_USER);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getName() {
        return this.mName;
    }

    public Uri getPhotoUri() {
        return this.mPhotoUri;
    }

    public String getProvider() {
        return this.mProvider;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mName);
        parcel.writeString(this.mProvider);
        parcel.writeParcelable(this.mPhotoUri, i);
    }

    private User(String str, String str2, String str3, Uri uri) {
        this.mEmail = str;
        this.mName = str2;
        this.mProvider = str3;
        this.mPhotoUri = uri;
    }

    public static User getUser(Bundle bundle) {
        return (User) bundle.getParcelable(ExtraConstants.EXTRA_USER);
    }
}
