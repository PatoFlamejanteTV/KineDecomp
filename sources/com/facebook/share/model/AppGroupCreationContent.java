package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new a();
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    /* loaded from: classes.dex */
    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    /* synthetic */ AppGroupCreationContent(Builder builder, a aVar) {
        this(builder);
    }

    private AppGroupCreationContent(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.privacy = builder.privacy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppGroupCreationContent(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public AppGroupPrivacy getAppGroupPrivacy() {
        return this.privacy;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
    }

    /* loaded from: classes.dex */
    public static class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {
        private String description;
        private String name;
        private AppGroupPrivacy privacy;

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setAppGroupPrivacy(AppGroupPrivacy appGroupPrivacy) {
            this.privacy = appGroupPrivacy;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            return appGroupCreationContent == null ? this : setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((AppGroupCreationContent) parcel.readParcelable(AppGroupCreationContent.class.getClassLoader()));
        }
    }
}
