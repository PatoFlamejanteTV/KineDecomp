package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.b.a;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends e implements android.support.v7.e.a {

    /* renamed from: a, reason: collision with root package name */
    static final a f201a;
    private static final boolean b;
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private int G;
    private SearchableInfo H;
    private Bundle I;
    private Runnable J;
    private final Runnable K;
    private Runnable L;
    private final WeakHashMap<String, Drawable.ConstantState> M;
    private final SearchAutoComplete c;
    private final View d;
    private final View e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final Drawable k;
    private final int l;
    private final int m;
    private final Intent n;
    private final Intent o;
    private final CharSequence p;
    private c q;
    private b r;
    private View.OnFocusChangeListener s;
    private d t;
    private View.OnClickListener u;
    private boolean v;
    private boolean w;
    private android.support.v4.widget.b x;
    private boolean y;
    private CharSequence z;

    /* loaded from: classes.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(String str);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    static {
        b = Build.VERSION.SDK_INT >= 8;
        f201a = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.m;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.H = searchableInfo;
        if (this.H != null) {
            if (b) {
                l();
            }
            k();
        }
        this.D = b && e();
        if (this.D) {
            this.c.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.I = bundle;
    }

    public void setImeOptions(int i) {
        this.c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.c.getImeOptions();
    }

    public void setInputType(int i) {
        this.c.setInputType(i);
    }

    public int getInputType() {
        return this.c.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.B || !isFocusable()) {
            return false;
        }
        if (!c()) {
            boolean requestFocus = this.c.requestFocus(i, rect);
            if (requestFocus) {
                a(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.c.clearFocus();
        this.B = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.q = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.r = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.s = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.t = dVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public CharSequence getQuery() {
        return this.c.getText();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.c.setText(charSequence);
        if (charSequence != null) {
            this.c.setSelection(this.c.length());
            this.E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.z = charSequence;
        k();
    }

    public CharSequence getQueryHint() {
        if (this.z != null) {
            return this.z;
        }
        if (b && this.H != null && this.H.getHintId() != 0) {
            return getContext().getText(this.H.getHintId());
        }
        return this.p;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.v != z) {
            this.v = z;
            a(z);
            k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            o();
        } else {
            p();
        }
    }

    public boolean c() {
        return this.w;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.y = z;
        a(c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.A = z;
        if (this.x instanceof j) {
            ((j) this.x).a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(android.support.v4.widget.b bVar) {
        this.x = bVar;
        this.c.setAdapter(this.x);
    }

    public android.support.v4.widget.b getSuggestionsAdapter() {
        return this.x;
    }

    public void setMaxWidth(int i) {
        this.C = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.e, android.view.View
    public void onMeasure(int i, int i2) {
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case NexEditorDeviceProfile.UNKNOWN /* -2147483648 */:
                if (this.C > 0) {
                    size = Math.min(this.C, size);
                    break;
                } else {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                }
            case 0:
                if (this.C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.C;
                    break;
                }
            case 1073741824:
                if (this.C > 0) {
                    size = Math.min(this.C, size);
                    break;
                }
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.c.abc_search_view_preferred_width);
    }

    private void a(boolean z) {
        this.w = z;
        int i = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.c.getText());
        this.f.setVisibility(i);
        b(z2);
        this.d.setVisibility(z ? 8 : 0);
        this.j.setVisibility(this.v ? 8 : 0);
        i();
        c(z2 ? false : true);
        h();
    }

    @TargetApi(8)
    private boolean e() {
        if (this.H == null || !this.H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.H.getVoiceSearchLaunchWebSearch()) {
            intent = this.n;
        } else if (this.H.getVoiceSearchLaunchRecognizer()) {
            intent = this.o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) ? false : true;
    }

    private boolean f() {
        return (this.y || this.D) && !c();
    }

    private void b(boolean z) {
        int i = 8;
        if (this.y && f() && hasFocus() && (z || !this.D)) {
            i = 0;
        }
        this.g.setVisibility(i);
    }

    private void h() {
        int i = 8;
        if (f() && (this.g.getVisibility() == 0 || this.i.getVisibility() == 0)) {
            i = 0;
        }
        this.e.setVisibility(i);
    }

    private void i() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.c.getText());
        if (!z2 && (!this.v || this.F)) {
            z = false;
        }
        this.h.setVisibility(z ? 0 : 8);
        Drawable drawable = this.h.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void j() {
        post(this.K);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.K);
        post(this.L);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImeVisibility(boolean z) {
        if (z) {
            post(this.J);
            return;
        }
        removeCallbacks(this.J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.v && this.k != null) {
            int textSize = (int) (this.c.getTextSize() * 1.25d);
            this.k.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.k), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(b(queryHint));
    }

    @TargetApi(8)
    private void l() {
        this.c.setThreshold(this.H.getSuggestThreshold());
        this.c.setImeOptions(this.H.getImeOptions());
        int inputType = this.H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.H.getSuggestAuthority() != null) {
                inputType = inputType | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST | 524288;
            }
        }
        this.c.setInputType(inputType);
        if (this.x != null) {
            this.x.a((Cursor) null);
        }
        if (this.H.getSuggestAuthority() != null) {
            this.x = new j(getContext(), this, this.H, this.M);
            this.c.setAdapter(this.x);
            ((j) this.x).a(this.A ? 2 : 1);
        }
    }

    private void c(boolean z) {
        int i;
        if (this.D && !c() && z) {
            i = 0;
            this.g.setVisibility(8);
        } else {
            i = 8;
        }
        this.i.setVisibility(i);
    }

    private void m() {
        Editable text = this.c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.q == null || !this.q.a(text.toString())) {
                if (this.H != null) {
                    a(0, null, text.toString());
                }
                setImeVisibility(false);
                n();
            }
        }
    }

    private void n() {
        this.c.dismissDropDown();
    }

    private void o() {
        if (TextUtils.isEmpty(this.c.getText())) {
            if (this.v) {
                if (this.r == null || !this.r.a()) {
                    clearFocus();
                    a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.c.setText("");
        this.c.requestFocus();
        setImeVisibility(true);
    }

    private void p() {
        a(false);
        this.c.requestFocus();
        setImeVisibility(true);
        if (this.u != null) {
            this.u.onClick(this);
        }
    }

    void d() {
        a(c());
        j();
        if (this.c.hasFocus()) {
            q();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        j();
    }

    @Override // android.support.v7.e.a
    public void b() {
        a("", false);
        clearFocus();
        a(true);
        this.c.setImeOptions(this.G);
        this.F = false;
    }

    @Override // android.support.v7.e.a
    public void a() {
        if (!this.F) {
            this.F = true;
            this.G = this.c.getImeOptions();
            this.c.setImeOptions(this.G | 33554432);
            this.c.setText("");
            setIconified(false);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.c.setText(charSequence);
        this.c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.I != null) {
            intent.putExtra("app_data", this.I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (b) {
            intent.setComponent(this.H.getSearchActivity());
        }
        return intent;
    }

    private void q() {
        f201a.a(this.c);
        f201a.b(this.c);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends android.support.v7.widget.c {

        /* renamed from: a, reason: collision with root package name */
        private int f202a;
        private SearchView b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.C0016a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f202a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f202a = i;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.f201a.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.d();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f202a <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        this.b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Method f203a;
        private Method b;
        private Method c;
        private Method d;

        a() {
            try {
                this.f203a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f203a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.d = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                this.d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f203a != null) {
                try {
                    this.f203a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b != null) {
                try {
                    this.b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e) {
                }
            }
        }
    }
}
