class Student{
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNo, String name, int age, String grade){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList{
    Student head;
     public StudentList(){
         head = null;
     }

     //Add a student at the beginning
    public void addAtBeginning(int rollNo, String name, int age, String grade){
         Student newStudent = new Student(rollNo, name, age, grade);
         newStudent.next = head;
         head = newStudent;
    }

    //Add a student at the end
    public void addAtEnd(int rollNo, String name, int age, String grade){
         Student newStudent = new Student(rollNo, name, age, grade);
         if (head == null){
             head = newStudent;
             return;
         }
         Student lastStudent = head;
         while (lastStudent.next != null){
             lastStudent = lastStudent.next;
         }
         lastStudent.next = newStudent;
    }

    //Add Student at a specific position
    public void addAtPosition(int position, int rollNo, String name, int age, String grade){
         if (position == 0){
             addAtBeginning(rollNo, name, age, grade);
             return;
         }

         Student newStudent = new Student(rollNo, name, age, grade);
         Student current = head;
         int count = 0;
         while (current != null && count < position - 1){
             current = current.next;
             count++;
         }
         if (current != null && count < position){
             System.out.println("Position out of Bound");
               return;
         }
         newStudent.next = current.next;
         current.next = newStudent;
    }
    //Delete Student by roll Number
    public void deleteByRollNo(int rollNo){
         Student current = head;
         if (current != null && current.rollNo == rollNo){
             head = current.next;
             current = null;
             return;
         }
         Student prev = null;
         while (current != null && current.rollNo != rollNo){
             prev = current;
             current = current.next;
         }
         if (current == null){
             System.out.println("Student not Found");
             return;
         }
         prev.next = current.next;
         current = null;
    }

    //Search for a Student by rollNo
    public Student searchByRollNo(int rollNo){
         Student current = head;
         while (current != null){
             if (current.rollNo == rollNo){
                 return current;
             }
             current = current.next;
         }
         return null;
    }
    public void updateGrade(int rollNo, String newGrade){
         Student student = searchByRollNo(rollNo);
         if (student != null){
             student.grade = newGrade;
         }else {
             System.out.println("Student not found");
         }
    }
    //Display all Student records
    public void displayAll(){
         Student current = head;
         if (current == null){
             System.out.println("No records found");
             return;
         }
         while (current != null){
             System.out.println("Roll No : " + current.rollNo + " NAme: " + current.name + " Age: " + current.age + " Grade " + current.grade);
             current = current.next;
         }
    }
}
public class StudentRecordManagement{
    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        //Add Student records
        studentList.addAtEnd(1, "Gautam", 21, "B");
        studentList.addAtEnd(2, "Shriyansh", 21, "B");
        studentList.addAtEnd(3,"Nikhil", 21,"A");

        System.out.println("All Student Records");
        studentList.displayAll();

        //Add a student at the beginning
        studentList.addAtBeginning(0, "Gaut", 23, "A");
        System.out.println("\nAfter adding at the beginning:");
        studentList.displayAll();

        //Add a student at position 2
        studentList.addAtPosition(0,4,"Durgesh", 22, "A+");
        System.out.println("\nAfter adding at position 2:");
        studentList.displayAll();

        //Upadete a student's grade
        studentList.updateGrade(2, "B+");
        System.out.println("\nAfter upadation grade::");
        studentList.displayAll();

        //Search for a student by roll Number
        Student student = studentList.searchByRollNo(4);
        if (student != null){
            System.out.println("\nFound student : Roll No : " + student.rollNo + " Name: " + student.name + " Age: " + student.age + " Grade : " + student.grade);
        }else {
            System.out.println("student not found");
        }

        //Delete a student by rol number
        studentList.deleteByRollNo(2);
        System.out.println("\nAfter deleteion");
        studentList.displayAll();
    }
}