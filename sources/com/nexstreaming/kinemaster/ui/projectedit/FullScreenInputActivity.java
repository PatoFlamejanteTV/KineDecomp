package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nextreaming.nexeditorui.NexEditText;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.io.File;

/* loaded from: classes.dex */
public class FullScreenInputActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    protected NexEditText f3732a;
    protected InputMethodManager b;
    protected Handler c = new Handler();
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private Toast k;

    /* loaded from: classes.dex */
    public static class a {
        private Context k;

        /* renamed from: a, reason: collision with root package name */
        private boolean f3733a = false;
        private boolean b = false;
        private String c = null;
        private String d = null;
        private String e = null;
        private String f = null;
        private String g = null;
        private String h = null;
        private boolean i = false;
        private boolean j = false;
        private boolean l = false;
        private boolean m = false;

        a(Context context) {
            this.k = context;
        }

        public a a(int i) {
            this.e = this.k.getResources().getString(i);
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public a b(boolean z) {
            this.j = z;
            return this;
        }

        public a c(boolean z) {
            this.f3733a = z;
            return this;
        }

        public a b(String str) {
            this.g = str;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }

        public a e(boolean z) {
            this.m = z;
            return this;
        }

        public a f(boolean z) {
            this.l = z;
            return this;
        }

        public Intent a() {
            Intent intent = new Intent(this.k, (Class<?>) FullScreenInputActivity.class);
            intent.putExtra("multiline", this.f3733a);
            intent.putExtra("positiveLabel", this.c == null ? this.k.getString(R.string.button_ok) : this.c);
            intent.putExtra("negativeLabel", this.d == null ? this.k.getString(R.string.button_cancel) : this.d);
            intent.putExtra("hint", this.e == null ? "" : this.e);
            intent.putExtra("text", this.f == null ? "" : this.f);
            intent.putExtra("showFontButton", this.j);
            intent.putExtra("fontId", this.g == null ? "" : this.g);
            intent.putExtra("effectId", this.h == null ? "" : this.h);
            intent.putExtra("promocode", this.b);
            intent.putExtra("isProjectName", this.i);
            intent.putExtra("cancelIfPreviousValue", this.l);
            intent.putExtra("textDrag", this.m);
            return intent;
        }
    }

    public static a a(Context context) {
        return new a(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Font f;
        Typeface typeface;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.fullscreeninput);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.alpha(100)));
        getWindow().setLayout(-1, -1);
        getWindow().clearFlags(256);
        this.b = (InputMethodManager) getSystemService("input_method");
        this.f3732a = (NexEditText) findViewById(R.id.textinput);
        this.f3732a.setRawInputType(524288);
        if (NexEditorDeviceProfile.getDeviceProfile().getLimitTextInputHeight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3732a.getLayoutParams();
            layoutParams.addRule(12, 0);
            this.f3732a.setLayoutParams(layoutParams);
        }
        this.f3732a.setOnBackKeyListener(new z(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getStringExtra("fontId");
            this.d = intent.getStringExtra("effectId");
            this.f = intent.getBooleanExtra("promocode", false);
            this.g = intent.getBooleanExtra("isProjectName", false);
            this.i = intent.getBooleanExtra("cancelIfPreviousValue", false);
            this.j = intent.getBooleanExtra("textDrag", false);
            this.f3732a.setHint(intent.getStringExtra("hint"));
            this.h = intent.getStringExtra("text");
            this.f3732a.setText(this.h);
            ((Button) findViewById(R.id.button_ok)).setText(intent.getStringExtra("positiveLabel"));
            ((Button) findViewById(R.id.button_cancel)).setText(intent.getStringExtra("negativeLabel"));
            if (this.j) {
                this.f3732a.setSelectAllOnFocus(true);
            }
            if (this.f) {
                this.f3732a.setSingleLine();
                this.f3732a.setInputType(528529);
                this.f3732a.setFilters(new InputFilter[]{new b(), new InputFilter.LengthFilter(16)});
                this.f3732a.setTextSize(1, getResources().getInteger(R.integer.fullscreen_hint_size));
                this.f3732a.setTypeface(Typeface.MONOSPACE);
            }
            if (intent.getBooleanExtra("showFontButton", false)) {
                findViewById(R.id.button_font).setVisibility(0);
                this.f3732a.setPadding(0, 0, getResources().getDimensionPixelOffset(R.dimen.fullscreeninput_font_btn_padding), 0);
            } else {
                findViewById(R.id.button_font).setVisibility(8);
            }
            if (!intent.getBooleanExtra("multiline", false)) {
                this.f3732a.setSingleLine();
            }
        }
        if (bundle != null) {
            this.h = bundle.getString("text");
            this.e = bundle.getString("fontId");
            this.f3732a.setText(this.h);
        }
        if (this.e != null && (f = EffectLibrary.a(getApplicationContext()).f(this.e)) != null) {
            try {
                typeface = f.b(getApplicationContext());
            } catch (Font.TypefaceLoadException e) {
                Log.e("NexFullScnInputActivity", "Failed to get typeface for : " + f.m(), e);
                typeface = null;
            }
            if (typeface != null) {
                this.f3732a.setTypeface(typeface);
            }
        }
        if (this.f3732a != null || !this.f3732a.getText().equals("")) {
            this.f3732a.setSelection(this.f3732a.length());
        }
        findViewById(R.id.button_font).setOnClickListener(new aa(this));
        findViewById(R.id.button_ok).setOnClickListener(new ab(this));
        findViewById(R.id.button_cancel).setOnClickListener(new ac(this));
        this.f3732a.setOnEditorActionListener(new ad(this));
        this.c.postDelayed(new ae(this), 100L);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("text", this.f3732a.getText().toString());
        bundle.putString("fontId", this.e);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Typeface typeface;
        Font.TypefaceLoadException e;
        Font.TypefaceLoadException e2;
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                Font f = EffectLibrary.a(this).f(this.e);
                EffectLibrary.a(this).c(this.d);
                switch (i2) {
                    case -1:
                        String stringExtra = intent.getStringExtra("selected_font_id");
                        try {
                            typeface = EffectLibrary.a(this).f(stringExtra).b(getApplicationContext());
                        } catch (Font.TypefaceLoadException e3) {
                            e2 = e3;
                            typeface = null;
                        }
                        try {
                            this.e = stringExtra;
                        } catch (Font.TypefaceLoadException e4) {
                            e2 = e4;
                            Log.e("NexFullScnInputActivity", "typeface error (OK); revert", e2);
                            this.f3732a.setTypeface(null);
                            this.e = null;
                            this.f3732a.setTypeface(typeface);
                            this.c.postDelayed(new af(this), 100L);
                        }
                    case 0:
                        if (f == null || !f.d()) {
                            this.f3732a.setTypeface(null);
                            this.e = null;
                            typeface = null;
                        } else {
                            Font f2 = EffectLibrary.a(this).f(this.e);
                            try {
                                typeface = f2.b(getApplicationContext());
                            } catch (Font.TypefaceLoadException e5) {
                                e = e5;
                                typeface = null;
                            }
                            try {
                                this.e = f2.m();
                            } catch (Font.TypefaceLoadException e6) {
                                e = e6;
                                Log.e("NexFullScnInputActivity", "typeface error (cancel); revert", e);
                                this.f3732a.setTypeface(null);
                                this.e = null;
                                this.f3732a.setTypeface(typeface);
                                this.c.postDelayed(new af(this), 100L);
                            }
                        }
                        break;
                    case 1:
                        this.f3732a.setTypeface(null);
                        this.e = null;
                        typeface = null;
                        break;
                    default:
                        typeface = null;
                        break;
                }
                this.f3732a.setTypeface(typeface);
                break;
        }
        this.c.postDelayed(new af(this), 100L);
    }

    public static File a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("path");
            if (obj instanceof File) {
                return (File) obj;
            }
            return null;
        }
        return null;
    }

    public static String b(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("text");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public static String c(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("fontId");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public static int a() {
        return R.id.fullscreen_text_input;
    }

    public static int b() {
        return R.id.fullscreen_text_project_title_input;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.f3732a = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = Toast.makeText(this, i, 1);
        this.k.setGravity(49, 0, 0);
        this.k.show();
    }

    /* loaded from: classes.dex */
    private static class b implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            SpannableStringBuilder spannableStringBuilder = null;
            int i5 = 0;
            for (int i6 = i; i6 < i2; i6++) {
                char charAt = charSequence.charAt(i6);
                char a2 = a(charAt);
                if (charAt == a2) {
                    i5++;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder(charSequence, i, i2);
                        i5 = i6 - i;
                    }
                    if (a2 == 0) {
                        spannableStringBuilder.delete(i5, i5 + 1);
                    } else {
                        spannableStringBuilder.replace(i5, i5 + 1, (CharSequence) ("" + a2));
                    }
                }
            }
            return spannableStringBuilder;
        }

        private static char a(char c) {
            if (c >= 'a' && c <= 'z') {
                return (char) (c - ' ');
            }
            if (c >= 'A' && c <= 'Z') {
                return c;
            }
            if (c < '0' || c > '9') {
                return (char) 0;
            }
            return c;
        }
    }
}
