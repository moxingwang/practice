/*
package top.moxingwang.demo.password;

import sun.misc.CEFormatException;
import sun.misc.CEStreamExhausted;
import sun.misc.CharacterDecoder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;

*/
/**
 * Created by MoXingwang on 2017/8/26.
 *//*

public class BASE65Decoder extends CharacterDecoder implements Base65Interface {

    private static final byte[] pem_convert_array = new byte[256];
    byte[] decode_buffer = new byte[4];

    public BASE65Decoder() {
    }

    protected int bytesPerAtom() {
        return 4;
    }

    protected int bytesPerLine() {
        return 72;
    }

    protected void decodeAtom(PushbackInputStream var1, OutputStream var2, int var3) throws IOException {
        byte var5 = -1;
        byte var6 = -1;
        byte var7 = -1;
        byte var8 = -1;
        if (var3 < 2) {
            throw new CEFormatException("BASE64Decoder: Not enough bytes for an atom.");
        } else {
            int var4;
            do {
                var4 = var1.read();
                if (var4 == -1) {
                    throw new CEStreamExhausted();
                }
            } while(var4 == 10 || var4 == 13);

            this.decode_buffer[0] = (byte)var4;
            var4 = this.readFully(var1, this.decode_buffer, 1, var3 - 1);
            if (var4 == -1) {
                throw new CEStreamExhausted();
            } else {
                if (var3 > 3 && this.decode_buffer[3] == 61) {
                    var3 = 3;
                }

                if (var3 > 2 && this.decode_buffer[2] == 61) {
                    var3 = 2;
                }

                switch(var3) {
                    case 4:
                        var8 = pem_convert_array[this.decode_buffer[3] & 255];
                    case 3:
                        var7 = pem_convert_array[this.decode_buffer[2] & 255];
                    case 2:
                        var6 = pem_convert_array[this.decode_buffer[1] & 255];
                        var5 = pem_convert_array[this.decode_buffer[0] & 255];
                    default:
                        switch(var3) {
                            case 2:
                                var2.write((byte)(var5 << 2 & 252 | var6 >>> 4 & 3));
                                break;
                            case 3:
                                var2.write((byte)(var5 << 2 & 252 | var6 >>> 4 & 3));
                                var2.write((byte)(var6 << 4 & 240 | var7 >>> 2 & 15));
                                break;
                            case 4:
                                var2.write((byte)(var5 << 2 & 252 | var6 >>> 4 & 3));
                                var2.write((byte)(var6 << 4 & 240 | var7 >>> 2 & 15));
                                var2.write((byte)(var7 << 6 & 192 | var8 & 63));
                        }

                }
            }
        }
    }

    static {
        int var0;
        for(var0 = 0; var0 < 255; ++var0) {
            pem_convert_array[var0] = -1;
        }

        for(var0 = 0; var0 < pem_array.length; ++var0) {
            pem_convert_array[pem_array[var0]] = (byte)var0;
        }

    }
}
*/
