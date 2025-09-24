package BaiTap;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentService { 
    ArrayList<Student> menu;
    public StudentService() {
        menu = new ArrayList<>();
    }
    public void Menu(Scanner sc) {
        int choice;
        do {
        System.out.println("===== Quản lý sinh viên =====");
        System.out.println("1.Thêm sinh viên");
        System.out.println("2.Xóa sinh viên bằng id");
        System.out.println("3.Tìm sinh viên bằng id");
        System.out.println("4.Hiển thị tất cả sinh viên");
         System.out.println("Vui lòng chọn chức năng (1-5): ");
        System.out.println("5.Exit");
        choice = sc.nextInt();
        sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    Student student = new Student();
                    student.inputStudent(sc);
                    menu.add(student);
                    System.out.println("Đã thêm sinh viên thành công");
                    break;
                case 2:
                    System.out.print("Nhâp id của sinh viên bạn muốn xóa:" );
                    String deleteId = sc.nextLine();
                    Boolean found = false;
                    for (Student s : menu) {
                        if (s.getStudentId().equals(deleteId)) {
                            menu.remove(s);
                            System.out.println("Đã xóa sinh viên thành công.");
                            found = true;
                            break;
                        }
                        if(!found) {
                            System.out.println("Không tìm thấy sinh viên với id đã cho.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập id sinh viên bạn muốn tìm: ");
                    String findId = sc.nextLine();
                    for (Student s : menu) {
                        if (s.getStudentId().equals(findId)) {
                            System.out.println("Sinh viên tìm thấy: " + s);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Tất cả sinh viên:");
                    for (Student s : menu) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.println("Kết thúc...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

        }while(choice !=5);
                
    }

}
