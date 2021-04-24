package fyj.algorithm.dizziness;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建一个环形队列
        CircleArray queue = new CircleArray(4); //其队列的有效数据最大是3
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        //输出一个菜单
        boolean loop = true;
        while (loop){
            System.out.println();
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看数据头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println("取出的数据："+result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.println("队列头的数据是:"+result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}


class CircleArray{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头,初始值0  指向队列的第一个元素
    private int rear;//队列尾，初始值0  指向最后一个元素的后一个位置
    private int[] arr;//该数组用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        //初始化数组
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断是否满
     */
    public boolean isFull(){
        return (rear + 1)% maxSize == front;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public  void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }
        arr[rear] = n ;
        //将rear后移，这里必须考虑取模
        System.out.println(rear);
        rear = (rear + 1)% maxSize;
        System.out.println(rear);
    }

    /**
     * 获取队列的数据，出队列
     */
    public int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空，不能取数据");
        }
        //front指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移 考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        System.out.println(front);
        front = (front+1)%maxSize;
        System.out.println(front);
        return value;
    }

    /**
     * 显示队列数据
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空");
            return;
        }
        //从front开始遍历
        for(int i = front ;i<front+getSize();i++){
            System.out.println(arr[i%maxSize]);
        }
    }

    /**
     * 当前队列有效数据的个数
     */
    public int getSize(){
        return (rear + maxSize - front)% maxSize;
    }

    /**
     * 显示队列的头数据  注意不是取数据
     */
    public int headQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
}
