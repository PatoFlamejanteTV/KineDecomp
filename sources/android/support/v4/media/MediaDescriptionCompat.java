package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;

    /* renamed from: a */
    private final String f1389a;

    /* renamed from: b */
    private final CharSequence f1390b;

    /* renamed from: c */
    private final CharSequence f1391c;

    /* renamed from: d */
    private final CharSequence f1392d;

    /* renamed from: e */
    private final Bitmap f1393e;

    /* renamed from: f */
    private final Uri f1394f;

    /* renamed from: g */
    private final Bundle f1395g;

    /* renamed from: h */
    private final Uri f1396h;
    private Object i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<MediaDescriptionCompat> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private String f1397a;

        /* renamed from: b */
        private CharSequence f1398b;

        /* renamed from: c */
        private CharSequence f1399c;

        /* renamed from: d */
        private CharSequence f1400d;

        /* renamed from: e */
        private Bitmap f1401e;

        /* renamed from: f */
        private Uri f1402f;

        /* renamed from: g */
        private Bundle f1403g;

        /* renamed from: h */
        private Uri f1404h;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f1397a, this.f1398b, this.f1399c, this.f1400d, this.f1401e, this.f1402f, this.f1403g, this.f1404h);
        }

        public Builder setDescription(CharSequence charSequence) {
            this.f1400d = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f1403g = bundle;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.f1401e = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.f1402f = uri;
            return this;
        }

        public Builder setMediaId(String str) {
            this.f1397a = str;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.f1404h = uri;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.f1399c = charSequence;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f1398b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1389a = str;
        this.f1390b = charSequence;
        this.f1391c = charSequence2;
        this.f1392d = charSequence3;
        this.f1393e = bitmap;
        this.f1394f = uri;
        this.f1395g = bundle;
        this.f1396h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.support.v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L7d
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L7d
            android.support.v4.media.MediaDescriptionCompat$Builder r1 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.MediaDescriptionCompatApi21.getMediaId(r8)
            r1.setMediaId(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.getTitle(r8)
            r1.setTitle(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.getSubtitle(r8)
            r1.setSubtitle(r2)
            java.lang.CharSequence r2 = android.support.v4.media.MediaDescriptionCompatApi21.getDescription(r8)
            r1.setDescription(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.MediaDescriptionCompatApi21.getIconBitmap(r8)
            r1.setIconBitmap(r2)
            android.net.Uri r2 = android.support.v4.media.MediaDescriptionCompatApi21.getIconUri(r8)
            r1.setIconUri(r2)
            android.os.Bundle r2 = android.support.v4.media.MediaDescriptionCompatApi21.getExtras(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 != 0) goto L42
            r4 = r0
            goto L48
        L42:
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
        L48:
            if (r4 == 0) goto L60
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L5a
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L5a
            goto L61
        L5a:
            r2.remove(r3)
            r2.remove(r5)
        L60:
            r0 = r2
        L61:
            r1.setExtras(r0)
            if (r4 == 0) goto L6a
            r1.setMediaUri(r4)
            goto L77
        L6a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L77
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompatApi23.getMediaUri(r8)
            r1.setMediaUri(r0)
        L77:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.build()
            r0.i = r8
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence getDescription() {
        return this.f1392d;
    }

    public Bundle getExtras() {
        return this.f1395g;
    }

    public Bitmap getIconBitmap() {
        return this.f1393e;
    }

    public Uri getIconUri() {
        return this.f1394f;
    }

    public Object getMediaDescription() {
        if (this.i == null && Build.VERSION.SDK_INT >= 21) {
            Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
            MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.f1389a);
            MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.f1390b);
            MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.f1391c);
            MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.f1392d);
            MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.f1393e);
            MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.f1394f);
            Bundle bundle = this.f1395g;
            if (Build.VERSION.SDK_INT < 23 && this.f1396h != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                }
                bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.f1396h);
            }
            MediaDescriptionCompatApi21.Builder.setExtras(newInstance, bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.f1396h);
            }
            this.i = MediaDescriptionCompatApi21.Builder.build(newInstance);
            return this.i;
        }
        return this.i;
    }

    public String getMediaId() {
        return this.f1389a;
    }

    public Uri getMediaUri() {
        return this.f1396h;
    }

    public CharSequence getSubtitle() {
        return this.f1391c;
    }

    public CharSequence getTitle() {
        return this.f1390b;
    }

    public String toString() {
        return ((Object) this.f1390b) + ", " + ((Object) this.f1391c) + ", " + ((Object) this.f1392d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f1389a);
            TextUtils.writeToParcel(this.f1390b, parcel, i);
            TextUtils.writeToParcel(this.f1391c, parcel, i);
            TextUtils.writeToParcel(this.f1392d, parcel, i);
            parcel.writeParcelable(this.f1393e, i);
            parcel.writeParcelable(this.f1394f, i);
            parcel.writeBundle(this.f1395g);
            parcel.writeParcelable(this.f1396h, i);
            return;
        }
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f1389a = parcel.readString();
        this.f1390b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1391c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1392d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1393e = (Bitmap) parcel.readParcelable(null);
        this.f1394f = (Uri) parcel.readParcelable(null);
        this.f1395g = parcel.readBundle();
        this.f1396h = (Uri) parcel.readParcelable(null);
    }
}
