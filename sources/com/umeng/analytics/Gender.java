package com.umeng.analytics;

import com.facebook.internal.AnalyticsEvents;
import java.util.Locale;

/* loaded from: classes3.dex */
public class Gender extends Enum<Gender> {
    public int value;
    public static final Gender Male = new Gender("Male", 0, 1) { // from class: com.umeng.analytics.Gender.1
        AnonymousClass1(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    };
    public static final Gender Female = new Gender("Female", 1, 2) { // from class: com.umeng.analytics.Gender.2
        AnonymousClass2(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    };
    public static final Gender Unknown = new Gender(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 2, 0) { // from class: com.umeng.analytics.Gender.3
        AnonymousClass3(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    };

    /* renamed from: a */
    private static final /* synthetic */ Gender[] f25768a = {Male, Female, Unknown};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.analytics.Gender$1 */
    /* loaded from: classes3.dex */
    public enum AnonymousClass1 extends Gender {
        AnonymousClass1(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$2 */
    /* loaded from: classes3.dex */
    enum AnonymousClass2 extends Gender {
        AnonymousClass2(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$3 */
    /* loaded from: classes3.dex */
    enum AnonymousClass3 extends Gender {
        AnonymousClass3(String str, int i, int i2) {
            super(str, i, i2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$4 */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f25769a = new int[Gender.values().length];

        static {
            try {
                f25769a[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25769a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25769a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* synthetic */ Gender(String str, int i, int i2, AnonymousClass1 anonymousClass1) {
        this(str, i, i2);
    }

    public static Gender getGender(int i) {
        if (i == 1) {
            return Male;
        }
        if (i != 2) {
            return Unknown;
        }
        return Female;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i = AnonymousClass4.f25769a[gender.ordinal()];
        if (i == 1) {
            return com.umeng.commonsdk.statistics.proto.Gender.MALE;
        }
        if (i != 2) {
            return com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN;
        }
        return com.umeng.commonsdk.statistics.proto.Gender.FEMALE;
    }

    public static Gender valueOf(String str) {
        return (Gender) Enum.valueOf(Gender.class, str);
    }

    public static Gender[] values() {
        return (Gender[]) f25768a.clone();
    }

    public int value() {
        return this.value;
    }

    private Gender(String str, int i, int i2) {
        super(str, i);
        this.value = i2;
    }
}
