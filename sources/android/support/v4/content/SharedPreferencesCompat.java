package android.support.v4.content;

import android.content.SharedPreferences;

@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    @Deprecated
    /* loaded from: classes.dex */
    public static final class EditorCompat {

        /* renamed from: a */
        private static EditorCompat f1099a;

        /* renamed from: b */
        private final Helper f1100b = new Helper();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Helper {
            Helper() {
            }

            public void apply(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (f1099a == null) {
                f1099a = new EditorCompat();
            }
            return f1099a;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor editor) {
            this.f1100b.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
