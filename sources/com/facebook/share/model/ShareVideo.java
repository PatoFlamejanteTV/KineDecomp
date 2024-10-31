package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;

/* loaded from: classes.dex */
public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new j();
    private final Uri localUrl;

    /* synthetic */ ShareVideo(Builder builder, j jVar) {
        this(builder);
    }

    private ShareVideo(Builder builder) {
        super(builder);
        this.localUrl = builder.localUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareVideo(Parcel parcel) {
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public Uri getLocalUrl() {
        return this.localUrl;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareMedia.Builder<ShareVideo, Builder> {
        private Uri localUrl;

        public Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareVideo build() {
            return new ShareVideo(this, null);
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareVideo shareVideo) {
            return shareVideo == null ? this : ((Builder) super.readFrom((Builder) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }
}
