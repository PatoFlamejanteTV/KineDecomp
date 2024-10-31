package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;

    /* renamed from: a */
    private final int f1414a;

    /* renamed from: b */
    private final float f1415b;

    /* renamed from: c */
    private Object f1416c;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<RatingCompat> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Style {
    }

    RatingCompat(int i, float f2) {
        this.f1414a = i;
        this.f1415b = f2;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && Build.VERSION.SDK_INT >= 19) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = newHeartRating(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompat = newThumbRating(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(ratingStyle);
            }
            ratingCompat.f1416c = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newPercentageRating(float f2) {
        if (f2 >= 0.0f && f2 <= 100.0f) {
            return new RatingCompat(6, f2);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i, float f2) {
        float f3;
        if (i == 3) {
            f3 = 3.0f;
        } else if (i == 4) {
            f3 = 4.0f;
        } else {
            if (i != 5) {
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f3 = 5.0f;
        }
        if (f2 >= 0.0f && f2 <= f3) {
            return new RatingCompat(i, f2);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f1414a;
    }

    public float getPercentRating() {
        if (this.f1414a == 6 && isRated()) {
            return this.f1415b;
        }
        return -1.0f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0012. Please report as an issue. */
    public Object getRating() {
        if (this.f1416c == null && Build.VERSION.SDK_INT >= 19) {
            if (isRated()) {
                int i = this.f1414a;
                switch (i) {
                    case 1:
                        this.f1416c = Rating.newHeartRating(hasHeart());
                        break;
                    case 2:
                        this.f1416c = Rating.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f1416c = Rating.newStarRating(i, getStarRating());
                        break;
                    case 6:
                        this.f1416c = Rating.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f1416c = Rating.newUnratedRating(this.f1414a);
            }
        }
        return this.f1416c;
    }

    public int getRatingStyle() {
        return this.f1414a;
    }

    public float getStarRating() {
        int i = this.f1414a;
        if ((i == 3 || i == 4 || i == 5) && isRated()) {
            return this.f1415b;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        return this.f1414a == 1 && this.f1415b == 1.0f;
    }

    public boolean isRated() {
        return this.f1415b >= 0.0f;
    }

    public boolean isThumbUp() {
        return this.f1414a == 2 && this.f1415b == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f1414a);
        sb.append(" rating=");
        float f2 = this.f1415b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1414a);
        parcel.writeFloat(this.f1415b);
    }
}
