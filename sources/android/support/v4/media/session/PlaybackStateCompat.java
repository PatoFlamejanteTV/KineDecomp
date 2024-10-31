package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;

    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;

    /* renamed from: a */
    final int f1503a;

    /* renamed from: b */
    final long f1504b;

    /* renamed from: c */
    final long f1505c;

    /* renamed from: d */
    final float f1506d;

    /* renamed from: e */
    final long f1507e;

    /* renamed from: f */
    final int f1508f;

    /* renamed from: g */
    final CharSequence f1509g;

    /* renamed from: h */
    final long f1510h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<PlaybackStateCompat> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Actions {
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private final List<CustomAction> f1511a;

        /* renamed from: b */
        private int f1512b;

        /* renamed from: c */
        private long f1513c;

        /* renamed from: d */
        private long f1514d;

        /* renamed from: e */
        private float f1515e;

        /* renamed from: f */
        private long f1516f;

        /* renamed from: g */
        private int f1517g;

        /* renamed from: h */
        private CharSequence f1518h;
        private long i;
        private long j;
        private Bundle k;

        public Builder() {
            this.f1511a = new ArrayList();
            this.j = -1L;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f1512b, this.f1513c, this.f1514d, this.f1515e, this.f1516f, this.f1517g, this.f1518h, this.i, this.f1511a, this.j, this.k);
        }

        public Builder setActions(long j) {
            this.f1516f = j;
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.j = j;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.f1514d = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.f1518h = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.k = bundle;
            return this;
        }

        public Builder setState(int i, long j, float f2) {
            return setState(i, j, f2, SystemClock.elapsedRealtime());
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction != null) {
                this.f1511a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
        }

        public Builder setErrorMessage(int i, CharSequence charSequence) {
            this.f1517g = i;
            this.f1518h = charSequence;
            return this;
        }

        public Builder setState(int i, long j, float f2, long j2) {
            this.f1512b = i;
            this.f1513c = j;
            this.i = j2;
            this.f1515e = f2;
            return this;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.f1511a = new ArrayList();
            this.j = -1L;
            this.f1512b = playbackStateCompat.f1503a;
            this.f1513c = playbackStateCompat.f1504b;
            this.f1515e = playbackStateCompat.f1506d;
            this.i = playbackStateCompat.f1510h;
            this.f1514d = playbackStateCompat.f1505c;
            this.f1516f = playbackStateCompat.f1507e;
            this.f1517g = playbackStateCompat.f1508f;
            this.f1518h = playbackStateCompat.f1509g;
            List<CustomAction> list = playbackStateCompat.i;
            if (list != null) {
                this.f1511a.addAll(list);
            }
            this.j = playbackStateCompat.j;
            this.k = playbackStateCompat.k;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ErrorCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface State {
    }

    PlaybackStateCompat(int i, long j, long j2, float f2, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f1503a = i;
        this.f1504b = j;
        this.f1505c = j2;
        this.f1506d = f2;
        this.f1507e = j3;
        this.f1508f = i2;
        this.f1509g = charSequence;
        this.f1510h = j4;
        this.i = new ArrayList(list);
        this.j = j5;
        this.k = bundle;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj);
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            Iterator<Object> it = customActions.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.fromCustomAction(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj), PlaybackStateCompatApi21.getPosition(obj), PlaybackStateCompatApi21.getBufferedPosition(obj), PlaybackStateCompatApi21.getPlaybackSpeed(obj), PlaybackStateCompatApi21.getActions(obj), 0, PlaybackStateCompatApi21.getErrorMessage(obj), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), arrayList, PlaybackStateCompatApi21.getActiveQueueItemId(obj), Build.VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.getExtras(obj) : null);
        playbackStateCompat.l = obj;
        return playbackStateCompat;
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return 126;
        }
        if (j == 2) {
            return 127;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        return j == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.f1507e;
    }

    public long getActiveQueueItemId() {
        return this.j;
    }

    public long getBufferedPosition() {
        return this.f1505c;
    }

    public List<CustomAction> getCustomActions() {
        return this.i;
    }

    public int getErrorCode() {
        return this.f1508f;
    }

    public CharSequence getErrorMessage() {
        return this.f1509g;
    }

    public Bundle getExtras() {
        return this.k;
    }

    public long getLastPositionUpdateTime() {
        return this.f1510h;
    }

    public float getPlaybackSpeed() {
        return this.f1506d;
    }

    public Object getPlaybackState() {
        if (this.l == null && Build.VERSION.SDK_INT >= 21) {
            ArrayList arrayList = null;
            List<CustomAction> list = this.i;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                Iterator<CustomAction> it = this.i.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getCustomAction());
                }
            }
            ArrayList arrayList2 = arrayList;
            if (Build.VERSION.SDK_INT >= 22) {
                this.l = PlaybackStateCompatApi22.newInstance(this.f1503a, this.f1504b, this.f1505c, this.f1506d, this.f1507e, this.f1509g, this.f1510h, arrayList2, this.j, this.k);
            } else {
                this.l = PlaybackStateCompatApi21.newInstance(this.f1503a, this.f1504b, this.f1505c, this.f1506d, this.f1507e, this.f1509g, this.f1510h, arrayList2, this.j);
            }
        }
        return this.l;
    }

    public long getPosition() {
        return this.f1504b;
    }

    public int getState() {
        return this.f1503a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f1503a + ", position=" + this.f1504b + ", buffered position=" + this.f1505c + ", speed=" + this.f1506d + ", updated=" + this.f1510h + ", actions=" + this.f1507e + ", error code=" + this.f1508f + ", error message=" + this.f1509g + ", custom actions=" + this.i + ", active item id=" + this.j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1503a);
        parcel.writeLong(this.f1504b);
        parcel.writeFloat(this.f1506d);
        parcel.writeLong(this.f1510h);
        parcel.writeLong(this.f1505c);
        parcel.writeLong(this.f1507e);
        TextUtils.writeToParcel(this.f1509g, parcel, i);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f1508f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a */
        private final String f1519a;

        /* renamed from: b */
        private final CharSequence f1520b;

        /* renamed from: c */
        private final int f1521c;

        /* renamed from: d */
        private final Bundle f1522d;

        /* renamed from: e */
        private Object f1523e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 */
        /* loaded from: classes.dex */
        static class AnonymousClass1 implements Parcelable.Creator<CustomAction> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            private final String f1524a;

            /* renamed from: b */
            private final CharSequence f1525b;

            /* renamed from: c */
            private final int f1526c;

            /* renamed from: d */
            private Bundle f1527d;

            public Builder(String str, CharSequence charSequence, int i) {
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(charSequence)) {
                        throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                    }
                    if (i != 0) {
                        this.f1524a = str;
                        this.f1525b = charSequence;
                        this.f1526c = i;
                        return;
                    }
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }
                throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
            }

            public CustomAction build() {
                return new CustomAction(this.f1524a, this.f1525b, this.f1526c, this.f1527d);
            }

            public Builder setExtras(Bundle bundle) {
                this.f1527d = bundle;
                return this;
            }
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f1519a = str;
            this.f1520b = charSequence;
            this.f1521c = i;
            this.f1522d = bundle;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(obj), PlaybackStateCompatApi21.CustomAction.getName(obj), PlaybackStateCompatApi21.CustomAction.getIcon(obj), PlaybackStateCompatApi21.CustomAction.getExtras(obj));
            customAction.f1523e = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.f1519a;
        }

        public Object getCustomAction() {
            if (this.f1523e == null && Build.VERSION.SDK_INT >= 21) {
                this.f1523e = PlaybackStateCompatApi21.CustomAction.newInstance(this.f1519a, this.f1520b, this.f1521c, this.f1522d);
                return this.f1523e;
            }
            return this.f1523e;
        }

        public Bundle getExtras() {
            return this.f1522d;
        }

        public int getIcon() {
            return this.f1521c;
        }

        public CharSequence getName() {
            return this.f1520b;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f1520b) + ", mIcon=" + this.f1521c + ", mExtras=" + this.f1522d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1519a);
            TextUtils.writeToParcel(this.f1520b, parcel, i);
            parcel.writeInt(this.f1521c);
            parcel.writeBundle(this.f1522d);
        }

        CustomAction(Parcel parcel) {
            this.f1519a = parcel.readString();
            this.f1520b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1521c = parcel.readInt();
            this.f1522d = parcel.readBundle();
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f1503a = parcel.readInt();
        this.f1504b = parcel.readLong();
        this.f1506d = parcel.readFloat();
        this.f1510h = parcel.readLong();
        this.f1505c = parcel.readLong();
        this.f1507e = parcel.readLong();
        this.f1509g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle();
        this.f1508f = parcel.readInt();
    }
}
