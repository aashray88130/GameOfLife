package conwaygame;
/*
 * Weighted Quick Union
 */
public class WeightedQuickUnionUF {

    private int[][] parent, size;
    private int rows;
    private int cols;
    // Each parent[i][j] will contain i*numOfColumns + j
    // Going from i,j to this value is common, so convert and invert do this
    
    public WeightedQuickUnionUF ( int r, int c ){
        rows = r;
        cols = c;
        parent = new int[rows][cols];
        size = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parent[i][j] = convert(i, j);
                size[i][j] = 1;
            }
        }
    }
    
    public int find ( int i, int j ) {
        int[] dims = new int[]{i, j};
        int curParent = parent[i][j];
        while ( convert ( dims[0], dims[1] ) != curParent ) {
            dims = invert(curParent);
            curParent = parent[dims[0]][dims[1]];
        }
        return curParent;
    }

    public void union ( int r1, int c1, int r2, int c2 ) {
        
        int root1 = find(r1, c1);
        int root2 = find(r2, c2);
        
        if(root1 == root2) return;

        // root2 is supposed to be the root of the larger tree
        // If root1 is the root of the larger tree, swap them
        if ( size ( root1 )  >= size ( root2 ) ) {
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        // root2 is the root of the larget tree
        int[] invRoot1 = invert ( root1 );
        int[] invRoot2 = invert ( root2 );
        parent[invRoot1[0]][invRoot1[1]] = root2;
        size[invRoot2[0]][invRoot2[1]]  += size ( root1 );
    }

    private int convert ( int a, int b ) {
        return a * cols + b;
    }

    private int[] invert ( int val ) {
        return new int[]{(val - val % cols) / cols, val % cols};
    }

    private int size ( int val ) {
        int[] result = invert( val );
        return size[result[0]][result[1]];
    }
}