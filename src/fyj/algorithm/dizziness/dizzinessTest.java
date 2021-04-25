package fyj.algorithm.dizziness;

public class dizzinessTest {


  public static void main(String[] args) {
    ArrayDizziness diz= new ArrayDizziness(10);
    diz.addDizziness(0);
    diz.addDizziness(1);
    diz.addDizziness(2);
    diz.addDizziness(3);
    diz.addDizziness(4);
    diz.addDizziness(5);
    diz.addDizziness(6);
    diz.addDizziness(7);
    diz.addDizziness(8);
    diz.addDizziness(9);
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.introductionDizziness();
    diz.addDizziness(10);
    diz.addDizziness(11);
    diz.addDizziness(12);
    diz.addDizziness(13);
    diz.addDizziness(14);
    diz.addDizziness(15);
    diz.addDizziness(16);
    diz.addDizziness(17);
    diz.addDizziness(18);
    diz.addDizziness(19);
    diz.introductionDizziness();

    diz.query();


  }
  //0000000099999999



}

class ArrayDizziness{

  private int maxSize;

  private int first;

  private int end;

  private int [] dizziness = null;

  ArrayDizziness(int maxSize){
    this.first = 0;
    this.end = 0;
    this.maxSize = maxSize+1;
    this.dizziness = new int[this.maxSize];
  }


  String  addDizziness(int num ){
    if(this.isFull()){
      throw  new RuntimeException("队列已经满了");
    }
    dizziness[end] = num;
    end = (end+1)%maxSize;
    return "添加成功！";
  }

  String introductionDizziness(){
    if(this.isEmpty()){
      throw  new RuntimeException("队列是空的");
    }
    int dizziness = this.dizziness[first];
    this.dizziness[first]=0;
    first = (first+1)%maxSize;

    return ""+ dizziness;
  }

  String query(){
    System.out.print("队列中还有：{");
    String xx= "";
    for (int i=0;i<dizziness.length;i++){
      if(dizziness[i]!=0){
        xx+="-"+dizziness[i];
        System.out.print("-"+dizziness[i]);
        System.out.print("-");
      }

    }
    System.out.print("}");
    return "队列推出成功！";
  }




  Boolean  isEmpty(){
    return end==first;

  }

  Boolean isFull(){
    return (end+1)%maxSize==first;

  }





}
