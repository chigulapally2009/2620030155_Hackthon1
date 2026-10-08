import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }
    public boolean checkEligibility() {
        return marks >= 50;
    }


    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (marks >= 85) {
            return totalFee * 0.20; 
        } else if (marks >= 70 && marks <= 84) {
            return totalFee * 0.10; 
        } else {
            return 0.0; 
        }
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }
    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility  : Eligible");
        System.out.println("Total Fee    : Rs. " + calculateFee());
        System.out.println("Scholarship  : Rs. " + calculateScholarship());
        System.out.println("Final Fee    : Rs. " + calculateFinalFee());
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading student and course details
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        Student student = new Student(name, rollNo, marks, courseName, credits);


        processRegistration(student);

        scanner.close();
    }
    public static void processRegistration(Student student) {
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible (Marks must be 50 or above).");
        }
    }
}
