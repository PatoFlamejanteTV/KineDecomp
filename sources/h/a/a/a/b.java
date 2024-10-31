package h.a.a.a;

import android.R;
import android.os.Build;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CalligraphyConfig.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private static final Map<Class<? extends TextView>, Integer> f26776a = new HashMap();

    /* renamed from: b */
    private static b f26777b;

    /* renamed from: c */
    private final boolean f26778c;

    /* renamed from: d */
    private final String f26779d;

    /* renamed from: e */
    private final int f26780e;

    /* renamed from: f */
    private final boolean f26781f;

    /* renamed from: g */
    private final boolean f26782g;

    /* renamed from: h */
    private final Map<Class<? extends TextView>, Integer> f26783h;

    /* compiled from: CalligraphyConfig.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private boolean f26784a;

        /* renamed from: b */
        private boolean f26785b;

        /* renamed from: c */
        private int f26786c;

        /* renamed from: d */
        private boolean f26787d;

        /* renamed from: e */
        private String f26788e;

        /* renamed from: f */
        private Map<Class<? extends TextView>, Integer> f26789f;

        public a() {
            this.f26784a = Build.VERSION.SDK_INT >= 11;
            this.f26785b = true;
            this.f26786c = j.fontPath;
            this.f26787d = false;
            this.f26788e = null;
            this.f26789f = new HashMap();
        }
    }

    static {
        f26776a.put(TextView.class, Integer.valueOf(R.attr.textViewStyle));
        f26776a.put(Button.class, Integer.valueOf(R.attr.buttonStyle));
        f26776a.put(EditText.class, Integer.valueOf(R.attr.editTextStyle));
        Map<Class<? extends TextView>, Integer> map = f26776a;
        Integer valueOf = Integer.valueOf(R.attr.autoCompleteTextViewStyle);
        map.put(AutoCompleteTextView.class, valueOf);
        f26776a.put(MultiAutoCompleteTextView.class, valueOf);
        f26776a.put(CheckBox.class, Integer.valueOf(R.attr.checkboxStyle));
        f26776a.put(RadioButton.class, Integer.valueOf(R.attr.radioButtonStyle));
        f26776a.put(ToggleButton.class, Integer.valueOf(R.attr.buttonStyleToggle));
    }

    protected b(a aVar) {
        this.f26778c = aVar.f26787d;
        this.f26779d = aVar.f26788e;
        this.f26780e = aVar.f26786c;
        this.f26781f = aVar.f26784a;
        this.f26782g = aVar.f26785b;
        HashMap hashMap = new HashMap(f26776a);
        hashMap.putAll(aVar.f26789f);
        this.f26783h = Collections.unmodifiableMap(hashMap);
    }

    public static b a() {
        if (f26777b == null) {
            f26777b = new b(new a());
        }
        return f26777b;
    }

    public int b() {
        return this.f26780e;
    }

    public Map<Class<? extends TextView>, Integer> c() {
        return this.f26783h;
    }

    public String d() {
        return this.f26779d;
    }

    public boolean e() {
        return this.f26782g;
    }

    public boolean f() {
        return this.f26778c;
    }

    public boolean g() {
        return this.f26781f;
    }
}
