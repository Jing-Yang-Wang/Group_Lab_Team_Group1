import java.util.ArrayList;
import java.util.Scanner;

/**
 * 简化的查看学生功能演示
 * 基于现有代码结构实现
 */
public class TestViewStudent {
    
    // 简化的学生类
    static class SimpleStudent {
        private String universityID;
        private String name;
        private String email;
        private String academicStatus;
        
        public SimpleStudent(String universityID, String name, String email, String academicStatus) {
            this.universityID = universityID;
            this.name = name;
            this.email = email;
            this.academicStatus = academicStatus;
        }
        
        // Getters and Setters
        public String getUniversityID() { return universityID; }
        public void setUniversityID(String universityID) { this.universityID = universityID; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String getAcademicStatus() { return academicStatus; }
        public void setAcademicStatus(String academicStatus) { this.academicStatus = academicStatus; }
        
        @Override
        public String toString() {
            return String.format("ID: %s, Name: %s, Email: %s, Status: %s", 
                               universityID, name, email, academicStatus);
        }
    }
    
    // 简化的学生目录类
    static class SimpleStudentDirectory {
        private ArrayList<SimpleStudent> students;
        
        public SimpleStudentDirectory() {
            students = new ArrayList<>();
            // 添加一些示例学生
            students.add(new SimpleStudent("S001", "张三", "zhangsan@university.edu", "Active"));
            students.add(new SimpleStudent("S002", "李四", "lisi@university.edu", "Active"));
            students.add(new SimpleStudent("S003", "王五", "wangwu@university.edu", "Graduated"));
            students.add(new SimpleStudent("S004", "赵六", "zhaoliu@university.edu", "On Leave"));
        }
        
        public ArrayList<SimpleStudent> getAllStudents() {
            return students;
        }
        
        public SimpleStudent findStudent(String id) {
            for (SimpleStudent student : students) {
                if (student.getUniversityID().equals(id)) {
                    return student;
                }
            }
            return null;
        }
        
        public void updateStudent(SimpleStudent student) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getUniversityID().equals(student.getUniversityID())) {
                    students.set(i, student);
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleStudentDirectory directory = new SimpleStudentDirectory();
        
        System.out.println("=== 学生管理系统 - 查看学生功能 ===");
        
        while (true) {
            System.out.println("\n请选择操作:");
            System.out.println("1. 查看所有学生");
            System.out.println("2. 根据ID查看学生");
            System.out.println("3. 更新学生信息");
            System.out.println("4. 退出");
            System.out.print("请输入选择 (1-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
            
            switch (choice) {
                case 1:
                    viewAllStudents(directory);
                    break;
                case 2:
                    viewStudentById(directory, scanner);
                    break;
                case 3:
                    updateStudent(directory, scanner);
                    break;
                case 4:
                    System.out.println("谢谢使用！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private static void viewAllStudents(SimpleStudentDirectory directory) {
        System.out.println("\n=== 所有学生列表 ===");
        ArrayList<SimpleStudent> students = directory.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("没有找到学生记录。");
        } else {
            System.out.printf("%-10s %-15s %-25s %-15s%n", "ID", "姓名", "邮箱", "学术状态");
            System.out.println("------------------------------------------------------------");
            for (SimpleStudent student : students) {
                System.out.printf("%-10s %-15s %-25s %-15s%n", 
                    student.getUniversityID(), 
                    student.getName(), 
                    student.getEmail(), 
                    student.getAcademicStatus());
            }
        }
    }
    
    private static void viewStudentById(SimpleStudentDirectory directory, Scanner scanner) {
        System.out.print("请输入学生ID: ");
        String id = scanner.nextLine();
        
        SimpleStudent student = directory.findStudent(id);
        if (student != null) {
            System.out.println("\n=== 学生详细信息 ===");
            System.out.println("学号: " + student.getUniversityID());
            System.out.println("姓名: " + student.getName());
            System.out.println("邮箱: " + student.getEmail());
            System.out.println("学术状态: " + student.getAcademicStatus());
        } else {
            System.out.println("未找到ID为 " + id + " 的学生！");
        }
    }
    
    private static void updateStudent(SimpleStudentDirectory directory, Scanner scanner) {
        System.out.print("请输入要更新的学生ID: ");
        String id = scanner.nextLine();
        
        SimpleStudent student = directory.findStudent(id);
        if (student != null) {
            System.out.println("\n当前学生信息:");
            System.out.println(student);
            
            System.out.print("请输入新姓名 (直接回车保持原值): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                student.setName(newName);
            }
            
            System.out.print("请输入新邮箱 (直接回车保持原值): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                student.setEmail(newEmail);
            }
            
            System.out.print("请输入新学术状态 (Active/On Leave/Graduated/Probation, 直接回车保持原值): ");
            String newStatus = scanner.nextLine();
            if (!newStatus.isEmpty()) {
                student.setAcademicStatus(newStatus);
            }
            
            directory.updateStudent(student);
            System.out.println("学生信息更新成功！");
            System.out.println("更新后的信息: " + student);
        } else {
            System.out.println("未找到ID为 " + id + " 的学生！");
        }
    }
}

