package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ShareContent<P extends ShareContent, E extends Builder> implements ShareModel {
    private final Uri contentUrl;
    private final List<String> peopleIds;
    private final String placeId;
    private final String ref;

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(Builder builder) {
        this.contentUrl = builder.contentUrl;
        this.peopleIds = builder.peopleIds;
        this.placeId = builder.placeId;
        this.ref = builder.ref;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(Parcel parcel) {
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.ref = parcel.readString();
    }

    public Uri getContentUrl() {
        return this.contentUrl;
    }

    public List<String> getPeopleIds() {
        return this.peopleIds;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public String getRef() {
        return this.ref;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.contentUrl, 0);
        parcel.writeStringList(this.peopleIds);
        parcel.writeString(this.placeId);
        parcel.writeString(this.ref);
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes.dex */
    public static abstract class Builder<P extends ShareContent, E extends Builder> implements ShareModelBuilder<P, E> {
        private Uri contentUrl;
        private List<String> peopleIds;
        private String placeId;
        private String ref;

        public E setContentUrl(Uri uri) {
            this.contentUrl = uri;
            return this;
        }

        public E setPeopleIds(List<String> list) {
            this.peopleIds = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public E setPlaceId(String str) {
            this.placeId = str;
            return this;
        }

        public E setRef(String str) {
            this.ref = str;
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public E readFrom(P p) {
            return p == null ? this : (E) setContentUrl(p.getContentUrl()).setPeopleIds(p.getPeopleIds()).setPlaceId(p.getPlaceId()).setRef(p.getRef());
        }
    }
}
