package fyj.algorithm.sparse;

public class SparseTest {

  public static void main(String[] args) {
    int [][]  arr2= new int[11][11];
    arr2[2][5]=1;
    arr2[3][6]=2;
    //原始数组
    printArr(arr2);

    //转稀疏数组
    int length = 0;
    for (int [] arr1:arr2){
      for (int i = 0;i<arr1.length;i++){
        if(arr1[i]!=0){
          length++;
        }
      }
    }

    int[][] sparse = new int[length + 1][3];
    sparse [0][0] = 11;
    sparse [0][1] = 11;
    sparse [0][2] = length;

    int sparseline=1;
    for (int i = 0;i<arr2.length;i++){
      for (int j = 0;j<arr2[i].length;j++){
        if(arr2[i][j]!=0){
          sparse[sparseline][0]= i;
          sparse[sparseline][1]= j;
          sparse[sparseline][2]= arr2[i][j];
          sparseline++;
        }
      }
    }

    printArr(sparse);

    //稀疏转二维 原始数组
    int [][]  arr2new= new int[sparse[0][0]][sparse[0][1]];
    for (int i = 1;i<sparse.length;i++) {
       arr2new[sparse[i][0]][sparse[i][1]]=sparse[i][2];
    }

    printArr(arr2new);


  }

  private static void printArr(int[][] arr2) {
    for (int [] arr1:arr2){
      for (int i = 0;i<arr1.length;i++){
        System.out.print(arr1[i]);
      }
      System.out.println();
    }
  }
}
