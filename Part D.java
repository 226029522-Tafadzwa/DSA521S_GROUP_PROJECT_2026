import java.util.Random;
 import java.util.Scanner;
public class CampusServiceCentre {
    static Scanner input = new Scanner(System.in);
    static StudentQueue waitingQueue = new StudentQueue(100);
    static StudentList serviceRecords = new StudentList();
    static int[] serviceTimes = new int[100];  
    static int serviceCount = 0;
public static void main(String[] args) {        
     int choice;
     do {             showMenu();            
      choice = readInt("Select option: ");
      switch (choice) {
        case 1:
      addToWaitingQueue(); 
      break;
    case 2:                    
     serveNextStudent();   
      break;             
          case 3:
      waitingQueue.display();        
        break;           
             case 4:      
    
addServiceRecord();
       break;                
        case 5:                    
            serviceRecords.display();                
              break;                 
              case 6:                    
            searchRecord();                     
               break;                
                case 7:                     
            deleteRecord();                    
                 break;                
                  case 8:                     
             showDailyStatistics();                     
                  break;                
                   case 9:                     
             sortServiceTimes();                    
                    break;                 
                    case 10:                    
            runSortingExperiment();                    
                      break;                 
                      case 11:                     
System.out.println("Program ended.");                   
                        break;                
                         default:                     
System.out.println("Invalid option.");                                                   
if (choice != 11) { 
   System.out.println();              
    System.out.println("Press Enter to continue...");   
    input.nextLine();                                
}
} while (choice != 11);
     input.close();
     }

        static void showMenu() {         System.out.println();
        System.out.println("==========================================");
        System.out.println("          CAMPUS SERVICE CENTRE");
        System.out.println("==========================================");
        System.out.println("1. Add student to waiting queue");
        System.out.println("2. Serve next student");
        System.out.println("3. Display waiting students");
        System.out.println("4. Add student service record");
        System.out.println("5. Display student service records");
        System.out.println("6. Search for student record");
        System.out.println("7. Remove student record");
        System.out.println("8. Display daily statistics");
        System.out.println("9. Sort service times");
        System.out.println("10. Run sorting experiment");
        System.out.println("11. Exit");
        System.out.println("==========================================");     }
     static void showMenu() {         System.out.println();
        System.out.println("==========================================");
        System.out.println("          CAMPUS SERVICE CENTRE");
        System.out.println("==========================================");
        System.out.println("1. Add student to waiting queue");
        System.out.println("2. Serve next student");
        System.out.println("3. Display waiting students");
        System.out.println("4. Add student service record");
        System.out.println("5. Display student service records");
        System.out.println("6. Search for student record");
        System.out.println("7. Remove student record");
        System.out.println("8. Display daily statistics");
        System.out.println("9. Sort service times");
        System.out.println("10. Run sorting experiment");
        System.out.println("11. Exit");
        System.out.println("==========================================");     }
    static Student readStudent() {
      int number = readInt("Student number: ");
             System.out.print("Student name: ");
        String name = input.nextLine();
        System.out.print("Service type: ");        
         String service = input.nextLine();
        int time = readInt("Estimated service time (minutes): ");
        return new Student(number, name, service, time);  
           }
               static int readInt(String message) {   
                      while (true) {            
                 System.out.print(message);          
                    String value = input.nextLine();
               try {  
              return Integer.parseInt(value);   }    
               catch (NumberFormatException e) {
               catch (NumberFormatException e);
               }
                      }
               }
               // ---------------- QUEUE ----------------
                   static void addToWaitingQueue() {    
                         Student student = readStudent();
                if (waitingQueue.enqueue(student)) {            
                     System.out.println("Student added to the waiting queue."); 
                } 
                   }
                      static void serveNextStudent() {   
                             Student student = waitingQueue.dequeue(); 
                                 if (student == null) {  
 System.out.println("There are no students waiting.");
     return;         }  
 System.out.println("Student being served:"); 
    System.out.println(student);
     if (serviceCount < serviceTimes.length) {
     serviceTimes[serviceCount] = student.serviceTime;
    serviceCount++;  
 } else {
    System.out.println("Daily service-time array is full.");
        }
      serviceRecords.insertAtEnd(student);
      System.out.println("Student removed from queue and service recorded.");
      } 
       }     // ------------- LINKED LIST -------------
        static void addServiceRecord() {     
        Student student = readStudent();
           serviceRecords.insertAtEnd(student);   
    System.out.println("Service record added."); 
        }
        static void searchRecord() {
         int number = readInt("Enter student number to search: ");  
          Student found = serviceRecords.search(number);
                  if (found == null) {  
     System.out.println("Student record not found.");  
                      } else { 
    System.out.println("Student record found:");
     System.out.println(found);
                      }
        }
        static void deleteRecord() {   
             int number = readInt("Enter student number to remove: ");
        if (serviceRecords.delete(number)) {         
        System.out.println("Student record removed.");
                        } else {
            System.out.println("Student record not found.");   
                        }
        }
      // ---------------- ARRAY ----------------
      static void showDailyStatistics() { 
         if (serviceCount == 0) {
        System.out.println("No students have been served yet.");      
               return;         }
          int total = 0;  
          int highest = serviceTimes[0]; 
          int lowest = serviceTimes[0];        
          int longerThanTen = 0;
     for (int i = 0; i < serviceCount; i++) {  
        total += serviceTimes[i];
        if (serviceTimes[i] > highest) { 
         highest = serviceTimes[i]; 
      if (serviceTimes[i] < lowest) {  
         lowest = serviceTimes[i];        
              }
         if (serviceTimes[i] > 10) { 
             longerThanTen++;
         }
        }  
        double average = (double) total / serviceCount; 
        System.out.println();
        System.out.println("========== DAILY STATISTICS ==========");
        System.out.println("Total students served: " + serviceCount);
        System.out.println("Total service time: " + total + " minutes");
        System.out.printf("Average service time: %.2f minutes%n", average);
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Services longer than 10 minutes: "
                        + longerThanTen);
     }
     // --------------- SORTING ---------------
     static void sortServiceTimes() {   
         if (serviceCount == 0) {
        System.out.println("No service times are available.");   
        return;
         }
         int[] values = copyServiceTimes(); 
        System.out.println();
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");     
        System.out.println("4. Quick Sort");
        int choice = readInt("Choose sorting algorithm: ");
        SortResult result;
        switch (choice) {    
                     case 1:     
              result = Sorts.selectionSort(values);  
                         break;         
                    case 2:           
             result = Sorts.insertionSort(values);   
                           break;          
                       case 3:           
             result = Sorts.mergeSort(values);    
                          break;         
                      case 4:       
                 result = Sorts.quickSort(values);   
                               break;         
                            default:           
              System.out.println("Invalid sorting option."); 
              return;
        }   
                System.out.println("Sorted service times:");  
                       printArray(values);    
                 System.out.println("Data comparisons: " + result.comparisons);   
                       }
                     static int[] copyServiceTimes() {        
                     int[] copy = new int[serviceCount]; 
                             for (int i = 0; i < serviceCount; i++) { 
                             copy[i] = serviceTimes[i];      
                                                   } 
                return copy;   
                  }      
                  // ------------ SORTING EXPERIMENT ------------
                  static void runSortingExperiment() {    
                    int[] sizes = {20, 50, 100, 500}; 
                     Random random = new Random();
                System.out.println();
        System.out.println("============== SORTING EXPERIMENT ==============");
        System.out.printf("%-16s %-8s %-15s %-18s%n",
                "Algorithm", "Size", "Comparisons", "Time (ns)");      
          System.out.println("--------------------------------------------------");
                for (int size : sizes) {   
                     int[] original = new int[size];  
                     for (int i = 0; i < size; i++) {  
                   original[i] = random.nextInt(1000); 
                     }
                }     
                 int[] a = copyArray(original); 
                long start = System.nanoTime();  
              SortResult r = Sorts.selectionSort(a); 
               long end = System.nanoTime();             
              printExperiment("Selection Sort", size, r, end - start);
                  a = copyArray(original);  
                  start = System.nanoTime(); 
              r = Sorts.insertionSort(a);      
                  end = System.nanoTime();        
                   printExperiment("Insertion Sort", size, r, end - start); 
                     a = copyArray(original);        
                     start = System.nanoTime();        
                     r = Sorts.mergeSort(a);      
                      end = System.nanoTime();     
                        printExperiment("Merge Sort", size, r, end - start); 
                                a = copyArray(original);      
                             start = System.nanoTime();   
                              r = Sorts.quickSort(a);   
                             end = System.nanoTime();           
                        printExperiment("Quick Sort", size, r, end - start);   
                  }
      }       
        static void printExperiment(String name, int size, SortResult result, long time) {
        System.out.printf("%-16s %-8d %-15d %-18d%n", name, size, result.comparisons, time);
        }
        static int[] copyArray(int[] source) {  
          int[] copy = new int[source.length]; 
                  for (int i = 0; i < source.length; i++) {      
                    copy[i] = source[i];     
                        }  
                        return copy;
        }
 static void printArray(int[] values) {      
       for (int i = 0; i < values.length; i++) {     
            System.out.print(values[i] + " ");
            if ((i + 1) % 15 == 0) { 
                System.out.println(); 
            }
       }
       System.out.println();
 }
 } // ---------------- STUDENT ----------------
 class Student {     
    int studentNumber;     
    String name;    
     String serviceType; 
    int serviceTime;
    Student(int studentNumber, String name, String serviceType, int serviceTime) {
      this.studentNumber = studentNumber; 
     this.studentNumber = studentNumber;
    this.serviceType = serviceType;  
     this.serviceTime = serviceTime;   
              }  
     public String toString() {                                 
      return studentNumber + " | " + name + " | "      + serviceType + " | " + serviceTime + " minutes";  
     }
 }                                                  
    // ---------------- QUEUE ----------------
     class StudentQueue {  
           private Student[] data;                                                           
           private int front;    
            private int rear;    
             private int size;   
             StudentQueue(int capacity) {      
                   data = new Student[capacity];    
                  front = 0;     
                      rear = -1;   
                     size = 0;  
                        }                                 
                    boolean enqueue(Student student) {
                     if (size == data.length) { 
                       System.out.println("Waiting queue is full.");
                       return false;
                     }   
                     rear = (rear + 1) % data.length;          
                     data[rear] = student; 
                     size++;
                     return true;      
                    } 
     }
      Student dequeue() { 
        if (isEmpty()) {      
         return null; 
        }
     Student student = data[front];  
     data[front] = null;
     front = (front + 1) % data.length;
         size--;
        return student;
      }
          Student peek() {  
             if (isEmpty()) {     
            return null;   
                     }  
                return data[front]; 
          }
              boolean isEmpty() {      
                 return size == 0;  
                      } 
                          void display() {      
                               if (isEmpty()) {    
                              System.out.println("No students are waiting.");   
                                    return;     
                                        } 
                             
        System.out.println(); 
                System.out.println("========== WAITING STUDENTS ==========");
        int index = front;
                for (int i = 0; i < size; i++) {      
                System.out.println((i + 1) + ". " + data[index]);  
                 index = (index + 1) % data.length;  
                        }
                          }
              } // ------------- SINGLY LINKED LIST -------------
             class StudentList {
    private class Node {         Student data;
        Node next;
        Node(Student data) {      
             this.data = data;    
             this.next = null;   
                        }   
                              }
             private Node head;
    void insertAtBeginning(Student student) {  
               Node newNode = new Node(student);  
                newNode.next = head;      
                    head = newNode; 
                             }
             void insertAtEnd(Student student) {     
                    Node newNode = new Node(student);
        if (head == null) {         
                head = newNode;     
                        return;  
                              }    
                Node current = head;
                while (current.next != null) {  
                current = current.next;   
                                 }
        current.next = newNode;  
          }
        Student search(int studentNumber) {  
                   Node current = head;
        while (current != null) {       
                  if (current.data.studentNumber == studentNumber) {   
                                  return current.data;       
                                        }
            current = current.next;   
                  }
        return null;
        }
           boolean delete(int studentNumber) {     
                if (head == null) {         
                        return false;      
                           }
        if (head.data.studentNumber == studentNumber) {      
                   head = head.next;         
                       return true;   
                             }       
                               Node current = head;
        while (current.next != null) {      
                   if (current.next.data.studentNumber == studentNumber) {  
                                   current.next = current.next.next;    
                                             return true;     
                                                     }
                                   current = current.next;   
        }
                return false;  
                   }     
              void display() {    
                     if (head == null) {     
                        System.out.println("No service records.");     
                                return;     
                                    } 
                 System.out.println();
                 System.out.println("======= STUDENT SERVICE RECORDS =======");
        Node current = head;      
           int position = 1;
        while (current != null) {   
                      System.out.println(position + ". " + current.data); 
                                  current = current.next;  
                                             position++;      
                                                }
    }
             }
     // ------------- SORTING SUPPORT -------------
    class SortResult {    
         long comparisons;
    SortResult(long comparisons) {  
               this.comparisons = comparisons; 
                   }
                    }
