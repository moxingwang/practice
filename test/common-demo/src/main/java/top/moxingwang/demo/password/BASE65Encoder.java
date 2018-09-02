package top.moxingwang.demo.password;

import sun.misc.CharacterEncoder;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by MoXingwang on 2017/8/26.
 */
public class BASE65Encoder extends CharacterEncoder implements Base65Interface {

    public BASE65Encoder() {
    }

    protected int bytesPerAtom() {
        return 3;
    }

    protected int bytesPerLine() {
        return 57;
    }

    protected void encodeAtom(OutputStream var1, byte[] var2, int var3, int var4) throws IOException {
        byte var5;
        if (var4 == 1) {
            var5 = var2[var3];
            byte var6 = 0;
            boolean var7 = false;
            var1.write(pem_array[var5 >>> 2 & 63]);
            var1.write(pem_array[(var5 << 4 & 48) + (var6 >>> 4 & 15)]);
            var1.write(61);
            var1.write(61);
        } else {
            byte var8;
            if (var4 == 2) {
                var5 = var2[var3];
                var8 = var2[var3 + 1];
                byte var9 = 0;
                var1.write(pem_array[var5 >>> 2 & 63]);
                var1.write(pem_array[(var5 << 4 & 48) + (var8 >>> 4 & 15)]);
                var1.write(pem_array[(var8 << 2 & 60) + (var9 >>> 6 & 3)]);
                var1.write(61);
            } else {
                var5 = var2[var3];
                var8 = var2[var3 + 1];
                byte var10 = var2[var3 + 2];
                var1.write(pem_array[var5 >>> 2 & 63]);
                var1.write(pem_array[(var5 << 4 & 48) + (var8 >>> 4 & 15)]);
                var1.write(pem_array[(var8 << 2 & 60) + (var10 >>> 6 & 3)]);
                var1.write(pem_array[var10 & 63]);
            }
        }

    }

}
