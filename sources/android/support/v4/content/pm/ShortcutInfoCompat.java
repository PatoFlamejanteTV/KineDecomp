package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {

    /* renamed from: a */
    private Context f1103a;

    /* renamed from: b */
    private String f1104b;

    /* renamed from: c */
    private Intent[] f1105c;

    /* renamed from: d */
    private ComponentName f1106d;

    /* renamed from: e */
    private CharSequence f1107e;

    /* renamed from: f */
    private CharSequence f1108f;

    /* renamed from: g */
    private CharSequence f1109g;

    /* renamed from: h */
    private IconCompat f1110h;
    private boolean i;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private final ShortcutInfoCompat f1111a = new ShortcutInfoCompat();

        public Builder(Context context, String str) {
            this.f1111a.f1103a = context;
            this.f1111a.f1104b = str;
        }

        public ShortcutInfoCompat build() {
            if (!TextUtils.isEmpty(this.f1111a.f1107e)) {
                if (this.f1111a.f1105c != null && this.f1111a.f1105c.length != 0) {
                    return this.f1111a;
                }
                throw new IllegalArgumentException("Shortcut much have an intent");
            }
            throw new IllegalArgumentException("Shortcut much have a non-empty label");
        }

        public Builder setActivity(ComponentName componentName) {
            this.f1111a.f1106d = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.f1111a.i = true;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.f1111a.f1109g = charSequence;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.f1111a.f1110h = iconCompat;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.f1111a.f1105c = intentArr;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.f1111a.f1108f = charSequence;
            return this;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.f1111a.f1107e = charSequence;
            return this;
        }
    }

    /* synthetic */ ShortcutInfoCompat(AnonymousClass1 anonymousClass1) {
        this();
    }

    public ComponentName getActivity() {
        return this.f1106d;
    }

    public CharSequence getDisabledMessage() {
        return this.f1109g;
    }

    public String getId() {
        return this.f1104b;
    }

    public Intent getIntent() {
        return this.f1105c[r0.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.f1105c;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public CharSequence getLongLabel() {
        return this.f1108f;
    }

    public CharSequence getShortLabel() {
        return this.f1107e;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f1103a, this.f1104b).setShortLabel(this.f1107e).setIntents(this.f1105c);
        IconCompat iconCompat = this.f1110h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon());
        }
        if (!TextUtils.isEmpty(this.f1108f)) {
            intents.setLongLabel(this.f1108f);
        }
        if (!TextUtils.isEmpty(this.f1109g)) {
            intents.setDisabledMessage(this.f1109g);
        }
        ComponentName componentName = this.f1106d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        return intents.build();
    }

    private ShortcutInfoCompat() {
    }

    public Intent a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.f1105c[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f1107e.toString());
        if (this.f1110h != null) {
            Drawable drawable = null;
            if (this.i) {
                PackageManager packageManager = this.f1103a.getPackageManager();
                ComponentName componentName = this.f1106d;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f1103a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f1110h.addToShortcutIntent(intent, drawable);
        }
        return intent;
    }
}
