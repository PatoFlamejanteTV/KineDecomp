package android.support.v4.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.support.v4.media.AudioAttributesCompatApi21;
import android.util.SparseIntArray;
import com.umeng.commonsdk.stateless.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesCompat {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;

    /* renamed from: a */
    private static final SparseIntArray f1182a = new SparseIntArray();

    /* renamed from: b */
    private static boolean f1183b;

    /* renamed from: c */
    private static final int[] f1184c;

    /* renamed from: d */
    int f1185d;

    /* renamed from: e */
    int f1186e;

    /* renamed from: f */
    int f1187f;

    /* renamed from: g */
    Integer f1188g;

    /* renamed from: h */
    private AudioAttributesCompatApi21.Wrapper f1189h;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AttributeUsage {
    }

    /* loaded from: classes.dex */
    private static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

        private AudioManagerHidden() {
        }
    }

    static {
        f1182a.put(5, 1);
        f1182a.put(6, 2);
        f1182a.put(7, 2);
        f1182a.put(8, 1);
        f1182a.put(9, 1);
        f1182a.put(10, 1);
        f1184c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    /* synthetic */ AudioAttributesCompat(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int c(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 9:
            default:
                return 0;
            case 10:
                return 11;
        }
    }

    public static void setForceLegacyBehavior(boolean z) {
        f1183b = z;
    }

    public static AudioAttributesCompat wrap(Object obj) {
        if (Build.VERSION.SDK_INT < 21 || f1183b) {
            return null;
        }
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f1189h = AudioAttributesCompatApi21.Wrapper.wrap((AudioAttributes) obj);
        return audioAttributesCompat;
    }

    String b() {
        return b(this.f1185d);
    }

    public boolean equals(Object obj) {
        AudioAttributesCompatApi21.Wrapper wrapper;
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributesCompat.class != obj.getClass()) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        if (Build.VERSION.SDK_INT >= 21 && !f1183b && (wrapper = this.f1189h) != null) {
            return wrapper.unwrap().equals(audioAttributesCompat.unwrap());
        }
        if (this.f1186e == audioAttributesCompat.getContentType() && this.f1187f == audioAttributesCompat.getFlags() && this.f1185d == audioAttributesCompat.getUsage()) {
            Integer num = this.f1188g;
            if (num != null) {
                if (num.equals(audioAttributesCompat.f1188g)) {
                    return true;
                }
            } else if (audioAttributesCompat.f1188g == null) {
                return true;
            }
        }
        return false;
    }

    public int getContentType() {
        AudioAttributesCompatApi21.Wrapper wrapper;
        if (Build.VERSION.SDK_INT >= 21 && !f1183b && (wrapper = this.f1189h) != null) {
            return wrapper.unwrap().getContentType();
        }
        return this.f1186e;
    }

    public int getFlags() {
        AudioAttributesCompatApi21.Wrapper wrapper;
        if (Build.VERSION.SDK_INT >= 21 && !f1183b && (wrapper = this.f1189h) != null) {
            return wrapper.unwrap().getFlags();
        }
        int i = this.f1187f;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i |= 4;
        } else if (legacyStreamType == 7) {
            i |= 1;
        }
        return i & d.f26335a;
    }

    public int getLegacyStreamType() {
        Integer num = this.f1188g;
        if (num != null) {
            return num.intValue();
        }
        if (Build.VERSION.SDK_INT >= 21 && !f1183b) {
            return AudioAttributesCompatApi21.toLegacyStreamType(this.f1189h);
        }
        return a(false, this.f1187f, this.f1185d);
    }

    public int getUsage() {
        AudioAttributesCompatApi21.Wrapper wrapper;
        if (Build.VERSION.SDK_INT >= 21 && !f1183b && (wrapper = this.f1189h) != null) {
            return wrapper.unwrap().getUsage();
        }
        return this.f1185d;
    }

    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT >= 26 && !f1183b && unwrap() != null) {
            return ((AudioAttributes) unwrap()).getVolumeControlStream();
        }
        return a(true, this);
    }

    public int hashCode() {
        AudioAttributesCompatApi21.Wrapper wrapper;
        return (Build.VERSION.SDK_INT < 21 || f1183b || (wrapper = this.f1189h) == null) ? Arrays.hashCode(new Object[]{Integer.valueOf(this.f1186e), Integer.valueOf(this.f1187f), Integer.valueOf(this.f1185d), this.f1188g}) : wrapper.unwrap().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (unwrap() != null) {
            sb.append(" audioattributes=");
            sb.append(unwrap());
        } else {
            if (this.f1188g != null) {
                sb.append(" stream=");
                sb.append(this.f1188g);
                sb.append(" derived");
            }
            sb.append(" usage=");
            sb.append(b());
            sb.append(" content=");
            sb.append(this.f1186e);
            sb.append(" flags=0x");
            sb.append(Integer.toHexString(this.f1187f).toUpperCase());
        }
        return sb.toString();
    }

    public Object unwrap() {
        AudioAttributesCompatApi21.Wrapper wrapper = this.f1189h;
        if (wrapper != null) {
            return wrapper.unwrap();
        }
        return null;
    }

    private AudioAttributesCompat() {
        this.f1185d = 0;
        this.f1186e = 0;
        this.f1187f = 0;
    }

    static String b(int i) {
        switch (i) {
            case 0:
                return new String("USAGE_UNKNOWN");
            case 1:
                return new String("USAGE_MEDIA");
            case 2:
                return new String("USAGE_VOICE_COMMUNICATION");
            case 3:
                return new String("USAGE_VOICE_COMMUNICATION_SIGNALLING");
            case 4:
                return new String("USAGE_ALARM");
            case 5:
                return new String("USAGE_NOTIFICATION");
            case 6:
                return new String("USAGE_NOTIFICATION_RINGTONE");
            case 7:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_REQUEST");
            case 8:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_INSTANT");
            case 9:
                return new String("USAGE_NOTIFICATION_COMMUNICATION_DELAYED");
            case 10:
                return new String("USAGE_NOTIFICATION_EVENT");
            case 11:
                return new String("USAGE_ASSISTANCE_ACCESSIBILITY");
            case 12:
                return new String("USAGE_ASSISTANCE_NAVIGATION_GUIDANCE");
            case 13:
                return new String("USAGE_ASSISTANCE_SONIFICATION");
            case 14:
                return new String("USAGE_GAME");
            case 15:
            default:
                return new String("unknown usage " + i);
            case 16:
                return new String("USAGE_ASSISTANT");
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private int f1190a;

        /* renamed from: b */
        private int f1191b;

        /* renamed from: c */
        private int f1192c;

        /* renamed from: d */
        private Integer f1193d;

        /* renamed from: e */
        private Object f1194e;

        public Builder() {
            this.f1190a = 0;
            this.f1191b = 0;
            this.f1192c = 0;
        }

        public AudioAttributesCompat build() {
            if (!AudioAttributesCompat.f1183b && Build.VERSION.SDK_INT >= 21) {
                Object obj = this.f1194e;
                if (obj != null) {
                    return AudioAttributesCompat.wrap(obj);
                }
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f1191b).setFlags(this.f1192c).setUsage(this.f1190a);
                Integer num = this.f1193d;
                if (num != null) {
                    usage.setLegacyStreamType(num.intValue());
                }
                return AudioAttributesCompat.wrap(usage.build());
            }
            AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
            audioAttributesCompat.f1186e = this.f1191b;
            audioAttributesCompat.f1187f = this.f1192c;
            audioAttributesCompat.f1185d = this.f1190a;
            audioAttributesCompat.f1188g = this.f1193d;
            audioAttributesCompat.f1189h = null;
            return audioAttributesCompat;
        }

        public Builder setContentType(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
                this.f1190a = 0;
            } else {
                this.f1191b = i;
            }
            return this;
        }

        public Builder setFlags(int i) {
            this.f1192c = (i & 1023) | this.f1192c;
            return this;
        }

        public Builder setLegacyStreamType(int i) {
            if (i != 10) {
                this.f1193d = Integer.valueOf(i);
                this.f1190a = AudioAttributesCompat.c(i);
                return this;
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f1190a = i;
                    return this;
                case 16:
                    if (!AudioAttributesCompat.f1183b && Build.VERSION.SDK_INT > 25) {
                        this.f1190a = i;
                    } else {
                        this.f1190a = 12;
                    }
                    return this;
                default:
                    this.f1190a = 0;
                    return this;
            }
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f1190a = 0;
            this.f1191b = 0;
            this.f1192c = 0;
            this.f1190a = audioAttributesCompat.f1185d;
            this.f1191b = audioAttributesCompat.f1186e;
            this.f1192c = audioAttributesCompat.f1187f;
            this.f1193d = audioAttributesCompat.f1188g;
            this.f1194e = audioAttributesCompat.unwrap();
        }
    }

    static int a(boolean z, AudioAttributesCompat audioAttributesCompat) {
        return a(z, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage());
    }

    static int a(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
        }
    }
}
