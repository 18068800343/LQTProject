package com.ldxx.util;

import com.ldxx.bean.Point;

import java.util.ArrayList;
import java.util.List;

public class DistanceUtil {
    private final static double EARTH_RADIUS = 6378137.0;

    /**
     * 计算两点距离
     *
     * @param lat_a
     * @param lng_a
     * @param lat_b
     * @param lng_b
     * @return
     */
    public static double getDistance(double lng_a, double lat_a, double lng_b, double lat_b) {
        double radLat1 = (lat_a * Math.PI / 180.0);
        double radLat2 = (lat_b * Math.PI / 180.0);
        double a = radLat1 - radLat2;
        double b = (lng_a - lng_b) * Math.PI / 180.0;

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));

        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        return s;
    }


    /**
     * 经纬度点a 到 点b 点c的距离
     *
     * @param aLng
     * @param aLat
     * @param bLng
     * @param bLat
     * @param cLng
     * @param cLat
     * @return
     */
    public static double getMinDistance(double aLng, double aLat, double bLng, double bLat, double cLng, double cLat) {


        double c = getDistance(aLng, aLat, bLng, bLat);
        double b = getDistance(aLng, aLat, cLng, cLat);
        double a = getDistance(bLng, bLat, cLng, cLat);

        //求外接圆半周长p
        double p = (a + b + c) / 2;
        //根据海伦-秦九昭算法求面积S
        double S = Math.sqrt(Math.abs(p * (p - a) * (p - b) * (p - c)));
        double distance = S == 0 ? 0d : (2 * S / a);
        return distance;
    }

    /**
     * 经纬度点a 到 点b 点c的距离
     *
     * @param aLng
     * @param aLat
     * @return
     */
    public static double getMinDistanceByList(double aLng, double aLat, List<Point> points) {

        double min = 0;
        double flag = 0;
        for (int i = 0; i < points.size() - 1; i++) {

            Point b = points.get(i);
            Point c = points.get(i + 1);
            if (i == 0) {
                min = getMinDistance(aLng, aLat, b.getLng(), b.getLat(), c.getLng(), c.getLat());
            } else {
                flag = getMinDistance(aLng, aLat, b.getLng(), b.getLat(), c.getLng(), c.getLat());
                if (flag < min) {
                    min = flag;
                }
            }


        }
        return min;
    }


    public static void main(String[] args) {
        double aLng = 116.31618165334442;
        double aLat = 39.93895849340328;

        List<Point> points = new ArrayList<>();
        Point point1 = new Point(116.31718775551559, 39.74154503739745);
        Point point2 = new Point(117.31718775551559, 38.93154503739745);
        Point point3 = new Point(118.31718775551559, 38.93154503739745);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        double bLng = 116.31718775551559;
        double bLat = 39.74154503739745;

        double cLng = 117.31718775551559;
        double cLat = 38.93154503739745;

        System.out.println(getMinDistance(bLng, bLat, aLng, aLat, cLng, cLat));

        System.out.println(getDistance(aLng, aLat, bLng, bLat));

        System.out.println(getMinDistanceByList(aLng, aLat, points));
    }

}
