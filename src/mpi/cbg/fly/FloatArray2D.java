package mpi.cbg.fly;

/**
 * <p>Title: PhaseCorrelation2D</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * <p>License: GPL
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License 2
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * @author Stephan Preibisch
 * @version 1.0
 */
public class FloatArray2D extends FloatArray
{
//    public float data[] = null;
    public int width = 0;
    public int height = 0;


    public FloatArray2D(int width, int height)
    {
        data = new float[width * height];
        this.width = width;
        this.height = height;
    }

    public FloatArray2D(float[] data, int width, int height)
    {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public FloatArray2D clone()
    {
        FloatArray2D clone = new FloatArray2D(width, height);
        System.arraycopy(this.data, 0, clone.data, 0, this.data.length);
        return clone;
    }

    public int getPos(int x, int y)
    {
        return x + width * y;
    }

    public float get(int x, int y)
    {
        return data[getPos(x,y)];
    }

    public float getMirror(int x, int y)
    {
        if (x >= width)
            x = width - (x - width + 2);

        if (y >= height)
            y = height - (y - height + 2);

        if (x < 0)
        {
            int tmp = 0;
            int dir = 1;

            while (x < 0)
            {
                tmp += dir;
                if (tmp == width - 1 || tmp == 0)
                    dir *= -1;
                x++;
            }
            x = tmp;
        }

        if (y < 0)
        {
            int tmp = 0;
            int dir = 1;

            while (y < 0)
            {
                tmp += dir;
                if (tmp == height - 1 || tmp == 0)
                    dir *= -1;
                y++;
            }
            y = tmp;
        }

       return data[getPos(x,y)];
    }

    public float getZero(int x, int y)
    {
        if (x >= width)
            return 0;

        if (y >= height)
            return 0;

        if (x < 0)
            return 0;

        if (y < 0)
            return 0;

        return data[getPos(x,y)];
    }

    public void set(float value, int x, int y)
    {
        data[getPos(x,y)] = value;
    }
}
