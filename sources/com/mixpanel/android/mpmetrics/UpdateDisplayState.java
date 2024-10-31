package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
/* loaded from: classes.dex */
public class UpdateDisplayState implements Parcelable {
    public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new aj();
    private static final ReentrantLock d = new ReentrantLock();
    private static long e = -1;
    private static UpdateDisplayState f = null;
    private static int g = 0;
    private static int h = -1;

    /* renamed from: a, reason: collision with root package name */
    private final String f3008a;
    private final String b;
    private final DisplayState c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ UpdateDisplayState(Bundle bundle, aj ajVar) {
        this(bundle);
    }

    /* loaded from: classes.dex */
    public static abstract class DisplayState implements Parcelable {
        public static final Parcelable.Creator<DisplayState> CREATOR = new al();

        public abstract String a();

        /* synthetic */ DisplayState(aj ajVar) {
            this();
        }

        private DisplayState() {
        }

        /* loaded from: classes.dex */
        public static final class InAppNotificationState extends DisplayState {
            public static final Parcelable.Creator<InAppNotificationState> CREATOR = new am();
            private static String c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
            private static String d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";

            /* renamed from: a, reason: collision with root package name */
            private final InAppNotification f3010a;
            private final int b;

            /* JADX INFO: Access modifiers changed from: package-private */
            public /* synthetic */ InAppNotificationState(Bundle bundle, aj ajVar) {
                this(bundle);
            }

            public InAppNotificationState(InAppNotification inAppNotification, int i) {
                super(null);
                this.f3010a = inAppNotification;
                this.b = i;
            }

            public int b() {
                return this.b;
            }

            public InAppNotification c() {
                return this.f3010a;
            }

            @Override // com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState
            public String a() {
                return "InAppNotificationState";
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(c, this.f3010a);
                bundle.putInt(d, this.b);
                parcel.writeBundle(bundle);
            }

            private InAppNotificationState(Bundle bundle) {
                super(null);
                this.f3010a = (InAppNotification) bundle.getParcelable(c);
                this.b = bundle.getInt(d);
            }
        }

        /* loaded from: classes.dex */
        public static final class SurveyState extends DisplayState {
            public static final Parcelable.Creator<SurveyState> CREATOR = new an();

            /* renamed from: a, reason: collision with root package name */
            private final Survey f3011a;
            private final AnswerMap b;
            private Bitmap c;
            private int d;

            /* JADX INFO: Access modifiers changed from: package-private */
            public /* synthetic */ SurveyState(Bundle bundle, aj ajVar) {
                this(bundle);
            }

            public SurveyState(Survey survey) {
                super(null);
                this.f3011a = survey;
                this.b = new AnswerMap();
                this.d = -16777216;
                this.c = null;
            }

            public void a(Bitmap bitmap) {
                this.c = bitmap;
            }

            public void a(int i) {
                this.d = i;
            }

            public Bitmap b() {
                return this.c;
            }

            public AnswerMap c() {
                return this.b;
            }

            public Survey d() {
                return this.f3011a;
            }

            @Override // com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState
            public String a() {
                return "SurveyState";
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Bundle bundle = new Bundle();
                bundle.putInt("com.mixpanel.android.mpmetrics.UpdateDisplayState.HIGHLIGHT_COLOR_BUNDLE_KEY", this.d);
                bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.ANSWERS_BUNDLE_KEY", this.b);
                byte[] bArr = null;
                if (this.c != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.c.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                }
                bundle.putByteArray("com.mixpanel.android.mpmetrics.UpdateDisplayState.BACKGROUND_COMPRESSED_BUNDLE_KEY", bArr);
                bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.SURVEY_BUNDLE_KEY", this.f3011a);
                parcel.writeBundle(bundle);
            }

            private SurveyState(Bundle bundle) {
                super(null);
                this.d = bundle.getInt("com.mixpanel.android.mpmetrics.UpdateDisplayState.HIGHLIGHT_COLOR_BUNDLE_KEY");
                this.b = (AnswerMap) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.ANSWERS_BUNDLE_KEY");
                byte[] byteArray = bundle.getByteArray("com.mixpanel.android.mpmetrics.UpdateDisplayState.BACKGROUND_COMPRESSED_BUNDLE_KEY");
                if (byteArray != null) {
                    this.c = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                } else {
                    this.c = null;
                }
                this.f3011a = (Survey) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.SURVEY_BUNDLE_KEY");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnswerMap implements Parcelable {
        public static final Parcelable.Creator<AnswerMap> CREATOR = new ak();

        /* renamed from: a, reason: collision with root package name */
        private final HashMap<Integer, String> f3009a = new HashMap<>();

        @SuppressLint({"UseSparseArrays"})
        public AnswerMap() {
        }

        public void a(Integer num, String str) {
            this.f3009a.put(num, str);
        }

        public String a(Integer num) {
            return this.f3009a.get(num);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Bundle bundle = new Bundle();
            for (Map.Entry<Integer, String> entry : this.f3009a.entrySet()) {
                bundle.putString(Integer.toString(entry.getKey().intValue()), entry.getValue());
            }
            parcel.writeBundle(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ReentrantLock a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        if (!d.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        long currentTimeMillis = System.currentTimeMillis() - e;
        if (g > 0 && currentTimeMillis > 43200000) {
            Log.i("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
            f = null;
        }
        return f != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(DisplayState displayState, String str, String str2) {
        if (!d.isHeldByCurrentThread()) {
            throw new AssertionError();
        }
        if (!b()) {
            e = System.currentTimeMillis();
            f = new UpdateDisplayState(displayState, str, str2);
            g++;
            return g;
        }
        if (!m.f3036a) {
            return -1;
        }
        Log.v("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
        return -1;
    }

    public static void a(int i) {
        d.lock();
        try {
            if (i == h) {
                h = -1;
                f = null;
            }
        } finally {
            d.unlock();
        }
    }

    public static UpdateDisplayState b(int i) {
        UpdateDisplayState updateDisplayState = null;
        d.lock();
        try {
            if (h <= 0 || h == i) {
                if (f != null) {
                    e = System.currentTimeMillis();
                    h = i;
                    updateDisplayState = f;
                }
            }
            return updateDisplayState;
        } finally {
            d.unlock();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.f3008a);
        bundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.b);
        bundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.c);
        parcel.writeBundle(bundle);
    }

    public DisplayState c() {
        return this.c;
    }

    public String d() {
        return this.f3008a;
    }

    public String e() {
        return this.b;
    }

    UpdateDisplayState(DisplayState displayState, String str, String str2) {
        this.f3008a = str;
        this.b = str2;
        this.c = displayState;
    }

    private UpdateDisplayState(Bundle bundle) {
        this.f3008a = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
        this.b = bundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
        this.c = (DisplayState) bundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
    }
}
