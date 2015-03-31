/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cg;

/**
 *
 * @author admin
 */
public class matrixmul {
    public static void main(String arg[]){
        int tx=50,ty=50;
        int x1=50,y1=50,x2=100,y2=100;
        int a[][]={{x1,y1,1},{x2,y2,1},{3,3,1}};
        int b[][]={{1,0,0},{0,1,0},{tx,ty,1}};
        int ans[][]=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    ans[i][j]+=a[i][k]*b[k][j];
                }
                
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(ans[i][j]);
                
            }
            
            
        }
    }
    
}
