# JavaResort


Ứng Dụng Quản Lý Khu Nghỉ Dưỡng Furama

Mục đích
Học viên sử dụng những kiến thức java core và java advantage để viết một chương trình quản lý một khu nghỉ dưỡng cao câp tên Furama
Công nghệ phải dùng
Sau khi kết thúc khóa bài tập , học viên sẽ nắm được các kiến thức sau :

Java core

Variable là gì (day 1)
Các kiểu dữ liệu 8 kiểu (day 1)
Các kiểu toán tử (day 1)
Mệnh đề if else , swich case ()
Vòng lặp ( day 2)
Mãng (day 2)
OOP (Kế thừa , đóng gói, đa hình, trừa tượng)
Abstract Class (day 3)
Sử dụng ArrayList (day 4)
Interface (day 5)

Java Advantage
Generic (day 6)
Naming convention and package (day 7)
Access Modifiers (day 7)
Map , HashMap( Day 8)
Set, HashSet ( Day 9)
Queue (Date 10)
Stack (Date 11)
Sort Collection (Day 12) 
Exception (Day 13)
File
Thread
Practices

----------------------------------------------------------------------------------------------------------------------------

Day 1 

Để Furama vào hoạt động được thì mình phải xây dựng khu nghỉ dưỡng. Ban đầu mình xây dựng Furama có 5 cái Villa , 2 cái House và 1 hồ bơi. Một cái Villa thì có 1 cái giường . Nếu Khách có thuê cái Villa thì phải trả tiền 1 ngày là 10 USD. Một cái House thì có 4 cái giường. Nếu khách thuê 1 ngày thì trả 5 USD. Hồ bơi thì mở cửa lúc 10 sáng hằng ngày

Task 1	: Tạo cấu trúc dự án và tạo các class (dựa vào danh từ cho ra class) cần thiết 
Giả sử có 1 khách hàng tên Nguyễn Văn A , 20 tuổi thuê 1 cái Villa trong 4 ngày
Viết 1 method tính tiền cho khách hàng Nguyễn Văn A. In kết quả ra màn hình
Hiển thị tên , tuổi của KH ra màn hình

Task  2 : Tạo 1 class Swimming 
Viết 1 method hiển thị giờ mở cửa của Swimming pool là mấy giờ. In kết quả ra màn hình
Nếu khách hàng đến trước 8h thì thông báo Hồ bơi chưa mở cửa , bạn hãy chờ đến 9h (if/else)
Viết một hàm tính xem nếu khách hàng có 100 USD  thì in thông báo họ sẽ ở được mấy ngày trong villa , nếu có 50 USD thì ở được mấy ngày. Nếu 30 thì ở được mấy ngày (switch case)

Yêu cầu các kỷ thuật sau phải được áp dụng
Tạo được Class , Variable , Method
Sử dụng đúng kiểu dử liệu để lưu trữ
Sử dụng toán tử + , - ,*, / để tính tiền khách hàng
Sử dụng If else
Sử dụng swich case


----------------------------------------------------------------------------------------------------------------------------

Day 2 

Để tiện quản lý bao nhiêu Villa và house trong Furama thì cần một phương thức để lưu trử tổng số Villa và House trong resource 

Task 1 
Viết method hiển thị tất cả các villa trong khu nghỉ dưỡng. In kết quả ra màn hình 
Viết method hiển thị tất cả các beach house trong khu nghỉ dưỡng. In kết quả ra màn hình

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Array để lưu 5 cái villa và 2 beach hourse
Sử dụng vòng lặp để hiển thị danh sách các Villa và House

----------------------------------------------------------------------------------------------------------------------------

Day 3:

Hiện tại thì cái Furama vẫn chưa tối ưu lắm, khi muốn mở rộng thêm những tiện nghi khác ví dụ nhà hàng, massage hay những dịch vụ như tenis thì phải tạo thêm cách class mới , chưa thấy được khả năng kế thừa , đóng gói

