package org.keyczar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.keyczar.enums.RsaPadding;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.UnsupportedTypeException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.KeyType;

/* loaded from: classes3.dex */
public enum DefaultKeyType implements KeyType {
    AES(Arrays.asList(128, 192, 256), 0),
    HMAC_SHA1(Arrays.asList(256), 20),
    DSA_PRIV(Arrays.asList(1024), 48),
    DSA_PUB(Arrays.asList(1024), 48),
    RSA_PRIV(Arrays.asList(4096, 2048, 1024), Arrays.asList(512, 256, 128)),
    RSA_PUB(Arrays.asList(4096, 2048, 1024), Arrays.asList(512, 256, 128)),
    EC_PRIV(Arrays.asList(256, 384, 521, 192), 70),
    EC_PUB(Arrays.asList(256, 384, 521, 192), 70),
    TEST(Arrays.asList(1), 0);

    private static Map<String, KeyType> typeMapping;
    private final List<Integer> acceptableSizes;
    private final Map<Integer, Integer> outputSizeMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.keyczar.DefaultKeyType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$keyczar$DefaultKeyType = new int[DefaultKeyType.values().length];

        static {
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.HMAC_SHA1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.DSA_PRIV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.DSA_PUB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.RSA_PRIV.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.RSA_PUB.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DefaultKeyBuilder implements KeyType.Builder {
        private final RsaPadding padding;

        /* synthetic */ DefaultKeyBuilder(DefaultKeyType defaultKeyType, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.keyczar.interfaces.KeyType.Builder
        public KeyczarKey generate(int i) throws KeyczarException {
            switch (AnonymousClass1.$SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.this.ordinal()]) {
                case 1:
                    return AesKey.generate(i);
                case 2:
                    return HmacKey.generate(i);
                case 3:
                    return DsaPrivateKey.generate(i);
                case 4:
                case 6:
                    throw new KeyczarException(Messages.getString("KeyczarKey.PublicKeyExport", DefaultKeyType.this));
                case 5:
                    return RsaPrivateKey.generate(i, this.padding);
                default:
                    throw new UnsupportedTypeException(DefaultKeyType.this);
            }
        }

        @Override // org.keyczar.interfaces.KeyType.Builder
        public KeyczarKey read(String str) throws KeyczarException {
            switch (AnonymousClass1.$SwitchMap$org$keyczar$DefaultKeyType[DefaultKeyType.this.ordinal()]) {
                case 1:
                    return AesKey.read(str);
                case 2:
                    return HmacKey.read(str);
                case 3:
                    return DsaPrivateKey.read(str);
                case 4:
                    return DsaPublicKey.read(str);
                case 5:
                    return RsaPrivateKey.read(str);
                case 6:
                    return RsaPublicKey.read(str);
                default:
                    throw new UnsupportedTypeException(DefaultKeyType.this);
            }
        }

        /* synthetic */ DefaultKeyBuilder(DefaultKeyType defaultKeyType, RsaPadding rsaPadding, AnonymousClass1 anonymousClass1) {
            this(rsaPadding);
        }

        private DefaultKeyBuilder(RsaPadding rsaPadding) {
            this.padding = rsaPadding;
        }

        private DefaultKeyBuilder() {
            this.padding = null;
        }
    }

    DefaultKeyType(List list, int i) {
        this.acceptableSizes = list;
        Iterator<Integer> it = this.acceptableSizes.iterator();
        while (it.hasNext()) {
            this.outputSizeMap.put(Integer.valueOf(it.next().intValue()), Integer.valueOf(i));
        }
        addToMapping(name(), this);
    }

    private static void addToMapping(String str, KeyType keyType) {
        if (typeMapping == null) {
            typeMapping = new HashMap();
        }
        typeMapping.put(str, keyType);
    }

    public static KeyType getTypeByName(String str) {
        return typeMapping.get(str);
    }

    @Override // org.keyczar.interfaces.KeyType
    public int defaultSize() {
        return this.acceptableSizes.get(0).intValue();
    }

    @Override // org.keyczar.interfaces.KeyType
    public List<Integer> getAcceptableSizes() {
        return Collections.unmodifiableList(this.acceptableSizes);
    }

    @Override // org.keyczar.interfaces.KeyType
    public KeyType.Builder getBuilder() {
        return new DefaultKeyBuilder(this, (AnonymousClass1) null);
    }

    @Override // org.keyczar.interfaces.KeyType
    public String getName() {
        return name();
    }

    @Override // org.keyczar.interfaces.KeyType
    public int getOutputSize(int i) {
        return this.outputSizeMap.get(Integer.valueOf(i)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyType.Builder getRsaBuilder(RsaPadding rsaPadding) throws KeyczarException {
        if (this == RSA_PRIV) {
            return new DefaultKeyBuilder(this, rsaPadding, null);
        }
        throw new KeyczarException(Messages.getString("InvalidKeyType", this));
    }

    @Override // org.keyczar.interfaces.KeyType
    public boolean isAcceptableSize(int i) {
        return this.acceptableSizes.contains(Integer.valueOf(i));
    }

    @Override // org.keyczar.interfaces.KeyType
    public int getOutputSize() {
        return getOutputSize(defaultSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    DefaultKeyType(List list, List list2) {
        this.acceptableSizes = list;
        for (int i = 0; i < list.size(); i++) {
            this.outputSizeMap.put(this.acceptableSizes.get(i), list2.get(i));
        }
        addToMapping(name(), this);
    }
}
