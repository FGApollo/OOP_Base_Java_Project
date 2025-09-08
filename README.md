# OOP Base Java Project - Student Registration for Mountain Climbing

##  About
Đây là một ứng dụng **Java Console** mô phỏng hệ thống quản lý đăng ký tham gia leo núi của sinh viên.  
Project được xây dựng theo mô hình hướng đối tượng (OOP), có đầy đủ CRUD, tìm kiếm, thống kê, và thao tác với file CSV.

---

## Features



### Mountain Management
- Đọc dữ liệu từ file `MountainList.csv`.
- Kiểm tra mã núi khi đăng ký.
- Quản lý thông tin: mã núi, tên, tỉnh, mô tả.

### Phone Fee Discount
- Sinh viên sử dụng số điện thoại Viettel hoặc VNPT sẽ được **giảm 35% học phí**.

---

## Tech Stack
- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?logo=openjdk&logoColor=white)
- File I/O (CSV)
- OOP Design (Encapsulation, Inheritance, Polymorphism)

---

## Example Output

```text
===== Student Registration for Mountain Climbing =====
1. Register new student
2. Update registration information
3. Delete registration
4. Display registered students
5. Search by student name
6. Filter by campus
7. Statistics & Revenue
8. Save data to file
9. Exit
-------------------------------------------------------
Choose [1-9]: 1

>> Enter student ID: S001
>> Enter name: Nguyen Van A
>> Enter phone: 0987654321
>> Enter campus [HN/HCM/DN/CT/QN]: HN
>> Enter mountain ID: M002

✅ Successfully registered! (Discount applied: Viettel - 35%)

-------------------------------------------------------
Choose [1-9]: 4

Registered Students:
ID     Name             Phone       Campus   Mountain   Fee
S001   Nguyen Van A     0987654321  HN       M002       650000
S002   Tran Thi B       0912345678  HCM      M001       1000000
-------------------------------------------------------
Total Students: 2