Task 1
Tạo thêm 1 abstract class  hoặc 1 supper class tên Accomodation
Tạo thêm 1 loại nhà ở khách là Tent 
Xây dựng lại khu resort . Tent , Villa , House sẽ kế thừa từ cái Accomodation. Lúc đó name , size , price từ Accommodation sẽ được các lớp con kế thừa

Yêu cầu các kỷ thuật sau phải được áp dụng
Abstract Class
----------------------------------------------------------------------------------------------------------------------------

Day 4 : 

Giả sử có 10 khách hàng đặt phòng .Sử dụng ArrayList để lưu 10 KH
Task 1
Viết method hiển thị tất cả các Khách hàng có trong Resort

Yêu cầu các kỷ thuật sau phải được áp dụng
ArrayList


----------------------------------------------------------------------------------------------------------------------------

Day 5 : 
Thiết kế lại hệ thống . Yêu cầu sử dụng phương thức payment cho Khách hàng. KH có thể trả tính dụng bằng Visa hay Master Card

Task 1
Viêt thêm 1 interface payment và chấp nhận thanh toán với thẻ creadit card
Visa , Master Card  sẽ implement Interface Payment


Yêu cầu các kỷ thuật sau phải được áp dụng
Interface

----------------------------------------------------------------------------------------------------------------------------

Day 6 : 
Xây dựng một Library cho khu nghỉ dưỡng Furama cho khách hàng có thể đọc sách, nghe nhạc và xem phim. 
Task 1
Tạo 1 Generic Library <E> . E có thể là video , music và Book
Thêm một sách mới vào thư viện
Xoá một sách mới
Thêm một music vào thư viện
Xoá một music
Thêm một movie vào thư viện
Xoá 1 movie

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng generic

Tham Khảo
http://hocviencntt.org/2018/01/10/generics-la-gi

----------------------------------------------------------------------------------------------------------------------------

Day 7 : 
Tạm thời Furama đã ổn định, nhưng vật liệu xây dựng (package , biến, variable) vẫn chưa được tốt lắm cần phải đều chỉnh vật liệu sao cho người khác dể hiểu , dể maintain
Task 1
Thay lại package name cho đúng định dạng
Kiểm tra lại các class và method đã theo java convension chưa?
Access Modifilder đã dùng đúng chưa ? private, public , protected 
Nếu cái vật liệu nào cần share cho các lớp khác thì sử dụng static chưa
Những hằng số như giá tiền đã sử dụng final chưa

Yêu cầu các kỷ thuật sau phải được áp dụng
Java convention 
Access Modifier


----------------------------------------------------------------------------------------------------------------------------
Day 8 : 
Furama hiện tại đã có 10 nhân viên làm việc . Mỗi nhân viên đều có 1 mã số duy nhất ứng với tên của mình. Ví du Mã số 001 Tên Nhân Viên là Nguyễn Thị B. 

Task 1 
Tạo ra 10 nhân viên có tên tuổi địa chỉ
Add 10 nhân viên vào mỗi cái Map
Cái key sẽ là mã số nhân viên còn value sẽ là Object nhân viên
Viết 1 hàm in ra toàn bộ nhân viên có trong Furama. 

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Map

Tham Khảo
http://hocviencntt.org/2018/01/11/java-collections/
http://hocviencntt.org/2018/01/13/hashmap-trong-java-collection/

----------------------------------------------------------------------------------------------------------------------------
Day 9 :
Hằng ngày có rất nhiều chuyến xe ra vào Furama. Chúng ta cần một nơi để lưu trữ số lần có mỗi chiếc xe du lich vào Furama. Ví dụ có 1 chiếc xe vào thì mình lưu lại bản số xem và cuối ngày mình xem có bao nhiêu xe đi vào Furama

Task 1 
Tạo Set collection để lưu trữ
Khi có một xe vào thì add vào Set 
Viết 1 hàm để duyệt qua các biển số xe trong ngày

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng HashSet

Tham Khảo
http://hocviencntt.org/2018/01/11/hashset-trong-java-collection/

----------------------------------------------------------------------------------------------------------------------------

