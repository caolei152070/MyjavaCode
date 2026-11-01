package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

    public class ClosestPoint {
        static class Point{
            double x,y;
            Point(double x, double y){
                this.x = x;
                this.y = y;
            }
        }
        static class PairRes{
            Point p1,p2;
            double dist;
            PairRes(Point a, Point b, double d){
                p1 = a; p2 = b; dist = d;
            }
        }
        //两点距离
        static double dist(Point a, Point b){
            double dx = a.x - b.x;
            double dy = a.y - b.y;
            return Math.sqrt(dx*dx + dy*dy);
        }
        //暴力枚举，点数少的时候用
        static PairRes brute(Point[] points, int l, int r){
            double minD = Double.MAX_VALUE;
            Point p1=null,p2=null;
            for(int i=l;i<=r;i++){
                for(int j=i+1;j<=r;j++){
                    double d = dist(points[i], points[j]);
                    if(d < minD){
                        minD = d;
                        p1 = points[i];
                        p2 = points[j];
                    }
                }
            }
            return new PairRes(p1,p2,minD);
        }

        static PairRes divideClosest(Point[] points, int l, int r){
            if(r - l <=3){
                return brute(points,l,r);
            }
            int mid = (l + r)/2;
            Point midP = points[mid];
            PairRes left = divideClosest(points, l, mid);
            PairRes right = divideClosest(points, mid+1, r);
            PairRes minRes;
            if(left.dist < right.dist) minRes = left;
            else minRes = right;
            double d = minRes.dist;
            //收集中间带状区域的点
            List<Point> strip = new ArrayList<>();
            for(int i=l;i<=r;i++){
                if(Math.abs(points[i].x - midP.x) < d){
                    strip.add(points[i]);
                }
            }
            //按y排序
            strip.sort(Comparator.comparingDouble(p->p.y));
            //遍历带状
            for(int i=0;i<strip.size();i++){
                for(int j=i+1;j<strip.size() && strip.get(j).y - strip.get(i).y < d;j++){
                    double nd = dist(strip.get(i), strip.get(j));
                    if(nd < minRes.dist){
                        minRes = new PairRes(strip.get(i), strip.get(j), nd);
                    }
                }
            }
            return minRes;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("输入n(n≥100):");
            int n = sc.nextInt();
            Random rd = new Random();
            Point[] points = new Point[n];
            for(int i=0;i<n;i++){
                double x = rd.nextDouble() * 200;
                double y = rd.nextDouble() * 200;
                points[i] = new Point(x,y);
            }
            //按x升序排列
            Arrays.sort(points, Comparator.comparingDouble(p->p.x));
            PairRes ans = divideClosest(points,0,n-1);
            System.out.printf("最近两点：(%.2f,%.2f) 和 (%.2f,%.2f)\n",
                    ans.p1.x,ans.p1.y, ans.p2.x, ans.p2.y);
            System.out.printf("最小距离：%.4f", ans.dist);
            sc.close();
        }
    }

