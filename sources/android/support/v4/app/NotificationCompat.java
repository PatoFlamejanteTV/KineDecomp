package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import b.b.a.a;
import b.b.a.c;
import b.b.a.d;
import b.b.a.f;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import com.umeng.analytics.pro.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* loaded from: classes.dex */
    public static class Action {

        /* renamed from: a */
        final Bundle f914a;
        public PendingIntent actionIntent;

        /* renamed from: b */
        private final RemoteInput[] f915b;

        /* renamed from: c */
        private final RemoteInput[] f916c;

        /* renamed from: d */
        private boolean f917d;
        public int icon;
        public CharSequence title;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            private final int f918a;

            /* renamed from: b */
            private final CharSequence f919b;

            /* renamed from: c */
            private final PendingIntent f920c;

            /* renamed from: d */
            private boolean f921d;

            /* renamed from: e */
            private final Bundle f922e;

            /* renamed from: f */
            private ArrayList<RemoteInput> f923f;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null, true);
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.f922e.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f923f == null) {
                    this.f923f = new ArrayList<>();
                }
                this.f923f.add(remoteInput);
                return this;
            }

            public Action build() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.f923f;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                return new Action(this.f918a, this.f919b, this.f920c, this.f922e, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.f921d);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.f922e;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.f921d = z;
                return this;
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.f914a), action.getRemoteInputs(), action.getAllowGeneratedReplies());
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z) {
                this.f921d = true;
                this.f918a = i;
                this.f919b = Builder.a(charSequence);
                this.f920c = pendingIntent;
                this.f922e = bundle;
                this.f923f = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.f921d = z;
            }
        }

        /* loaded from: classes.dex */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* loaded from: classes.dex */
        public static final class WearableExtender implements Extender {

            /* renamed from: a */
            private int f924a;

            /* renamed from: b */
            private CharSequence f925b;

            /* renamed from: c */
            private CharSequence f926c;

            /* renamed from: d */
            private CharSequence f927d;

            public WearableExtender() {
                this.f924a = 1;
            }

            private void a(int i, boolean z) {
                if (z) {
                    this.f924a = i | this.f924a;
                } else {
                    this.f924a = (i ^ (-1)) & this.f924a;
                }
            }

            @Override // android.support.v4.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.f924a;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.f925b;
                if (charSequence != null) {
                    bundle.putCharSequence("inProgressLabel", charSequence);
                }
                CharSequence charSequence2 = this.f926c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("confirmLabel", charSequence2);
                }
                CharSequence charSequence3 = this.f927d;
                if (charSequence3 != null) {
                    bundle.putCharSequence("cancelLabel", charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            public CharSequence getCancelLabel() {
                return this.f927d;
            }

            public CharSequence getConfirmLabel() {
                return this.f926c;
            }

            public boolean getHintDisplayActionInline() {
                return (this.f924a & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.f924a & 2) != 0;
            }

            public CharSequence getInProgressLabel() {
                return this.f925b;
            }

            public boolean isAvailableOffline() {
                return (this.f924a & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                a(1, z);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.f927d = charSequence;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.f926c = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                a(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                a(2, z);
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.f925b = charSequence;
                return this;
            }

            /* renamed from: clone */
            public WearableExtender m2clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f924a = this.f924a;
                wearableExtender.f925b = this.f925b;
                wearableExtender.f926c = this.f926c;
                wearableExtender.f927d = this.f927d;
                return wearableExtender;
            }

            public WearableExtender(Action action) {
                this.f924a = 1;
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f924a = bundle.getInt("flags", 1);
                    this.f925b = bundle.getCharSequence("inProgressLabel");
                    this.f926c = bundle.getCharSequence("confirmLabel");
                    this.f927d = bundle.getCharSequence("cancelLabel");
                }
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f917d;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.f916c;
        }

        public Bundle getExtras() {
            return this.f914a;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.f915b;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z) {
            this.icon = i;
            this.title = Builder.a(charSequence);
            this.actionIntent = pendingIntent;
            this.f914a = bundle == null ? new Bundle() : bundle;
            this.f915b = remoteInputArr;
            this.f916c = remoteInputArr2;
            this.f917d = z;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BadgeIconType {
    }

    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {

        /* renamed from: e */
        private Bitmap f928e;

        /* renamed from: f */
        private Bitmap f929f;

        /* renamed from: g */
        private boolean f930g;

        public BigPictureStyle() {
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f966b).bigPicture(this.f928e);
                if (this.f930g) {
                    bigPicture.bigLargeIcon(this.f929f);
                }
                if (this.f968d) {
                    bigPicture.setSummaryText(this.f967c);
                }
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.f929f = bitmap;
            this.f930g = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.f928e = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.f966b = Builder.a(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.f967c = Builder.a(charSequence);
            this.f968d = true;
            return this;
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {

        /* renamed from: e */
        private CharSequence f931e;

        public BigTextStyle() {
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f966b).bigText(this.f931e);
                if (this.f968d) {
                    bigText.setSummaryText(this.f967c);
                }
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.f931e = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.f966b = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.f967c = Builder.a(charSequence);
            this.f968d = true;
            return this;
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        int A;
        Notification B;
        RemoteViews C;
        RemoteViews D;
        RemoteViews E;
        String F;
        int G;
        String H;
        long I;
        int J;
        Notification K;

        /* renamed from: a */
        CharSequence f932a;

        /* renamed from: b */
        CharSequence f933b;

        /* renamed from: c */
        PendingIntent f934c;

        /* renamed from: d */
        PendingIntent f935d;

        /* renamed from: e */
        RemoteViews f936e;

        /* renamed from: f */
        Bitmap f937f;

        /* renamed from: g */
        CharSequence f938g;

        /* renamed from: h */
        int f939h;
        int i;
        boolean j;
        boolean k;
        Style l;
        CharSequence m;
        public ArrayList<Action> mActions;
        public Context mContext;

        @Deprecated
        public ArrayList<String> mPeople;
        CharSequence[] n;
        int o;
        int p;
        boolean q;
        String r;
        boolean s;
        String t;
        boolean u;
        boolean v;
        boolean w;
        String x;
        Bundle y;
        int z;

        public Builder(Context context, String str) {
            this.mActions = new ArrayList<>();
            this.j = true;
            this.u = false;
            this.z = 0;
            this.A = 0;
            this.G = 0;
            this.J = 0;
            this.K = new Notification();
            this.mContext = context;
            this.F = str;
            this.K.when = System.currentTimeMillis();
            this.K.audioStreamType = -1;
            this.i = 0;
            this.mPeople = new ArrayList<>();
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.K;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.K;
                notification2.flags = (i ^ (-1)) & notification2.flags;
            }
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.y;
                if (bundle2 == null) {
                    this.y = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.D;
        }

        public int getColor() {
            return this.z;
        }

        public RemoteViews getContentView() {
            return this.C;
        }

        public Bundle getExtras() {
            if (this.y == null) {
                this.y = new Bundle();
            }
            return this.y;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.E;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public int getPriority() {
            return this.i;
        }

        public long getWhenIfShowing() {
            if (this.j) {
                return this.K.when;
            }
            return 0L;
        }

        public Builder setAutoCancel(boolean z) {
            a(16, z);
            return this;
        }

        public Builder setBadgeIconType(int i) {
            this.G = i;
            return this;
        }

        public Builder setCategory(String str) {
            this.x = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.F = str;
            return this;
        }

        public Builder setColor(int i) {
            this.z = i;
            return this;
        }

        public Builder setColorized(boolean z) {
            this.v = z;
            this.w = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.K.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.f938g = a(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.f934c = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.f933b = a(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.f932a = a(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.D = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.C = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.E = remoteViews;
            return this;
        }

        public Builder setDefaults(int i) {
            Notification notification = this.K;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.K.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.y = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.f935d = pendingIntent;
            a(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.r = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i) {
            this.J = i;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.s = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.f937f = bitmap;
            return this;
        }

        public Builder setLights(int i, int i2, int i3) {
            Notification notification = this.K;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            int i4 = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.K;
            notification2.flags = i4 | (notification2.flags & (-2));
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.u = z;
            return this;
        }

        public Builder setNumber(int i) {
            this.f939h = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            a(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            a(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.i = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.o = i;
            this.p = i2;
            this.q = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.B = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.n = charSequenceArr;
            return this;
        }

        public Builder setShortcutId(String str) {
            this.H = str;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.K.icon = i;
            return this;
        }

        public Builder setSortKey(String str) {
            this.t = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.K;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.l != style) {
                this.l = style;
                Style style2 = this.l;
                if (style2 != null) {
                    style2.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.m = a(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.K.tickerText = a(charSequence);
            return this;
        }

        public Builder setTimeoutAfter(long j) {
            this.I = j;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.K.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.A = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.K.when = j;
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            Notification notification = this.K;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.K.tickerText = a(charSequence);
            this.f936e = remoteViews;
            return this;
        }

        protected static CharSequence a(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public Builder setSound(Uri uri, int i) {
            Notification notification = this.K;
            notification.sound = uri;
            notification.audioStreamType = i;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            }
            return this;
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }
    }

    /* loaded from: classes.dex */
    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface StreamType {
    }

    /* loaded from: classes.dex */
    public static final class WearableExtender implements Extender {
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a */
        private ArrayList<Action> f969a;

        /* renamed from: b */
        private int f970b;

        /* renamed from: c */
        private PendingIntent f971c;

        /* renamed from: d */
        private ArrayList<Notification> f972d;

        /* renamed from: e */
        private Bitmap f973e;

        /* renamed from: f */
        private int f974f;

        /* renamed from: g */
        private int f975g;

        /* renamed from: h */
        private int f976h;
        private int i;
        private int j;
        private int k;
        private int l;
        private String m;
        private String n;

        public WearableExtender() {
            this.f969a = new ArrayList<>();
            this.f970b = 1;
            this.f972d = new ArrayList<>();
            this.f975g = GravityCompat.END;
            this.f976h = -1;
            this.i = 0;
            this.k = 80;
        }

        private static Notification.Action a(Action action) {
            Bundle bundle;
            Notification.Action.Builder builder = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
            if (action.getExtras() != null) {
                bundle = new Bundle(action.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (android.app.RemoteInput remoteInput : RemoteInput.a(remoteInputs)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            return builder.build();
        }

        public WearableExtender addAction(Action action) {
            this.f969a.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.f969a.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            this.f972d.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.f972d.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.f969a.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.f972d.clear();
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f969a.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 16) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f969a.size());
                    Iterator<Action> it = this.f969a.iterator();
                    while (it.hasNext()) {
                        Action next = it.next();
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 20) {
                            arrayList.add(a(next));
                        } else if (i >= 16) {
                            arrayList.add(NotificationCompatJellybean.a(next));
                        }
                    }
                    bundle.putParcelableArrayList("actions", arrayList);
                } else {
                    bundle.putParcelableArrayList("actions", null);
                }
            }
            int i2 = this.f970b;
            if (i2 != 1) {
                bundle.putInt("flags", i2);
            }
            PendingIntent pendingIntent = this.f971c;
            if (pendingIntent != null) {
                bundle.putParcelable("displayIntent", pendingIntent);
            }
            if (!this.f972d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.f972d;
                bundle.putParcelableArray(b.s, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f973e;
            if (bitmap != null) {
                bundle.putParcelable("background", bitmap);
            }
            int i3 = this.f974f;
            if (i3 != 0) {
                bundle.putInt("contentIcon", i3);
            }
            int i4 = this.f975g;
            if (i4 != 8388613) {
                bundle.putInt("contentIconGravity", i4);
            }
            int i5 = this.f976h;
            if (i5 != -1) {
                bundle.putInt("contentActionIndex", i5);
            }
            int i6 = this.i;
            if (i6 != 0) {
                bundle.putInt("customSizePreset", i6);
            }
            int i7 = this.j;
            if (i7 != 0) {
                bundle.putInt("customContentHeight", i7);
            }
            int i8 = this.k;
            if (i8 != 80) {
                bundle.putInt("gravity", i8);
            }
            int i9 = this.l;
            if (i9 != 0) {
                bundle.putInt("hintScreenTimeout", i9);
            }
            String str = this.m;
            if (str != null) {
                bundle.putString("dismissalId", str);
            }
            String str2 = this.n;
            if (str2 != null) {
                bundle.putString("bridgeTag", str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.f969a;
        }

        public Bitmap getBackground() {
            return this.f973e;
        }

        public String getBridgeTag() {
            return this.n;
        }

        public int getContentAction() {
            return this.f976h;
        }

        public int getContentIcon() {
            return this.f974f;
        }

        public int getContentIconGravity() {
            return this.f975g;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.f970b & 1) != 0;
        }

        public int getCustomContentHeight() {
            return this.j;
        }

        public int getCustomSizePreset() {
            return this.i;
        }

        public String getDismissalId() {
            return this.m;
        }

        public PendingIntent getDisplayIntent() {
            return this.f971c;
        }

        public int getGravity() {
            return this.k;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.f970b & 32) != 0;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.f970b & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.f970b & 64) != 0;
        }

        public boolean getHintHideIcon() {
            return (this.f970b & 2) != 0;
        }

        public int getHintScreenTimeout() {
            return this.l;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.f970b & 4) != 0;
        }

        public List<Notification> getPages() {
            return this.f972d;
        }

        public boolean getStartScrollBottom() {
            return (this.f970b & 8) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.f973e = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.n = str;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.f976h = i;
            return this;
        }

        public WearableExtender setContentIcon(int i) {
            this.f974f = i;
            return this;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.f975g = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            a(1, z);
            return this;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.j = i;
            return this;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.i = i;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.m = str;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.f971c = pendingIntent;
            return this;
        }

        public WearableExtender setGravity(int i) {
            this.k = i;
            return this;
        }

        public WearableExtender setHintAmbientBigPicture(boolean z) {
            a(32, z);
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            a(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            a(64, z);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            a(2, z);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.l = i;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            a(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            a(8, z);
            return this;
        }

        /* renamed from: clone */
        public WearableExtender m3clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f969a = new ArrayList<>(this.f969a);
            wearableExtender.f970b = this.f970b;
            wearableExtender.f971c = this.f971c;
            wearableExtender.f972d = new ArrayList<>(this.f972d);
            wearableExtender.f973e = this.f973e;
            wearableExtender.f974f = this.f974f;
            wearableExtender.f975g = this.f975g;
            wearableExtender.f976h = this.f976h;
            wearableExtender.i = this.i;
            wearableExtender.j = this.j;
            wearableExtender.k = this.k;
            wearableExtender.l = this.l;
            wearableExtender.m = this.m;
            wearableExtender.n = this.n;
            return wearableExtender;
        }

        public WearableExtender(Notification notification) {
            this.f969a = new ArrayList<>();
            this.f970b = 1;
            this.f972d = new ArrayList<>();
            this.f975g = GravityCompat.END;
            this.f976h = -1;
            this.i = 0;
            this.k = 80;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    Action[] actionArr = new Action[parcelableArrayList.size()];
                    for (int i = 0; i < actionArr.length; i++) {
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 20) {
                            actionArr[i] = NotificationCompat.a((Notification.Action) parcelableArrayList.get(i));
                        } else if (i2 >= 16) {
                            actionArr[i] = NotificationCompatJellybean.a((Bundle) parcelableArrayList.get(i));
                        }
                    }
                    Collections.addAll(this.f969a, actionArr);
                }
                this.f970b = bundle.getInt("flags", 1);
                this.f971c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] a2 = NotificationCompat.a(bundle, b.s);
                if (a2 != null) {
                    Collections.addAll(this.f972d, a2);
                }
                this.f973e = (Bitmap) bundle.getParcelable("background");
                this.f974f = bundle.getInt("contentIcon");
                this.f975g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.f976h = bundle.getInt("contentActionIndex", -1);
                this.i = bundle.getInt("customSizePreset", 0);
                this.j = bundle.getInt("customContentHeight");
                this.k = bundle.getInt("gravity", 80);
                this.l = bundle.getInt("hintScreenTimeout");
                this.m = bundle.getString("dismissalId");
                this.n = bundle.getString("bridgeTag");
            }
        }

        private void a(int i, boolean z) {
            if (z) {
                this.f970b = i | this.f970b;
            } else {
                this.f970b = (i ^ (-1)) & this.f970b;
            }
        }
    }

    static Notification[] a(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Notification[]) && parcelableArray != null) {
            Notification[] notificationArr = new Notification[parcelableArray.length];
            for (int i = 0; i < parcelableArray.length; i++) {
                notificationArr[i] = (Notification) parcelableArray[i];
            }
            bundle.putParcelableArray(str, notificationArr);
            return notificationArr;
        }
        return (Notification[]) parcelableArray;
    }

    public static Action getAction(Notification notification, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return a(notification.actions[i]);
        }
        if (i2 >= 19) {
            Notification.Action action = notification.actions[i];
            SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, sparseParcelableArray != null ? (Bundle) sparseParcelableArray.get(i) : null);
        }
        if (i2 >= 16) {
            return NotificationCompatJellybean.getAction(notification, i);
        }
        return null;
    }

    public static int getActionCount(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19) {
            if (i >= 16) {
                return NotificationCompatJellybean.getActionCount(notification);
            }
            return 0;
        }
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static String getCategory(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static Bundle getExtras(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static String getGroup(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getGroup();
        }
        if (i >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (i >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    public static boolean getLocalOnly(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return (notification.flags & 256) != 0;
        }
        if (i >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        if (i >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        }
        return false;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static String getSortKey(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getSortKey();
        }
        if (i >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (i >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    public static boolean isGroupSummary(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return (notification.flags & 512) != 0;
        }
        if (i >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        if (i >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static final class CarExtender implements Extender {

        /* renamed from: a */
        private Bitmap f940a;

        /* renamed from: b */
        private UnreadConversation f941b;

        /* renamed from: c */
        private int f942c;

        /* loaded from: classes.dex */
        public static class UnreadConversation {

            /* renamed from: a */
            private final String[] f943a;

            /* renamed from: b */
            private final RemoteInput f944b;

            /* renamed from: c */
            private final PendingIntent f945c;

            /* renamed from: d */
            private final PendingIntent f946d;

            /* renamed from: e */
            private final String[] f947e;

            /* renamed from: f */
            private final long f948f;

            /* loaded from: classes.dex */
            public static class Builder {

                /* renamed from: a */
                private final List<String> f949a = new ArrayList();

                /* renamed from: b */
                private final String f950b;

                /* renamed from: c */
                private RemoteInput f951c;

                /* renamed from: d */
                private PendingIntent f952d;

                /* renamed from: e */
                private PendingIntent f953e;

                /* renamed from: f */
                private long f954f;

                public Builder(String str) {
                    this.f950b = str;
                }

                public Builder addMessage(String str) {
                    this.f949a.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.f949a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.f951c, this.f953e, this.f952d, new String[]{this.f950b}, this.f954f);
                }

                public Builder setLatestTimestamp(long j) {
                    this.f954f = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.f952d = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.f951c = remoteInput;
                    this.f953e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f943a = strArr;
                this.f944b = remoteInput;
                this.f946d = pendingIntent2;
                this.f945c = pendingIntent;
                this.f947e = strArr2;
                this.f948f = j;
            }

            public long getLatestTimestamp() {
                return this.f948f;
            }

            public String[] getMessages() {
                return this.f943a;
            }

            public String getParticipant() {
                String[] strArr = this.f947e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.f947e;
            }

            public PendingIntent getReadPendingIntent() {
                return this.f946d;
            }

            public RemoteInput getRemoteInput() {
                return this.f944b;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.f945c;
            }
        }

        public CarExtender() {
            this.f942c = 0;
        }

        private static UnreadConversation a(Bundle bundle) {
            String[] strArr;
            if (bundle == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
            if (parcelableArray != null) {
                String[] strArr2 = new String[parcelableArray.length];
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= strArr2.length) {
                        z = true;
                        break;
                    }
                    if (!(parcelableArray[i] instanceof Bundle)) {
                        break;
                    }
                    strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                    if (strArr2[i] == null) {
                        break;
                    }
                    i++;
                }
                if (!z) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("on_read");
            PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("on_reply");
            android.app.RemoteInput remoteInput = (android.app.RemoteInput) bundle.getParcelable("remote_input");
            String[] stringArray = bundle.getStringArray("participants");
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            return new UnreadConversation(strArr, remoteInput != null ? new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null) : null, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
        }

        @Override // android.support.v4.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f940a;
            if (bitmap != null) {
                bundle.putParcelable("large_icon", bitmap);
            }
            int i = this.f942c;
            if (i != 0) {
                bundle.putInt("app_color", i);
            }
            UnreadConversation unreadConversation = this.f941b;
            if (unreadConversation != null) {
                bundle.putBundle("car_conversation", a(unreadConversation));
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        public int getColor() {
            return this.f942c;
        }

        public Bitmap getLargeIcon() {
            return this.f940a;
        }

        public UnreadConversation getUnreadConversation() {
            return this.f941b;
        }

        public CarExtender setColor(int i) {
            this.f942c = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.f940a = bitmap;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.f941b = unreadConversation;
            return this;
        }

        public CarExtender(Notification notification) {
            this.f942c = 0;
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                this.f940a = (Bitmap) bundle.getParcelable("large_icon");
                this.f942c = bundle.getInt("app_color", 0);
                this.f941b = a(bundle.getBundle("car_conversation"));
            }
        }

        private static Bundle a(UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            Parcelable[] parcelableArr = new Parcelable[unreadConversation.getMessages().length];
            for (int i = 0; i < parcelableArr.length; i++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
            bundle.putParcelable("on_read", unreadConversation.getReadPendingIntent());
            bundle.putStringArray("participants", unreadConversation.getParticipants());
            bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public static class InboxStyle extends Style {

        /* renamed from: e */
        private ArrayList<CharSequence> f955e = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.f955e.add(Builder.a(charSequence));
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f966b);
                if (this.f968d) {
                    bigContentTitle.setSummaryText(this.f967c);
                }
                Iterator<CharSequence> it = this.f955e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.f966b = Builder.a(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.f967c = Builder.a(charSequence);
            this.f968d = true;
            return this;
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;

        /* renamed from: e */
        CharSequence f956e;

        /* renamed from: f */
        CharSequence f957f;

        /* renamed from: g */
        List<Message> f958g = new ArrayList();

        MessagingStyle() {
        }

        private CharSequence a(Message message) {
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = Build.VERSION.SDK_INT >= 21;
            int i = z ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence sender = message.getSender();
            if (TextUtils.isEmpty(message.getSender())) {
                sender = this.f956e;
                if (sender == null) {
                    sender = "";
                }
                if (z && this.f965a.getColor() != 0) {
                    i = this.f965a.getColor();
                }
            }
            CharSequence unicodeWrap = bidiFormatter.unicodeWrap(sender);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(a(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() != null ? message.getText() : ""));
            return spannableStringBuilder;
        }

        private Message b() {
            for (int size = this.f958g.size() - 1; size >= 0; size--) {
                Message message = this.f958g.get(size);
                if (!TextUtils.isEmpty(message.getSender())) {
                    return message;
                }
            }
            if (this.f958g.isEmpty()) {
                return null;
            }
            return this.f958g.get(r0.size() - 1);
        }

        private boolean c() {
            for (int size = this.f958g.size() - 1; size >= 0; size--) {
                if (this.f958g.get(size).getSender() == null) {
                    return true;
                }
            }
            return false;
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)) {
                return null;
            }
            try {
                MessagingStyle messagingStyle = new MessagingStyle();
                messagingStyle.a(extras);
                return messagingStyle;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            CharSequence charSequence = this.f956e;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, charSequence);
            }
            CharSequence charSequence2 = this.f957f;
            if (charSequence2 != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, charSequence2);
            }
            if (this.f958g.isEmpty()) {
                return;
            }
            bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.a(this.f958g));
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.f958g.add(new Message(charSequence, j, charSequence2));
            if (this.f958g.size() > 25) {
                this.f958g.remove(0);
            }
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence text;
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.MessagingStyle conversationTitle = new Notification.MessagingStyle(this.f956e).setConversationTitle(this.f957f);
                for (Message message : this.f958g) {
                    Notification.MessagingStyle.Message message2 = new Notification.MessagingStyle.Message(message.getText(), message.getTimestamp(), message.getSender());
                    if (message.getDataMimeType() != null) {
                        message2.setData(message.getDataMimeType(), message.getDataUri());
                    }
                    conversationTitle.addMessage(message2);
                }
                conversationTitle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message b2 = b();
            if (this.f957f != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.f957f);
            } else if (b2 != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(b2.getSender());
            }
            if (b2 != null) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                if (this.f957f != null) {
                    text = a(b2);
                } else {
                    text = b2.getText();
                }
                builder.setContentText(text);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = this.f957f != null || c();
                for (int size = this.f958g.size() - 1; size >= 0; size--) {
                    Message message3 = this.f958g.get(size);
                    CharSequence a2 = z ? a(message3) : message3.getText();
                    if (size != this.f958g.size() - 1) {
                        spannableStringBuilder.insert(0, (CharSequence) "\n");
                    }
                    spannableStringBuilder.insert(0, a2);
                }
                new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
        }

        public CharSequence getConversationTitle() {
            return this.f957f;
        }

        public List<Message> getMessages() {
            return this.f958g;
        }

        public CharSequence getUserDisplayName() {
            return this.f956e;
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.f957f = charSequence;
            return this;
        }

        public MessagingStyle(CharSequence charSequence) {
            this.f956e = charSequence;
        }

        public MessagingStyle addMessage(Message message) {
            this.f958g.add(message);
            if (this.f958g.size() > 25) {
                this.f958g.remove(0);
            }
            return this;
        }

        /* loaded from: classes.dex */
        public static final class Message {

            /* renamed from: a */
            private final CharSequence f959a;

            /* renamed from: b */
            private final long f960b;

            /* renamed from: c */
            private final CharSequence f961c;

            /* renamed from: d */
            private Bundle f962d = new Bundle();

            /* renamed from: e */
            private String f963e;

            /* renamed from: f */
            private Uri f964f;

            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this.f959a = charSequence;
                this.f960b = j;
                this.f961c = charSequence2;
            }

            private Bundle a() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f959a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f960b);
                CharSequence charSequence2 = this.f961c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("sender", charSequence2);
                }
                String str = this.f963e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f964f;
                if (uri != null) {
                    bundle.putParcelable(ShareConstants.MEDIA_URI, uri);
                }
                Bundle bundle2 = this.f962d;
                if (bundle2 != null) {
                    bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, bundle2);
                }
                return bundle;
            }

            public String getDataMimeType() {
                return this.f963e;
            }

            public Uri getDataUri() {
                return this.f964f;
            }

            public Bundle getExtras() {
                return this.f962d;
            }

            public CharSequence getSender() {
                return this.f961c;
            }

            public CharSequence getText() {
                return this.f959a;
            }

            public long getTimestamp() {
                return this.f960b;
            }

            public Message setData(String str, Uri uri) {
                this.f963e = str;
                this.f964f = uri;
                return this;
            }

            static Bundle[] a(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).a();
                }
                return bundleArr;
            }

            static List<Message> a(Parcelable[] parcelableArr) {
                Message a2;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i = 0; i < parcelableArr.length; i++) {
                    if ((parcelableArr[i] instanceof Bundle) && (a2 = a((Bundle) parcelableArr[i])) != null) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }

            static Message a(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.getCharSequence("sender"));
                        if (bundle.containsKey("type") && bundle.containsKey(ShareConstants.MEDIA_URI)) {
                            message.setData(bundle.getString("type"), (Uri) bundle.getParcelable(ShareConstants.MEDIA_URI));
                        }
                        if (bundle.containsKey(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
                            message.getExtras().putAll(bundle.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY));
                        }
                        return message;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }
        }

        private TextAppearanceSpan a(int i) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
        }

        protected void a(Bundle bundle) {
            this.f958g.clear();
            this.f956e = bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            this.f957f = bundle.getString(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.f958g = Message.a(parcelableArray);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Style {

        /* renamed from: a */
        protected Builder f965a;

        /* renamed from: b */
        CharSequence f966b;

        /* renamed from: c */
        CharSequence f967c;

        /* renamed from: d */
        boolean f968d = false;

        private static float a(float f2, float f3, float f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }

        private Bitmap a(int i, int i2, int i3) {
            Drawable drawable = this.f965a.mContext.getResources().getDrawable(i);
            int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            drawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            }
            drawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public void addCompatExtras(Bundle bundle) {
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x018f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.widget.RemoteViews applyStandardTemplate(boolean r13, int r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 534
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Notification build() {
            Builder builder = this.f965a;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            a(remoteViews);
            remoteViews.removeAllViews(d.notification_main_column);
            remoteViews.addView(d.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(d.notification_main_column, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(d.notification_main_column_container, 0, a(), 0, 0);
            }
        }

        public Bitmap createColoredBitmap(int i, int i2) {
            return a(i, i2, 0);
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void setBuilder(Builder builder) {
            if (this.f965a != builder) {
                this.f965a = builder;
                Builder builder2 = this.f965a;
                if (builder2 != null) {
                    builder2.setStyle(this);
                }
            }
        }

        private Bitmap a(int i, int i2, int i3, int i4) {
            int i5 = c.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap a2 = a(i5, i4, i2);
            Canvas canvas = new Canvas(a2);
            Drawable mutate = this.f965a.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return a2;
        }

        private void a(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(d.title, 8);
            remoteViews.setViewVisibility(d.text2, 8);
            remoteViews.setViewVisibility(d.text, 8);
        }

        private int a() {
            Resources resources = this.f965a.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(b.b.a.b.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(b.b.a.b.notification_top_pad_large_text);
            float a2 = (a(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - a2) * dimensionPixelSize) + (a2 * dimensionPixelSize2));
        }
    }

    static Action a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z;
        android.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i = 0; i < remoteInputs.length; i++) {
                android.app.RemoteInput remoteInput = remoteInputs[i];
                remoteInputArr2[i] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies();
        } else {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        }
        return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, null, z);
    }

    /* loaded from: classes.dex */
    public static class DecoratedCustomViewStyle extends Style {
        private RemoteViews a(RemoteViews remoteViews, boolean z) {
            ArrayList<Action> arrayList;
            int min;
            boolean z2 = true;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, f.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(d.actions);
            if (!z || (arrayList = this.f965a.mActions) == null || (min = Math.min(arrayList.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(d.actions, a(this.f965a.mActions.get(i)));
                }
            }
            int i2 = z2 ? 0 : 8;
            applyStandardTemplate.setViewVisibility(d.actions, i2);
            applyStandardTemplate.setViewVisibility(d.action_divider, i2);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.f965a.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.f965a.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return a(bigContentView, true);
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.f965a.getContentView() != null) {
                return a(this.f965a.getContentView(), false);
            }
            return null;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.f965a.getHeadsUpContentView();
            RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.f965a.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            return a(contentView, true);
        }

        private RemoteViews a(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.f965a.mContext.getPackageName(), z ? f.notification_action_tombstone : f.notification_action);
            remoteViews.setImageViewBitmap(d.action_image, createColoredBitmap(action.getIcon(), this.f965a.mContext.getResources().getColor(a.notification_action_color_filter)));
            remoteViews.setTextViewText(d.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(d.action_container, action.actionIntent);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(d.action_container, action.title);
            }
            return remoteViews;
        }
    }
}
