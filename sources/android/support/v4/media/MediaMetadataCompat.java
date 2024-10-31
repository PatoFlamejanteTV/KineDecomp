package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";

    /* renamed from: a */
    static final ArrayMap<String, Integer> f1405a = new ArrayMap<>();

    /* renamed from: b */
    private static final String[] f1406b;

    /* renamed from: c */
    private static final String[] f1407c;

    /* renamed from: d */
    private static final String[] f1408d;

    /* renamed from: e */
    final Bundle f1409e;

    /* renamed from: f */
    private Object f1410f;

    /* renamed from: g */
    private MediaDescriptionCompat f1411g;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<MediaMetadataCompat> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BitmapKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TextKey {
    }

    static {
        f1405a.put(METADATA_KEY_TITLE, 1);
        f1405a.put(METADATA_KEY_ARTIST, 1);
        f1405a.put(METADATA_KEY_DURATION, 0);
        f1405a.put(METADATA_KEY_ALBUM, 1);
        f1405a.put(METADATA_KEY_AUTHOR, 1);
        f1405a.put(METADATA_KEY_WRITER, 1);
        f1405a.put(METADATA_KEY_COMPOSER, 1);
        f1405a.put(METADATA_KEY_COMPILATION, 1);
        f1405a.put(METADATA_KEY_DATE, 1);
        f1405a.put(METADATA_KEY_YEAR, 0);
        f1405a.put(METADATA_KEY_GENRE, 1);
        f1405a.put(METADATA_KEY_TRACK_NUMBER, 0);
        f1405a.put(METADATA_KEY_NUM_TRACKS, 0);
        f1405a.put(METADATA_KEY_DISC_NUMBER, 0);
        f1405a.put(METADATA_KEY_ALBUM_ARTIST, 1);
        f1405a.put(METADATA_KEY_ART, 2);
        f1405a.put(METADATA_KEY_ART_URI, 1);
        f1405a.put(METADATA_KEY_ALBUM_ART, 2);
        f1405a.put(METADATA_KEY_ALBUM_ART_URI, 1);
        f1405a.put(METADATA_KEY_USER_RATING, 3);
        f1405a.put(METADATA_KEY_RATING, 3);
        f1405a.put(METADATA_KEY_DISPLAY_TITLE, 1);
        f1405a.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        f1405a.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        f1405a.put(METADATA_KEY_DISPLAY_ICON, 2);
        f1405a.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        f1405a.put(METADATA_KEY_MEDIA_ID, 1);
        f1405a.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        f1405a.put(METADATA_KEY_MEDIA_URI, 1);
        f1405a.put(METADATA_KEY_ADVERTISEMENT, 0);
        f1405a.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        f1406b = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        f1407c = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        f1408d = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat[] newArray(int i) {
                return new MediaMetadataCompat[i];
            }
        };
    }

    MediaMetadataCompat(Bundle bundle) {
        this.f1409e = new Bundle(bundle);
        this.f1409e.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f1410f = obj;
        return createFromParcel;
    }

    public boolean containsKey(String str) {
        return this.f1409e.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.f1409e.getParcelable(str);
        } catch (Exception e2) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e2);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f1409e;
    }

    public MediaDescriptionCompat getDescription() {
        Bitmap bitmap;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.f1411g;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i = 0;
            int i2 = 0;
            while (i < charSequenceArr.length) {
                String[] strArr = f1406b;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                CharSequence text2 = getText(strArr[i2]);
                if (!TextUtils.isEmpty(text2)) {
                    charSequenceArr[i] = text2;
                    i++;
                }
                i2 = i3;
            }
        }
        int i4 = 0;
        while (true) {
            String[] strArr2 = f1407c;
            if (i4 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = getBitmap(strArr2[i4]);
            if (bitmap != null) {
                break;
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            String[] strArr3 = f1408d;
            if (i5 >= strArr3.length) {
                uri = null;
                break;
            }
            String string2 = getString(strArr3[i5]);
            if (!TextUtils.isEmpty(string2)) {
                uri = Uri.parse(string2);
                break;
            }
            i5++;
        }
        String string3 = getString(METADATA_KEY_MEDIA_URI);
        Uri parse = TextUtils.isEmpty(string3) ? null : Uri.parse(string3);
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        builder.setMediaUri(parse);
        Bundle bundle = new Bundle();
        if (this.f1409e.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.f1409e.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        this.f1411g = builder.build();
        return this.f1411g;
    }

    public long getLong(String str) {
        return this.f1409e.getLong(str, 0L);
    }

    public Object getMediaMetadata() {
        if (this.f1410f == null && Build.VERSION.SDK_INT >= 21) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.f1410f = MediaMetadataCompatApi21.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.f1410f;
    }

    public RatingCompat getRating(String str) {
        RatingCompat ratingCompat;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                ratingCompat = RatingCompat.fromRating(this.f1409e.getParcelable(str));
            } else {
                ratingCompat = (RatingCompat) this.f1409e.getParcelable(str);
            }
            return ratingCompat;
        } catch (Exception e2) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e2);
            return null;
        }
    }

    public String getString(String str) {
        CharSequence charSequence = this.f1409e.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence getText(String str) {
        return this.f1409e.getCharSequence(str);
    }

    public Set<String> keySet() {
        return this.f1409e.keySet();
    }

    public int size() {
        return this.f1409e.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1409e);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private final Bundle f1412a;

        public Builder() {
            this.f1412a = new Bundle();
        }

        private Bitmap a(Bitmap bitmap, int i) {
            float f2 = i;
            float min = Math.min(f2 / bitmap.getWidth(), f2 / bitmap.getHeight());
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true);
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.f1412a);
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            if (MediaMetadataCompat.f1405a.containsKey(str) && MediaMetadataCompat.f1405a.get(str).intValue() != 2) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
            }
            this.f1412a.putParcelable(str, bitmap);
            return this;
        }

        public Builder putLong(String str, long j) {
            if (MediaMetadataCompat.f1405a.containsKey(str) && MediaMetadataCompat.f1405a.get(str).intValue() != 0) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
            }
            this.f1412a.putLong(str, j);
            return this;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            if (MediaMetadataCompat.f1405a.containsKey(str) && MediaMetadataCompat.f1405a.get(str).intValue() != 3) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.f1412a.putParcelable(str, (Parcelable) ratingCompat.getRating());
            } else {
                this.f1412a.putParcelable(str, ratingCompat);
            }
            return this;
        }

        public Builder putString(String str, String str2) {
            if (MediaMetadataCompat.f1405a.containsKey(str) && MediaMetadataCompat.f1405a.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
            }
            this.f1412a.putCharSequence(str, str2);
            return this;
        }

        public Builder putText(String str, CharSequence charSequence) {
            if (MediaMetadataCompat.f1405a.containsKey(str) && MediaMetadataCompat.f1405a.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
            }
            this.f1412a.putCharSequence(str, charSequence);
            return this;
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            this.f1412a = new Bundle(mediaMetadataCompat.f1409e);
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (String str : this.f1412a.keySet()) {
                Object obj = this.f1412a.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        putBitmap(str, a(bitmap, i));
                    }
                }
            }
        }
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f1409e = parcel.readBundle();
        this.f1409e.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }
}