Day 10:
Furama có mở thêm rạp chiếu phim 4D cho khách hàng. Khi khách hàng mua vé trước thì được xếp vào hàng ghế đầu tiên, nếu khách hàng mua cuối cùng thì ngồi hàng ghế sau cùng.

Task 1
Tạo một Queuu tập hợp
Khi có 1 khách hàng vào đầu tiên , thì dùng Queue add vào hàng đợi
Sau khi bán hết vé xong thì in ra danh sách các khách hàng mua vé hôm đó theo thứ tự người mua trước sẽ được in trước
Viết method để in ra danh sách

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Queue

Tham Khảo
http://hocviencntt.org/2018/01/13/queue-trong-collection/
----------------------------------------------------------------------------------------------------------------------------
Day 11

Bộ phận nhân sự của Furama cần 1 cái tủ để đựng hồ sơ của nhân viên. Khi có nhân viên nào muốn tìm hồ sơ của mình thì bộ phận nhân sự sẽ lục trong tủ hồ sơ

Task 1
Tạo  một class là Tủ Hồ Sơ
Sau đó dùng Stack để lưu trử các hồ sơ
Viết một hàm tìm kiếm hồ sơ nhân viên
Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Stack

Tham Khao
http://hocviencntt.org/2018/01/15/stack-trong-java/

----------------------------------------------------------------------------------------------------------------------------
Day 12

Bộ phận nhân sự của Furama cần hiển thị danh sách nhân viên trong Furama theo thứ tự tăng dần dự theo tên. Nghĩa là Tên Nguyễn Văn A sẽ hiện trước Nguyễn Văn B
Task 1

Viết một hàm sắp xếp danh sách nhân viên theo thứ tự giảm dần. Tham số truyền vào là danh sách nhân viên . Có thể là ArrayList hoặc bất cứ collection nào


Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng SortCollection

Tham Khao
http://hocviencntt.org/2018/01/15/sort-collection-trong-java/

----------------------------------------------------------------------------------------------------------------------------
Day 13
Để tìm kiếm khách hàng có tên Nguyễn Văn A có đặt phòng trong khu nghỉ dưỡng hay không. Tiếp tân của khu nghỉ dưỡng sẽ tìm kiếm Nguyễn Văn A. Nếu Nguyễn Văn A không có trong danh sách thì ném ra ngoại lệ “Khách hàng không tìm thấy”

Task 1
Tao một cái ArrayList chứa danh sách các khách hàng đã đặt phòng
Viết một hàm tìm kiếm khách đặt phòng. Sau đó duyệt qua từng phần tử để kiểm tra KH có trong danh sách không
Nếu không có thì hiển thị lỗi, còn nếu có thì hiển thị ra thông tin khách hàng

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Exception

Tham Khao
http://hocviencntt.org/2018/01/13/exception-trong-java/

----------------------------------------------------------------------------------------------------------------------------

Day 14
Hiện nay công việc kinh doanh khá ổn nhưng kế toán cần phải có tài liệu để kiểm tra tháng này có bao nhiêu khách hàng đặt phòng trong khu nghỉ dưỡng. Do vậy mình phải lưu trữ thông tin của Khách hàng vào một file

Task 1
Tạo một method lưu tất cả các Khách hàng xuống 1 file

Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng File

Tham Khao
http://hocviencntt.org/2018/01/15/file-trong-java

----------------------------------------------------------------------------------------------------------------------------
Day 15
Hằng ngày vào lúc 19:00  bộ phận kế toán sẽ nhận được danh sách khách hàng vừa mới đăng ký trong hôm nay. Do vậy mình cần viết 1 Thread vào lúc 19h thì đọc thông tin trong file nơi lưu trữ KH và in ra 

Task 1
Tạo một Thread vào lúc 8h thì tự động vào đọc file và hiển thị kết quá


Yêu cầu các kỷ thuật sau phải được áp dụng
Sử dụng Thread

Tham Khảo
http://hocviencntt.org/2018/01/15/thread-trong-java
