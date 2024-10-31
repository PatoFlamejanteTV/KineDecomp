package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new i();
    private final List<SharePhoto> photos;

    /* synthetic */ SharePhotoContent(Builder builder, i iVar) {
        this(builder);
    }

    private SharePhotoContent(Builder builder) {
        super(builder);
        this.photos = Collections.unmodifiableList(builder.photos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.photos = Collections.unmodifiableList(SharePhoto.Builder.readListFrom(parcel));
    }

    public List<SharePhoto> getPhotos() {
        return this.photos;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SharePhoto.Builder.writeListTo(parcel, this.photos);
    }

    /* loaded from: classes.dex */
    public static class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder addPhoto(SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.photos.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public Builder addPhotos(List<SharePhoto> list) {
            if (list != null) {
                Iterator<SharePhoto> it = list.iterator();
                while (it.hasNext()) {
                    addPhoto(it.next());
                }
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhotoContent build() {
            return new SharePhotoContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            return sharePhotoContent == null ? this : ((Builder) super.readFrom((Builder) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((SharePhotoContent) parcel.readParcelable(SharePhotoContent.class.getClassLoader()));
        }

        public Builder setPhotos(List<SharePhoto> list) {
            this.photos.clear();
            addPhotos(list);
            return this;
        }
    }
}
