import java.util.Scanner;

class Main {

    class Student{
        String Name; 
        String StudentNo;
        String ServiceType;
        int Estimated_Serv_Time;

        public Student(String Name, String StudentNo,String ServiceType, int Estimated_Serv_Time){
            this.Name= Name; 
            this.StudentNo=StudentNo;
            this.ServiceType=ServiceType;
            this.Estimated_Serv_Time=Estimated_Serv_Time;}   
    }
    Student Student1= new Student("Maria","221045678","Registration",12);
    Student Student2= new Student("Tomas","222034512","Student Card",5);
    Student Student3= new Student("Ndapewa","223041876","Fees",8);
    Student Student4= new Student("Simon","221067341","Documents",4);
    
    static int front  = -1;
    static int rear   = -1;
    static int size = 4;
    static Student [] queue  = new Student[size];
   

     public static void enqueue (Student Student) {

    
        if (rear  == size - 1) {
            System.out.println(" Queue is full");
        }
        else if (front == -1 && rear== -1 ){
            front= 0;
            rear= 0; 
            queue[rear] = Student;
    
        }
        else{
            rear++;
            queue[rear] = Student;
        }
        
    
    }

    public static void main(String[] args) {
    

        
        System.out.println("-----------------------------------------------------------");
        System.out.println("****************CAMPUS SERVICE CENTER**********************");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1. Add student to waiting queue");
        System.out.println("2. Serve next student ");
        System.out.println("3. Display waiting student");
        System.out.println("4. Add student service record ");
        System.out.println("6. Dispaly student service records");
        System.out.println("7. Remove student record");
        System.out.println("8. Display daily statistic");
        System.out.println("9. Sort service time ");
        System.out.println("10. Run sorting times ");
        System.out.println("11. Exit ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice= input.nextInt();
        switch(choice) {
            case 1:
                
                enqueue(Student1);
                enqueue(Student2);
                enqueue(Student3);
                enqueue(Student4);
                break;
            
            default:
                System.out.println("Opção inválida");
        }

        input.close();
        




    }
}




 
