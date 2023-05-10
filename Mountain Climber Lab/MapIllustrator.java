import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapIllustrator
{
    /** the 2D griday containing the elevations */
    private int[][] grid;

    /** constructor, parses input from the file into grid */
    public MapIllustrator(String fileName)
    {
        try
        {
            File mapFile = new File(fileName);
            Scanner fileReader = new Scanner(mapFile);
            
            grid = new int[fileReader.nextInt()][fileReader.nextInt()];
            
            for(int row = 0; row < grid.length; row++)
            {
                for(int col = 0; col < grid[0].length; col++)
                {
                    grid[row][col] = fileReader.nextInt();
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
        }
    }

    /** @return the min value in the entire grid */
    public int findMin()
    {
        int min = grid[0][0];
        
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                min = Math.min(min, grid[row][col]);
            }
        }
        
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax()
    {
        int max = 0;
        
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                max = Math.max(max, grid[row][col]);
            }
        }
        
        return max;
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g)
    {
        double scale = (double)255/(this.findMax() - this.findMin());
        int max = this.findMax();
        
        
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                double color = 255 - scale * (max - grid[row][col]);
                
                //int casting was setting color to zero so this was just an easy quick fix
                g.setColor(new Color((int)color, (int)color, (int)color));
                g.fillRect(col, row, 1, 1);
            }
        }
        
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawPath(Graphics g, int row)
    {
        int bestR = 0, bestC = 0;
        int totalElevationChange = 0;
        
        int r = row;
        for(int c = 0; c < grid[0].length-1; c++)
        {
            //        | r-1,c+1  
            //    r,c | r,c+1
            //        | r+1,c+1
            
            
            if(c != grid[0].length || c != 0)
            {
                if(r == 0)
                {
                    if(Math.abs(grid[r][c] - grid[r][c+1]) <= Math.abs(grid[r][c] - grid[r+1][c+1]))
                    {
                        bestR = r;
                        bestC = c+1;
                    }
                    else
                    {
                        bestR = r+1;
                        bestC = c+1;
                    }
                    totalElevationChange += Math.abs(grid[r][c] - grid[bestR][bestC]);
                    r = bestR;
                }
                else if(r == grid.length -1)
                {
                    if(Math.abs(grid[r][c] - grid[r][c+1]) <= Math.abs(grid[r][c] - grid[r-1][c+1]))
                    {
                        bestR = r-1;
                        bestC = c+1;
                    }
                    else
                    {
                        bestR = r;
                        bestC = c+1;
                    }
                    totalElevationChange += Math.abs(grid[r][c] - grid[bestR][bestC]);
                    r = bestR;
                }
                else
                {   
                    if(Math.abs(grid[r][c] - grid[r-1][c+1]) <= Math.abs(grid[r][c] - grid[r+1][c+1]))
                    {
                        bestR = r-1;
                        bestC = c+1;
                    }
                    else
                    {
                        bestR = r+1;
                        bestC = c+1;
                    }
            
                    if(Math.abs(grid[r][c] - grid[r][c+1]) <= Math.abs(grid[r][c] - grid[bestR][bestC]))
                    {
                        bestR = r;
                        bestC = c+1;
                    }
                    totalElevationChange += Math.abs(grid[r][c] - grid[bestR][bestC]);
                    r = bestR;
                }
                g.fillRect(c, r, 1, 1);
            }
        }
        return totalElevationChange;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int getIndexOfLowestPath(Graphics g)
    {
        int[] allPathElevationChanges = new int[grid.length];
        
        for(int path = 0; path < grid.length; path++)
        {
            allPathElevationChanges[path] = drawPath(g,path);
        }
        
        int bestPathRow = 0;
        for(int path = 0; path < allPathElevationChanges.length; path++)
        {
            if(allPathElevationChanges[path] < allPathElevationChanges[bestPathRow])
            {
                bestPathRow = path;
            }
        }
        
        return bestPathRow;
    }

    /** return the number of rows in grid */
    public int getRows()
    {
        return grid.length;
    }

    /** return the number of columns in grid (assumed rectangular) */
    public int getCols()
    {
        return grid[0].length;
    }
}


