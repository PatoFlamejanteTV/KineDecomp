package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    /* loaded from: classes.dex */
    public static final class Helper {

        /* renamed from: a */
        private final Context f3103a;

        /* renamed from: b */
        private final LayoutInflater f3104b;

        /* renamed from: c */
        private LayoutInflater f3105c;

        public Helper(Context context) {
            this.f3103a = context;
            this.f3104b = LayoutInflater.from(context);
        }

        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.f3105c;
            return layoutInflater != null ? layoutInflater : this.f3104b;
        }

        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.f3105c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.f3105c = null;
            } else if (theme == this.f3103a.getTheme()) {
                this.f3105c = this.f3104b;
            } else {
                this.f3105c = LayoutInflater.from(new ContextThemeWrapper(this.f3103a, theme));
            }
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
