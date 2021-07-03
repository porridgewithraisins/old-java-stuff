package magicsquare;
import java.util.Scanner;
public class MagicSquare {

    void OddOrder(int[][]sq){
    int n = sq.length;
int i=0,j=(n-1)/2;
for(int num=1;num<=n*n;num++){
sq[i][j] = num;
if(num%n==0)++j;
else{++i;--j;}
if(j>=n)j=0; if(j<0)j=n-1;
if(i>=n)i=0;
}
    for(int k=0;k<n;k++){
        for(int l=0;l<n;l++){
        System.out.print(sq[k][l]);
        }
    System.out.println();
    }
    }
    void DoublyEven(int[][]sq){
        int n=sq.length;
int count[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            count[i][j]=n*i +j+1;
}
        for(int i=0;i<n/4;i++)
            for(int j=0;j<n/4;j++)
            sq[i][j] = n*n + 1 - count[i][j];
                for ( int i = 0; i < n/4; i++) 
            for ( int j = 3 * (n/4); j <n; j++) 
                sq[i][j] = (n*n + 1) - count[i][j]; 
         for ( int i = 3*n/4; i < sq.length; i++) 
            for ( int j =0; j < sq.length/4; j++) 
                sq[i][j] = (sq.length*sq.length + 1) - count[i][j];
         for ( int i = 3*sq.length/4; i < sq.length; i++) 
            for ( int j =3*sq.length/4; j < sq.length; j++) 
                sq[i][j] = (sq.length*sq.length + 1) - count[i][j];
            for ( int i = sq.length/4; i < 3*sq.length; i++) 
                for ( int j =sq.length/4; j < 3*sq.length/4; j++) 
                sq[i][j] = (sq.length*sq.length + 1) - count[i][j];
        for (int[] sq1 : sq) {
            for (int l = 0; l<sq.length; l++) {
                System.out.print(sq1[l]);
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
    Scanner s = new Scanner(System.in);
       int n = s.nextInt();
    int[][] matrix = new int[n][n];
            
        MagicSquare ms = new MagicSquare();
    if(n%2==1)ms.OddOrder(matrix);
    else if(n%4==0)ms.DoublyEven(matrix);
    
    }
    
    void SinglyEven(int[][]sq){
    
    
    
    }
}