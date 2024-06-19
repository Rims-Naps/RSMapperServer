//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.apache.tools.bzip2;

final class CBZip2OutputStream$Data {
    final boolean[] inUse = new boolean[256];
    final byte[] unseqToSeq = new byte[256];
    final int[] mtfFreq = new int[258];
    final byte[] selector = new byte[18002];
    final byte[] selectorMtf = new byte[18002];
    final byte[] generateMTFValues_yy = new byte[256];
    final byte[][] sendMTFValues_len = new byte[6][258];
    final int[][] sendMTFValues_rfreq = new int[6][258];
    final int[] sendMTFValues_fave = new int[6];
    final short[] sendMTFValues_cost = new short[6];
    final int[][] sendMTFValues_code = new int[6][258];
    final byte[] sendMTFValues2_pos = new byte[6];
    final boolean[] sentMTFValues4_inUse16 = new boolean[16];
    final int[] stack_ll = new int[1000];
    final int[] stack_hh = new int[1000];
    final int[] stack_dd = new int[1000];
    final int[] mainSort_runningOrder = new int[256];
    final int[] mainSort_copy = new int[256];
    final boolean[] mainSort_bigDone = new boolean[256];
    final int[] heap = new int[260];
    final int[] weight = new int[516];
    final int[] parent = new int[516];
    final int[] ftab = new int[65537];
    final byte[] block;
    final int[] fmap;
    final char[] sfmap;
    final char[] quadrant;

    CBZip2OutputStream$Data(int blockSize100k) {
        int n = blockSize100k * 100000;
        this.block = new byte[n + 1 + 20];
        this.fmap = new int[n];
        this.sfmap = new char[2 * n];
        this.quadrant = this.sfmap;
    }
}
