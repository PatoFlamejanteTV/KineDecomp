package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a */
    private static final WeakHashMap<Context, DisplayManagerCompat> f1173a = new WeakHashMap<>();

    /* loaded from: classes.dex */
    private static class DisplayManagerCompatApi14Impl extends DisplayManagerCompat {

        /* renamed from: b */
        private final WindowManager f1174b;

        DisplayManagerCompatApi14Impl(Context context) {
            this.f1174b = (WindowManager) context.getSystemService("window");
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            Display defaultDisplay = this.f1174b.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return new Display[]{this.f1174b.getDefaultDisplay()};
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    /* loaded from: classes.dex */
    private static class DisplayManagerCompatApi17Impl extends DisplayManagerCompat {

        /* renamed from: b */
        private final DisplayManager f1175b;

        DisplayManagerCompatApi17Impl(Context context) {
            this.f1175b = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            return this.f1175b.getDisplay(i);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return this.f1175b.getDisplays();
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return this.f1175b.getDisplays(str);
        }
    }

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (f1173a) {
            displayManagerCompat = f1173a.get(context);
            if (displayManagerCompat == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new DisplayManagerCompatApi17Impl(context);
                } else {
                    displayManagerCompat = new DisplayManagerCompatApi14Impl(context);
                }
                f1173a.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);
}
