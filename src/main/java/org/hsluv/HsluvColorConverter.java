package org.hsluv;

/**
 * README: https://github.com/hsluv/hsluv-java
 */
public class HsluvColorConverter {

    private static double refY = 1.0;

    private static double refU = 0.19783000664283;

    private static double refV = 0.46831999493879;

    private static double kappa = 903.2962962;

    private static double epsilon = 0.0088564516;

    private static double m_r0 = 3.240969941904521;

    private static double m_r1 = -1.537383177570093;

    private static double m_r2 = -0.498610760293;

    private static double m_g0 = -0.96924363628087;

    private static double m_g1 = 1.87596750150772;

    private static double m_g2 = 0.041555057407175;

    private static double m_b0 = 0.055630079696993;

    private static double m_b1 = -0.20397695888897;

    private static double m_b2 = 1.056971514242878;

    // RGB
    public String hex = "#000000";

    public double rgb_r = 0;

    public double rgb_g = 0;

    public double rgb_b = 0;

    // CIE XYZ
    public double xyz_x = 0;

    public double xyz_y = 0;

    public double xyz_z = 0;

    // CIE LUV
    public double luv_l = 0;

    public double luv_u = 0;

    public double luv_v = 0;

    // CIE LUV LCh
    public double lch_l = 0;

    public double lch_c = 0;

    public double lch_h = 0;

    // HSLuv
    public double hsluv_h = 0;

    public double hsluv_s = 0;

    public double hsluv_l = 0;

    // HPLuv
    public double hpluv_h = 0;

    public double hpluv_p = 0;

    public double hpluv_l = 0;

    // 6 lines in slope-intercept format: R < 0, R > 1, G < 0, G > 1, B < 0, B > 1
    public double r0s = 0;

    public double r0i = 0;

    public double r1s = 0;

    public double r1i = 0;

    public double g0s = 0;

    public double g0i = 0;

    public double g1s = 0;

    public double g1i = 0;

    public double b0s = 0;

    public double b0i = 0;

    public double b1s = 0;

    public double b1i = 0;

    private static double fromLinear(double c) {
        if (c <= 0.0031308) {
            return 12.92 * c;
        } else {
            return 1.055 * Math.pow(c, 1 / 2.4) - 0.055;
        }
    }

    private static double toLinear(double c) {
        if (c > 0.04045) {
            return Math.pow((c + 0.055) / 1.055, 2.4);
        } else {
            return c / 12.92;
        }
    }

    private static double yToL(double Y) {
        if (Y <= epsilon) {
            return Y / refY * kappa;
        } else {
            return 116 * Math.pow(Y / refY, 1.0 / 3) - 16;
        }
    }

    private static double lToY(double L) {
        if (L <= 8) {
            return refY * L / kappa;
        } else {
            return refY * Math.pow((L + 16) / 116, 3);
        }
    }

    private static double hexToRgbChannel(String hex, int offset) {
        return Integer.parseInt(hex.substring(offset, offset + 2), 16) / 255.0;
    }

    private static double distanceFromOriginAngle(double slope, double intercept, double angle) {
        double d = intercept / (Math.sin(angle) - slope * Math.cos(angle));
        if (d < 0) {
            return Double.POSITIVE_INFINITY;
        } else {
            return d;
        }
    }

    private static double distanceFromOrigin(double slope, double intercept) {
        return Math.abs(intercept) / Math.sqrt(Math.pow(slope, 2) + 1);
    }

    private static double min6(double f1, double f2, double f3, double f4, double f5, double f6) {
        return Math.min(f1, Math.min(f2, Math.min(f3, Math.min(f4, Math.min(f5, f6)))));
    }

    public void rgbToHex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hexToRgb() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void xyzToRgb() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void rgbToXyz() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void xyzToLuv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void luvToXyz() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void luvToLch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void lchToLuv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void calculateBoundingLines(double l) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double calcMaxChromaHpluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double calcMaxChromaHsluv(double h) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hsluvToLch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void lchToHsluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hpluvToLch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void lchToHpluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hsluvToRgb() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hpluvToRgb() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hsluvToHex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hpluvToHex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void rgbToHsluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void rgbToHpluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hexToHsluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void hexToHpluv() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