class Sorts {
    static SortResult selectionSort(int[] a) {    
             long comparisons = 0;
        for (int i = 0; i < a.length - 1; i++) {    
                     int min = i;
            for (int j = i + 1; j < a.length; j++) {       
                          comparisons++;
                if (a[j] < a[min]) {                     
min = j;           
      }
      
            if (min != i) {      
             int temp = a[i];         
                 a[i] = a[min];     
                    a[min] = temp;    
                          }        
                                 }
        return new SortResult(comparisons);   
        \  }
    static SortResult insertionSort(int[] a) {    
             long comparisons = 0;
        for (int i = 1; i < a.length; i++) {   
                      int key = a[i];
int j = i - 1;
            while (j >= 0) {       
             comparisons++;
                if (a[j] > key) {     
                 a[j + 1] = a[j]; 
                   j--;          
                          } else {   
                              break;    
                             }         
                                }
            a[j + 1] = key;    
                }
        return new SortResult(comparisons);   
          }
              static SortResult mergeSort(int[] a) {  
                       long[] counter = {0};      
                          mergeSort(a, 0, a.length - 1, counter);   
                                return new SortResult(counter[0]);  
                                   }
    private static void mergeSort(int[] a, int lef, int right, long[] counter) {     
                        if (left < right) {         
                    int middle = left + (right - left) / 2;
                    mergeSort(a, left, middle, counter);   
                              mergeSort(a, middle + 1, right, counter);            
                     merge(a, left, middle, right, counter); 
                             }   
                               }
private static void merge(int[] a, int left, int middle,  int right, long[] counter) {
    int leftSize = middle - left + 1;   
         int rightSize = right - middle;
        int[] L = new int[leftSize];    
        int[] R = new int[rightSize];
               for (int i = 0; i < leftSize; i++) {   
                    L[i] = a[left + i];   
                          }
        for (int j = 0; j < rightSize; j++) {     
             R[j] = a[middle + 1 + j]; 
                     }
        int i = 0;  
       int j = 0;  
       int k = left;
        while (i < leftSize && j < rightSize) {    
         counter[0]++;
             if (L[i] <= R[j]) {    
             a[k] = L[i];    
              i++;      
                } else {   
               a[k] = R[j];     
               j++;       
                     }
            k++;      
               }
        while (i < leftSize) {     
           a[k] = L[i];   
              i++;        
             k++;      
                }
        while (j < rightSize) {   
          a[k] = R[j];         
            j++;          
           k++;      
              }    
               }
    static SortResult quickSort(int[] a) {
                long[] counter = {0};  
                quickSort(a, 0, a.length - 1, counter);    
                     return new SortResult(counter[0]); 
                         }
 private static void quickSort(int[] a, int low, int high, long[] counter) {   
          if (low < high) {  
          int pivotIndex = partition(a, low, high, counter);
            quickSort(a, low, pivotIndex - 1, counter); 
            quickSort(a, pivotIndex + 1, high, counter);     
                }
    }

   private static int partition(int[] a, int low, int high, long[] counter) {
        int pivot = a[high];  
        int i = low - 1;
        for (int j = low; j < high; j++) {   
         counter[0]++;
            if (a[j] <= pivot) {  
               i++;
                int temp = a[i]; 
                a[i] = a[j];     
            a[j] = temp;        
                 }      
                    }
        int temp = a[i + 1];   
      a[i + 1] = a[high];      
         a[high] = temp;
        return i + 1;    
         }
}
}
 
       
 
 
   



                        
 
                
                     
             
   

                                                                                    
                                         











       









      




                                  



