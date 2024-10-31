package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: classes.dex */
public class LikeContent implements ShareModel {
    public static final Parcelable.Creator<LikeContent> CREATOR = new q();
    private final String objectId;
    private final String objectType;

    /* synthetic */ LikeContent(Builder builder, q qVar) {
        this(builder);
    }

    private LikeContent(Builder builder) {
        this.objectId = builder.objectId;
        this.objectType = builder.objectType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeContent(Parcel parcel) {
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getObjectType() {
        return this.objectType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
    }

    /* loaded from: classes.dex */
    public static class Builder implements ShareModelBuilder<LikeContent, Builder> {
        private String objectId;
        private String objectType;

        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public Builder setObjectType(String str) {
            this.objectType = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public LikeContent build() {
            return new LikeContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(LikeContent likeContent) {
            return likeContent == null ? this : setObjectId(likeContent.getObjectId()).setObjectType(likeContent.getObjectType());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((LikeContent) parcel.readParcelable(LikeContent.class.getClassLoader()));
        }
    }
}
