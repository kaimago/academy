package pointCaluate;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
     public void calculateDistance2SamePoints() {

        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);

        int i = point1.compareTo(point2);

        Assert.assertEquals(i, 0);

    }

    @Test
         public void calculateDistanceDifferentColumn() {

        Point point1 = new Point(3, 0);
        Point point2 = new Point(0, 0);

        int i = point1.compareTo(point2);

        Assert.assertEquals(i, 3);

        point1 = new Point(0, 0);
        point2 = new Point(3, 0);

        i = point1.compareTo(point2);
        Assert.assertEquals(i,  3);

    }

    @Test
    public void calculateDistanceDifferentRow() {

        Point point1 = new Point(0, 1);
        Point point2 = new Point(0, 0);

        int i = point1.compareTo(point2);

        Assert.assertEquals(i , 1);

        point1 = new Point(0, 0);
        point2 = new Point(1, 0);

        i = point1.compareTo(point2);
        Assert.assertEquals(i , 1);

    }

    @Test
    public void calculateDistanceDifferentColumnAndRow() {

        Point point1 = new Point(3, 4);
        Point point2 = new Point(4, 3);

        int i = point1.compareTo(point2);

        Assert.assertEquals(i , 2);

        point1 = new Point(0, 0);
        point2 = new Point(3, 1);

        i = point1.compareTo(point2);
        Assert.assertEquals(i , 4);
    }

}
