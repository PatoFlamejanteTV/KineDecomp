package com.nexstreaming.app.general.nexasset.assetpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nexstreaming.app.general.util.B;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class AssetPackageReader implements Closeable {

    /* renamed from: a */
    private static Map<String, WeakReference<AssetPackageReader>> f19499a = new HashMap();

    /* renamed from: b */
    private static Map<String, com.nexstreaming.app.general.nexasset.assetpackage.a.b> f19500b = new HashMap();

    /* renamed from: c */
    private static final LruCache<String, Typeface> f19501c = new LruCache<>(c.d.b.b.i.d().f());

    /* renamed from: d */
    private c f19502d;

    /* renamed from: f */
    private final PackageInfoJSON f19504f;

    /* renamed from: h */
    private final String f19506h;
    private final boolean i;

    /* renamed from: e */
    private final Gson f19503e = new Gson();
    private List<r> j = null;
    private Map<String, String> l = null;
    private Map<String, String> m = null;

    /* renamed from: g */
    private final EncryptionInfoJSON f19505g = y();
    private final com.nexstreaming.app.general.nexasset.assetpackage.a.a k = a(this.f19505g);

    /* loaded from: classes2.dex */
    public static class EncryptionInfoJSON {
        public String provider;
        public String psd;

        private EncryptionInfoJSON() {
        }
    }

    /* loaded from: classes2.dex */
    public static class ItemInfoJSON {
        public String filename;
        public boolean hidden;
        public String icon;
        public String id;
        public Map<String, String> label;
        public List<String> mergePaths;
        public List<String> ratios;
        public String sampleText;
        public String thumbnail;
        public String type;

        private ItemInfoJSON() {
        }
    }

    /* loaded from: classes2.dex */
    public static class LocalPathNotAvailableException extends IOException {
        public LocalPathNotAvailableException() {
        }

        public LocalPathNotAvailableException(String str) {
            super(str);
        }

        public LocalPathNotAvailableException(String str, Throwable th) {
            super(str, th);
        }

        public LocalPathNotAvailableException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public static class PackageInfoJSON {
        public String assetLevel;
        public Map<String, String> assetName;
        public String format;
        public List<String> itemRoots;
        public int minVersionCode;
        public int packageContentVersion;
        public int targetVersionCode;

        private PackageInfoJSON() {
        }
    }

    /* loaded from: classes2.dex */
    public static class PackageReaderException extends IOException {
        PackageReaderException() {
        }

        PackageReaderException(AssetPackageReader assetPackageReader, String str) {
            super(str + " (in package '" + assetPackageReader.v() + "' via " + assetPackageReader.getClass().getSimpleName() + ")");
        }

        PackageReaderException(AssetPackageReader assetPackageReader, String str, Throwable th) {
            super(str + " (in package '" + assetPackageReader.v() + "' via " + assetPackageReader.getClass().getSimpleName() + ")", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends WeakReference<AssetPackageReader> {

        /* renamed from: a */
        private static ReferenceQueue<AssetPackageReader> f19507a = new ReferenceQueue<>();

        /* renamed from: b */
        private c f19508b;

        public a(AssetPackageReader assetPackageReader) {
            super(assetPackageReader, f19507a);
            this.f19508b = assetPackageReader.w();
        }

        public static void b() {
            while (true) {
                a aVar = (a) f19507a.poll();
                if (aVar == null) {
                    return;
                }
                c cVar = aVar.f19508b;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused) {
                    }
                    aVar.f19508b = null;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements c {

        /* renamed from: a */
        private final String f19509a;

        /* renamed from: b */
        private AssetManager f19510b;

        /* synthetic */ b(AssetManager assetManager, String str, i iVar) {
            this(assetManager, str);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b() {
            return null;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public InputStream c(String str) throws IOException {
            return this.f19510b.open(AssetPackageReader.b(this.f19509a, str));
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public void close() {
            this.f19510b = null;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public String getPackageURI() {
            return "assets:" + this.f19509a;
        }

        private b(AssetManager assetManager, String str) {
            if (assetManager == null) {
                throw new IllegalArgumentException();
            }
            if (str != null) {
                this.f19509a = str;
                this.f19510b = assetManager;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Iterable<String> a() {
            return new k(this);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b(String str) throws IOException {
            throw new LocalPathNotAvailableException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Typeface a(String str) {
            return Typeface.createFromAsset(this.f19510b, AssetPackageReader.b(this.f19509a, str));
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        Typeface a(String str) throws LocalPathNotAvailableException;

        Iterable<String> a();

        File b();

        File b(String str) throws IOException;

        InputStream c(String str) throws IOException;

        void close() throws IOException;

        String getPackageURI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements c {

        /* renamed from: a */
        private final c f19511a;

        /* renamed from: b */
        private final com.nexstreaming.app.general.nexasset.assetpackage.a.a f19512b;

        /* synthetic */ d(c cVar, com.nexstreaming.app.general.nexasset.assetpackage.a.a aVar, i iVar) {
            this(cVar, aVar);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Iterable<String> a() {
            return this.f19511a.a();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b(String str) throws IOException {
            if (this.f19512b.a(str)) {
                return this.f19511a.b(str);
            }
            throw new LocalPathNotAvailableException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public InputStream c(String str) throws IOException {
            return this.f19512b.a(this.f19511a.c(str), str);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public void close() throws IOException {
            this.f19511a.close();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public String getPackageURI() {
            return this.f19511a.getPackageURI();
        }

        private d(c cVar, com.nexstreaming.app.general.nexasset.assetpackage.a.a aVar) {
            this.f19511a = cVar;
            this.f19512b = aVar;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Typeface a(String str) throws LocalPathNotAvailableException {
            if (this.f19512b.a(str)) {
                return this.f19511a.a(str);
            }
            throw new LocalPathNotAvailableException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b() {
            return this.f19511a.b();
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements c {

        /* renamed from: a */
        private final File f19513a;

        /* synthetic */ e(File file, i iVar) {
            this(file);
        }

        private File d(String str) {
            return new File(this.f19513a, str);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b(String str) {
            return d(str);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public InputStream c(String str) throws IOException {
            return new FileInputStream(d(str));
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public void close() {
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public String getPackageURI() {
            return "file:" + this.f19513a.getAbsolutePath();
        }

        private e(File file) {
            this.f19513a = file;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b() {
            return this.f19513a;
        }

        public String b(File file) {
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = this.f19513a.getAbsolutePath();
            if (absolutePath.startsWith(absolutePath2)) {
                if (absolutePath.length() <= absolutePath2.length()) {
                    return "";
                }
                if (absolutePath.charAt(absolutePath2.length()) == '/') {
                    return absolutePath.substring(absolutePath2.length() + 1);
                }
                return absolutePath.substring(absolutePath2.length());
            }
            throw new IllegalStateException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Typeface a(String str) {
            Typeface typeface = (Typeface) AssetPackageReader.f19501c.get(str);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromFile(d(str));
                } catch (RuntimeException unused) {
                    typeface = a(d(str));
                }
                if (typeface != null) {
                    AssetPackageReader.f19501c.put(str, typeface);
                }
            }
            return typeface;
        }

        private Typeface a(File file) {
            File file2 = new File(KineMasterApplication.f24056d.getExternalCacheDir(), String.valueOf("font-temp".hashCode()));
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        file2.createNewFile();
                    } catch (IOException unused) {
                    }
                    a(file2, file);
                    Typeface createFromFile = Typeface.createFromFile(file2.getAbsolutePath());
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return createFromFile;
                } catch (RuntimeException unused2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("max_font_number", String.valueOf(AssetPackageReader.f19501c.maxSize()));
                    KMEvents.NEED_MORE_FONT.logEvent(hashMap);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (file2.exists()) {
                    file2.delete();
                }
                throw th;
            }
        }

        private static void a(File file, File file2) {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        a(fileInputStream2);
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("AssetPackageReader", "Error copying resource contents to temp file: " + e.getMessage());
                            a(fileInputStream);
                            a(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            a(fileInputStream);
                            a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            a(fileOutputStream);
        }

        private static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Iterable<String> a() {
            return new m(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class f implements r {

        /* renamed from: a */
        Class<? extends c> f19514a;

        /* renamed from: b */
        String f19515b;

        /* renamed from: c */
        String f19516c;

        /* renamed from: d */
        String f19517d;

        /* renamed from: e */
        String f19518e;

        /* renamed from: f */
        String f19519f;

        /* renamed from: g */
        String f19520g;

        /* renamed from: h */
        Map<String, String> f19521h;
        ItemType i;
        ItemCategory j;
        List<String> k;
        boolean l;

        private f() {
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public com.nexstreaming.app.general.nexasset.assetpackage.b getAssetPackage() {
            throw new UnsupportedOperationException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public ItemCategory getCategory() {
            return this.j;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getFilePath() {
            return this.f19516c;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getIconPath() {
            return this.f19517d;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getId() {
            return this.f19519f;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public Map<String, String> getLabel() {
            return this.f19521h;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getPackageURI() {
            return this.f19515b;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public List<String> getRatios() {
            return this.k;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getSampleText() {
            return this.f19520g;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public String getThumbPath() {
            return this.f19518e;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public ItemType getType() {
            return this.i;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.r
        public boolean isHidden() {
            return this.l;
        }

        /* synthetic */ f(i iVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements c {

        /* renamed from: a */
        private final ZipFile f19522a;

        /* renamed from: b */
        private final File f19523b;

        public g(File file) throws IOException {
            this.f19522a = new ZipFile(file);
            this.f19523b = file;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b(String str) throws IOException {
            throw new LocalPathNotAvailableException();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public InputStream c(String str) throws IOException {
            ZipEntry entry = this.f19522a.getEntry(str);
            if (entry == null && (entry = this.f19522a.getEntry(B.a(B.a(str), B.c(str).toLowerCase(Locale.ENGLISH)))) == null) {
                throw new FileNotFoundException("File '" + str + "' not found in '" + this.f19522a.getName() + "'");
            }
            return this.f19522a.getInputStream(entry);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public void close() throws IOException {
            this.f19522a.close();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public String getPackageURI() {
            return "zipfile:" + this.f19522a.getName();
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Iterable<String> a() {
            return new o(this);
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public File b() {
            return this.f19523b;
        }

        @Override // com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.c
        public Typeface a(String str) throws LocalPathNotAvailableException {
            throw new LocalPathNotAvailableException();
        }
    }

    private AssetPackageReader(c cVar, String str, boolean z) throws IOException {
        this.f19502d = cVar;
        this.f19506h = str;
        this.i = z;
        com.nexstreaming.app.general.nexasset.assetpackage.a.a aVar = this.k;
        if (aVar != null) {
            this.f19502d = new d(cVar, aVar);
        }
        this.f19504f = z();
    }

    public static AssetPackageReader b(File file, String str) throws IOException {
        return new AssetPackageReader(new g(file), str, false);
    }

    private r h(String str) throws IOException {
        ItemCategory itemCategory;
        if (!str.endsWith("/_info.json")) {
            return null;
        }
        int indexOf = str.indexOf(47);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(47, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = str.indexOf(47, i2);
        if (indexOf != -1 && indexOf2 != -1 && indexOf3 == -1) {
            if (str.startsWith("merge/")) {
                return null;
            }
            ItemCategory[] values = ItemCategory.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    itemCategory = null;
                    break;
                }
                itemCategory = values[i3];
                String name = itemCategory.name();
                if (name.length() == indexOf && str.startsWith(name)) {
                    break;
                }
                i3++;
            }
            if (itemCategory == null) {
                Log.w("AssetPackageReader", "Unrecognized item category");
                return null;
            }
            String substring = str.substring(i, indexOf2);
            String substring2 = str.substring(0, i2);
            try {
                InputStream c2 = this.f19502d.c(str);
                try {
                    ItemInfoJSON itemInfoJSON = (ItemInfoJSON) this.f19503e.fromJson((Reader) new InputStreamReader(c2), ItemInfoJSON.class);
                    if (itemInfoJSON != null && itemInfoJSON.label != null && itemInfoJSON.label.size() > 0) {
                        Set<String> keySet = itemInfoJSON.label.keySet();
                        HashMap hashMap = new HashMap();
                        for (String str2 : keySet) {
                            hashMap.put(str2.toLowerCase(Locale.ENGLISH), itemInfoJSON.label.get(str2));
                        }
                        itemInfoJSON.label.clear();
                        itemInfoJSON.label.putAll(hashMap);
                    }
                    if (itemInfoJSON.filename != null) {
                        if (itemInfoJSON.icon == null) {
                            itemInfoJSON.icon = "_icon.svg";
                        }
                        if (itemInfoJSON.thumbnail == null) {
                            itemInfoJSON.thumbnail = "_thumb.jpeg";
                        }
                        if (itemInfoJSON.id == null) {
                            itemInfoJSON.id = this.f19506h + ".items." + substring;
                        }
                        ItemType fromId = ItemType.fromId(itemInfoJSON.type);
                        if (fromId != null) {
                            f fVar = new f();
                            fVar.f19514a = this.f19502d.getClass();
                            fVar.f19515b = this.f19502d.getPackageURI();
                            fVar.f19516c = b(substring2, itemInfoJSON.filename);
                            fVar.f19517d = b(substring2, itemInfoJSON.icon);
                            fVar.f19518e = b(substring2, itemInfoJSON.thumbnail);
                            fVar.f19519f = itemInfoJSON.id;
                            fVar.f19521h = itemInfoJSON.label;
                            fVar.i = fromId;
                            fVar.j = itemCategory;
                            fVar.f19520g = itemInfoJSON.sampleText;
                            fVar.l = itemInfoJSON.hidden;
                            fVar.k = itemInfoJSON.ratios;
                            return fVar;
                        }
                        throw new PackageReaderException(this, "Unrecognized item type '" + itemInfoJSON.type + "' for: " + str);
                    }
                    throw new PackageReaderException(this, "Missing base file for: " + str);
                } finally {
                    c2.close();
                }
            } catch (JsonSyntaxException e2) {
                throw new PackageReaderException(this, "JSON Syntax Error in: " + str, e2);
            } catch (FileNotFoundException e3) {
                Log.w("AssetPackageReader", "Item in index but missing in package", e3);
                return null;
            }
        }
        Log.w("AssetPackageReader", "Malformed path");
        return null;
    }

    public c w() {
        return this.f19502d;
    }

    private void x() throws IOException {
        r h2;
        r h3;
        if (this.j != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<String> list = this.f19504f.itemRoots;
        if (list != null && list.size() > 0) {
            for (String str : this.f19504f.itemRoots) {
                if (str != null && (h3 = h(b(str, "_info.json"))) != null) {
                    arrayList.add(h3);
                }
            }
        } else {
            for (String str2 : this.f19502d.a()) {
                if (str2 != null && (h2 = h(str2)) != null) {
                    arrayList.add(h2);
                }
            }
        }
        this.j = arrayList;
    }

    private EncryptionInfoJSON y() throws IOException {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = this.f19502d.c("e.json");
        } catch (FileNotFoundException unused) {
            inputStream = null;
        } catch (Throwable th2) {
            inputStream = null;
            th = th2;
        }
        try {
            EncryptionInfoJSON encryptionInfoJSON = (EncryptionInfoJSON) this.f19503e.fromJson((Reader) new InputStreamReader(inputStream), EncryptionInfoJSON.class);
            C1702f.a(inputStream);
            return encryptionInfoJSON;
        } catch (FileNotFoundException unused2) {
            C1702f.a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C1702f.a(inputStream);
            throw th;
        }
    }

    private PackageInfoJSON z() throws IOException {
        try {
            InputStream c2 = this.f19502d.c("packageinfo.json");
            try {
                PackageInfoJSON packageInfoJSON = (PackageInfoJSON) this.f19503e.fromJson((Reader) new InputStreamReader(c2), PackageInfoJSON.class);
                if (packageInfoJSON.assetName != null && packageInfoJSON.assetName.size() > 0) {
                    Set<String> keySet = packageInfoJSON.assetName.keySet();
                    HashMap hashMap = new HashMap();
                    for (String str : keySet) {
                        hashMap.put(str.toLowerCase(Locale.ENGLISH), packageInfoJSON.assetName.get(str));
                    }
                    packageInfoJSON.assetName.clear();
                    packageInfoJSON.assetName.putAll(hashMap);
                }
                if (TextUtils.isEmpty(packageInfoJSON.assetLevel)) {
                    packageInfoJSON.assetLevel = "1";
                }
                if (packageInfoJSON.minVersionCode <= 6) {
                    String str2 = packageInfoJSON.format;
                    if (str2 != null) {
                        if (str2.equals("com.kinemaster.assetpackage")) {
                            return packageInfoJSON;
                        }
                        Log.w("AssetPackageReader", "Unsupported package format: " + packageInfoJSON.format);
                        throw new PackageReaderException(this, "Unsupported package format: " + packageInfoJSON.format);
                    }
                    Log.w("AssetPackageReader", "Missing package format");
                    throw new PackageReaderException(this, "Missing package format");
                }
                Log.w("AssetPackageReader", "Unsupported package format version: " + packageInfoJSON.minVersionCode);
                throw new PackageReaderException(this, "Unsupported package format version");
            } finally {
                c2.close();
            }
        } catch (JsonSyntaxException e2) {
            Log.w("AssetPackageReader", "PackageInfoJSON file : packageinfo.json", e2);
            throw new PackageReaderException(this, "PackageInfoJSON file: packageinfo.json", e2);
        } catch (FileNotFoundException e3) {
            Log.w("AssetPackageReader", "Package missing file: packageinfo.json", e3);
            throw new PackageReaderException(this, "Package missing file: packageinfo.json", e3);
        }
    }

    public Map<String, String> c() {
        return this.f19504f.assetName;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.i) {
            return;
        }
        this.f19502d.close();
    }

    public File e(String str) throws IOException {
        return this.f19502d.b(str);
    }

    public Typeface f(String str) throws LocalPathNotAvailableException {
        return this.f19502d.a(str);
    }

    public InputStream g(String str) throws IOException {
        InputStream inputStream;
        ItemInfoJSON itemInfoJSON;
        String str2;
        Map<String, String> map = this.l;
        if (map != null && (str2 = map.get(str)) != null && str2.length() > 0) {
            return this.f19502d.c(str2);
        }
        try {
            return this.f19502d.c(str);
        } catch (FileNotFoundException e2) {
            String a2 = B.a(str);
            ItemInfoJSON itemInfoJSON2 = null;
            while (true) {
                if (a2 == null) {
                    break;
                }
                try {
                    inputStream = this.f19502d.c(B.b(a2, "_info.json"));
                } catch (FileNotFoundException unused) {
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                try {
                    itemInfoJSON = (ItemInfoJSON) this.f19503e.fromJson((Reader) new InputStreamReader(inputStream), ItemInfoJSON.class);
                } catch (FileNotFoundException unused2) {
                    C1702f.a(inputStream);
                    a2 = B.d(a2);
                } catch (Throwable th2) {
                    th = th2;
                    C1702f.a(inputStream);
                    throw th;
                }
                if (itemInfoJSON != null) {
                    C1702f.a(inputStream);
                    itemInfoJSON2 = itemInfoJSON;
                    break;
                }
                C1702f.a(inputStream);
                itemInfoJSON2 = itemInfoJSON;
                a2 = B.d(a2);
            }
            if (itemInfoJSON2 != null && itemInfoJSON2.mergePaths != null) {
                String substring = str.substring(a2.length(), str.length());
                for (String str3 : itemInfoJSON2.mergePaths) {
                    if (str3 != null) {
                        String a3 = B.a("merge", str3.trim());
                        if (!a3.endsWith("/")) {
                            a3 = a3 + "/";
                        }
                        if (a3.length() > 0) {
                            String b2 = B.b(a3, substring);
                            try {
                                InputStream c2 = this.f19502d.c(b2);
                                if (this.l == null) {
                                    this.l = new HashMap();
                                }
                                this.l.put(str, b2);
                                return c2;
                            } catch (FileNotFoundException unused3) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            throw e2;
        }
    }

    public File r() {
        return this.f19502d.b();
    }

    public List<r> s() throws IOException {
        x();
        return this.j;
    }

    public int u() {
        return this.f19504f.packageContentVersion;
    }

    public String v() {
        return this.f19502d.getPackageURI();
    }

    public String b() {
        return this.f19504f.assetLevel;
    }

    public static String b(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            return str + "/" + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    public static void a(com.nexstreaming.app.general.nexasset.assetpackage.a.b bVar) {
        String providerId = bVar.getProviderId();
        if (providerId != null && providerId.length() >= 1) {
            if (f19500b.get(providerId) != null) {
                Log.d("AssetPackageReader", "This provider ID is already registered! " + providerId);
                return;
            }
            if (f19500b.values().contains(bVar)) {
                Log.d("AssetPackageReader", "This provider is already registered! ");
                return;
            } else {
                f19500b.put(providerId, bVar);
                return;
            }
        }
        throw new IllegalArgumentException("id is null or empty");
    }

    public static AssetPackageReader a(File file, String str) throws IOException {
        return new AssetPackageReader(new e(file), str, false);
    }

    public static AssetPackageReader a(AssetManager assetManager, String str, String str2) throws IOException {
        return new AssetPackageReader(new b(assetManager, str), str2, false);
    }

    public static AssetPackageReader a(Context context, String str, String str2) throws IOException {
        AssetPackageReader assetPackageReader;
        AssetPackageReader assetPackageReader2;
        a.b();
        WeakReference<AssetPackageReader> weakReference = f19499a.get(str);
        if (weakReference != null && (assetPackageReader2 = weakReference.get()) != null) {
            return assetPackageReader2;
        }
        String substring = str.substring(str.indexOf(58) + 1);
        if (str.startsWith("assets:")) {
            assetPackageReader = new AssetPackageReader(new b(context.getApplicationContext().getAssets(), substring), str2, true);
        } else if (str.startsWith("file:")) {
            assetPackageReader = new AssetPackageReader(new e(new File(substring)), str2, true);
        } else if (str.startsWith("zipfile:")) {
            assetPackageReader = new AssetPackageReader(new g(new File(substring)), str2, true);
        } else {
            throw new PackageReaderException();
        }
        f19499a.put(str, new a(assetPackageReader));
        return assetPackageReader;
    }

    private com.nexstreaming.app.general.nexasset.assetpackage.a.a a(EncryptionInfoJSON encryptionInfoJSON) throws PackageReaderException {
        String str;
        if (encryptionInfoJSON == null || (str = encryptionInfoJSON.provider) == null || str.length() <= 0) {
            return null;
        }
        com.nexstreaming.app.general.nexasset.assetpackage.a.b bVar = f19500b.get(encryptionInfoJSON.provider);
        if (bVar != null) {
            return bVar.a(encryptionInfoJSON.psd);
        }
        throw new PackageReaderException(this, "invalid provider");
    }
}
