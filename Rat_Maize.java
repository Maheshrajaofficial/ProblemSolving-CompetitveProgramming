import java.util.*;

public class Rat_Maize {
    public static void main(String[] args) {
      int n = 4;                                             //The length of the array
      int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}}; //Initialize the array for the maize here '1' describes the path & '0' describes the block
      Solution obj = new Solution();                         //The problem is approched in OOPS fashion so create a Solution class
      ArrayList < String > res = obj.findPath(a, n);         //Here use the "findPath" method in the Solution class and pass the maize array and the length "n"
      if (res.size() > 0) {                                  //The below code is used for printing the answer array........:)
        for (int i = 0; i < res.size(); i++)
          System.out.print("{"+res.get(i) + " "+"}");
        System.out.println("");
      } else {
        System.out.println(-1);
      }
  }
}
class Solution{
  static void solve(int i , int j , int arr[][] , int n , ArrayList<String> ans , String move , int vis[][]){ //Here the row  , column , the maize array , the length  
                                                                                                             //the answer array , the string , the visit array is passed  
    if(i == n-1 && j == n-1){                                    //If it is the last row and last col then the string is added to the string                                            
      ans.add(move);
      return;
    }
    //move to the Down side;
    if(i+1 < n && vis[i+1][j] == 0 && arr[i+1][j] == 1){          //3 conditions=> 1)is this the last row 2)is the arraycell is not visited 3)the maize array has path or block
      vis[i][j] = 1;
      solve(i+1 , j , arr, n, ans , move+"Down|" , vis);
      vis[i][j] = 0;
    }
    //Move to the Left side;
    if(j-1 > 0 && vis[i][j-1] == 0 && arr[i][j-1] == 1){          //3 conditions=> 1)is this the last col 2)is the arraycell is not visited 3)the maize array has path or block
      vis[i][j] = 1;
      solve(i , j-1 , arr, n ,ans, move+"Left|" , vis);
      vis[i][j] = 0;
    }
    //Move to the Right side;
    if(j+1 < n && vis[i][j+1] == 0 && arr[i][j+1] == 1){           //3 conditions=> 1)is this the last col 2)is the arraycell is not visited 3)the maize array has path or block
      vis[i][j] = 1;
      solve(i , j+1 , arr , n ,ans, move+"Right|" , vis);
      vis[i][j] = 0;
    }
    if(i-1 > 0 && vis[i-1][j] == 0 && arr[i-1][j] == 1){           ////3 conditions=> 1)is this the last row 2)is the arraycell is not visited 3)the maize array has path or block
      vis[i][j] = 1;
      solve(i-1 , j , arr, n , ans, move+"Up|" , vis);
      vis[i][j] = 0;
    }
  }
  static ArrayList<String> findPath(int arr[][] , int n){                  //The findPath method with maize array and length arguments
    int vis[][] = new int[n][n];                                           //create a an 2D array and name it as vis to regular check the array cell has been visited
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        vis[i][j] = 0;                                                     //fill the vis array as 0 for now if '0'-not visited & '1' -visited
      }
    }
    ArrayList<String> ans = new ArrayList<>();                             //Create a ans arraylist to return the answer array to the main
    if(arr[0][0] == 1)solve(0 , 0 , arr , n , ans , "" , vis);             //The program looping starts here the condition to be checked that the maize at the ist index 
    return ans;                                                            // which is 0th row 0th col is 1 if it is '1' the function starts or else there is no way the rat could find the path
  }
}
