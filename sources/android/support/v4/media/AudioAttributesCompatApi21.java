package android.support.v4.media;

import android.media.AudioAttributes;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class AudioAttributesCompatApi21 {

    /* renamed from: a */
    private static Method f1195a;

    /* loaded from: classes.dex */
    public static final class Wrapper {

        /* renamed from: a */
        private AudioAttributes f1196a;

        private Wrapper(AudioAttributes audioAttributes) {
            this.f1196a = audioAttributes;
        }

        public static Wrapper wrap(AudioAttributes audioAttributes) {
            if (audioAttributes != null) {
                return new Wrapper(audioAttributes);
            }
            throw new IllegalArgumentException("AudioAttributesApi21.Wrapper cannot wrap null");
        }

        public AudioAttributes unwrap() {
            return this.f1196a;
        }
    }

    AudioAttributesCompatApi21() {
    }

    public static int toLegacyStreamType(Wrapper wrapper) {
        AudioAttributes unwrap = wrapper.unwrap();
        try {
            if (f1195a == null) {
                f1195a = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            return ((Integer) f1195a.invoke(null, unwrap)).intValue();
        } catch (ClassCastException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            Log.w("AudioAttributesCompat", "getLegacyStreamType() failed on API21+", e2);
            return -1;
        }
    }
}
