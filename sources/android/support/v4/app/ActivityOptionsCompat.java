package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;

/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    /* loaded from: classes.dex */
    public static class ActivityOptionsCompatApi16Impl extends ActivityOptionsCompat {

        /* renamed from: a */
        protected final ActivityOptions f683a;

        ActivityOptionsCompatApi16Impl(ActivityOptions activityOptions) {
            this.f683a = activityOptions;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.f683a.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsCompatApi16Impl) {
                this.f683a.update(((ActivityOptionsCompatApi16Impl) activityOptionsCompat).f683a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ActivityOptionsCompatApi23Impl extends ActivityOptionsCompatApi16Impl {
        ActivityOptionsCompatApi23Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            this.f683a.requestUsageTimeReport(pendingIntent);
        }
    }

    /* loaded from: classes.dex */
    public static class ActivityOptionsCompatApi24Impl extends ActivityOptionsCompatApi23Impl {
        ActivityOptionsCompatApi24Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return this.f683a.getLaunchBounds();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            return new ActivityOptionsCompatApi24Impl(this.f683a.setLaunchBounds(rect));
        }
    }

    protected ActivityOptionsCompat() {
    }

    private static ActivityOptionsCompat a(ActivityOptions activityOptions) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return new ActivityOptionsCompatApi24Impl(activityOptions);
        }
        if (i >= 23) {
            return new ActivityOptionsCompatApi23Impl(activityOptions);
        }
        return new ActivityOptionsCompatApi16Impl(activityOptions);
    }

    public static ActivityOptionsCompat makeBasic() {
        if (Build.VERSION.SDK_INT >= 23) {
            return a(ActivityOptions.makeBasic());
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a(ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a(ActivityOptions.makeCustomAnimation(context, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a(ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a(ActivityOptions.makeTaskLaunchBehind());
        }
        return new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
        }
        return new ActivityOptionsCompat();
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.util.Pair[] pairArr2 = null;
            if (pairArr != null) {
                pairArr2 = new android.util.Pair[pairArr.length];
                for (int i = 0; i < pairArr.length; i++) {
                    pairArr2[i] = android.util.Pair.create(pairArr[i].first, pairArr[i].second);
                }
            }
            return a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
        }
        return new ActivityOptionsCompat();
    }
}
