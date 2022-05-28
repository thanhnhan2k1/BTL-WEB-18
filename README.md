# BTL-WEB-18
1. Mô tả hệ thống
 # Các chức năng đối với khách hàng
  - Khách hàng có thể đăng kí, đăng nhập với tài khoản đã đăng kí, đăng xuất tài khoản
  - Khách hàng có thể nhắn tin trực tiếp với khách sạn
  - Khách hàng có thể tìm kiếm phòng trống theo ngày check in, ngày check out
  - Xem thông tin của từng phòng
  - Đặt phòng
  - Xem giỏ hàng các phòng khách hàng muốn đặt
  -  Xác nhận thanh toán phòng
# Các chức năng với người quản lí
 - Đăng nhập với tư cách admin, đăng xuất tài khoản
 - Quản lí phòng: xem, thêm, sửa , xóa các phòng
 - Xem thông tin, thông tin chi tiết khách hàng đã đăng kí trong hệ thống, tìm kiếm khách theo tên hoặc là số điện thoại
 - Thống kê: thống kê doanh thu theo phòng, thống kê hóa đơn đặt phòng của khách hàng, tìm kiếm theo mã phòng, ngày check in, ngày check out để xem hóa đặt phòng của phòng đã chọn
 2. Phân chia công việc
  - Nguyễn Thị Thanh Nhàn: đăng kí, đăng nhập với tài khoản đã đăng kí, đăng xuất tài khoản với khách hàng, đăng nhập với tư cách admin, Khách hàng có thể tìm kiếm phòng trống theo ngày check in, ngày check out,  Đặt phòng, Xem giỏ hàng các phòng khách hàng muốn đặt, frontend: admin, khách hàng, database:bảng user, room, cart, order_details, Nhúng messenger vào website , xác minh người dùng khi truy cập vào các trang.
  - Trần Thị Ngọc Nhung: thanh toán phòng, xem thông tin chi tiết từng khách hàng, frontend: khách hàng, database:bảng service
  - Bùi Tố Trinh: Admin: Xem thông tin, thông tin chi tiết khách hàng đã đăng kí trong hệ thống, tìm kiếm khách theo tên hoặc là số điện thoại, thống kê doanh thu theo phòng, Quản lí phòng: xem, thêm, sửa , xóa các phòng, frontend: admin, database: bảng stats + trigger revenue_update, room_update
    
