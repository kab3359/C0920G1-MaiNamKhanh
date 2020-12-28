use btvn;


-- Viết câu lệnh UPDATE để cập nhật Price với điều kiện: Các mặt hàng có Price <= 1000 thì tăng thêm 10
SET SQL_SAFE_UPDATES = 0;
UPDATE btvn.products
SET price = (price + 10)
WHERE price <= 1000;

SELECT * FROM btvn.products;

-- Viết câu lệnh UPDATE để cập nhật DISCOUNT với điều kiện: Các mặt hàng có Discount <= 10 thì tăng thêm 5
UPDATE products
SET discount = (discount + 5)
WHERE discount <= 10;

-- Viết câu lệnh XOÁ tất cả các mặt hàng có Stock là 0
SET foreign_key_checks = 0; 
DELETE FROM products
WHERE stock = 0;
SET foreign_key_checks = 1;

-- Hiển thị tất cả các mặt hàng có giảm giá <= 10
SELECT * FROM products WHERE discount <= 10;

-- Hiển thị tất cả các mặt hàng có tồn kho <= 5 
select * FROM products WHERE stock <= 5;

-- Hiển thị tất cả các mặt hàng có Giá bán sau khi đã giảm giá <= 1000
SELECT *, (price * (1 - discount/100)) as price_after_discount FROM products 
HAVING price_after_discount <= 1000;

-- Hiển thị tất cả các khách hàng có địa chỉ ở Đà Nẵng
SELECT * FROM customers WHERE address = "Đà Nẵng";

-- Hiển thị tất cả các khách hàng có năm sinh 1990
SELECT * FROM customers WHERE year(birthday) = 1990;

-- Hiển thị tất cả các khách hàng có sinh nhật là hôm nay
SELECT * FROM customers WHERE month(now()) = month(birthday) and day(now()) = day(birthday);

-- Hiển thị tất cả các đơn hàng có trạng thái là DONE
SELECT * FROM orders WHERE status = "done";

-- Hiển thị tất cả các đơn hàng có trạng thái là COMPLETED trong ngày hôm nay
SELECT * FROM orders WHERE status = 'completed' AND date(date_order) = date(now());

-- Hiển thị tất cả các đơn hàng có trạng thái là CANCELED
SELECT * FROM orders WHERE status = 'canceled';

-- Hiển thị tất cả các đơn hàng có trạng thái là CANCELED trong ngày hôm nay
SELECT * FROM orders WHERE status = 'canceled' AND date(date_order) = date(now());

-- Hiển thị tất cả các đơn hàng có hình thức thanh toán là CASH
SELECT * FROM orders WHERE payment_method = 'cash';

-- Hiển thị tất cả các đơn hàng có hình thức thanh toán là CREADIT CARD
SELECT * FROM orders WHERE payment_method = 'creadit card';

-- Hiển thị tất cả các đơn hàng có địa chỉ giao hàng là Hà Nội
SELECT * FROM orders WHERE address_receiver = 'Hà Nội';

-- Hiển thị tất cả các nhân viên có sinh nhật là hôm nay
SELECT * FROM employees WHERE month(now()) = month(birthday) and day(now()) = day(birthday);

-- Hiển thị tất cả các nhà cung cấp có tên là: (Yamaha, SAMSUNG, Nestle, APPLE)
SELECT * FROM suppliers WHERE name in ('Yamaha', 'SAMSUNG', 'Nestle', 'APPLE');

-- Hiển thị tất cả các mặt hàng cùng với CategoryName
SELECT products.*, categories.name FROM products JOIN categories 
on products.category_id = categories.category_id;

-- Hiển thị tất cả các đơn hàng cùng với thông tin chi tiết khách hàng (Customer)
SELECT * FROM orders JOIN customers
on orders.customer_id = customers.customer_id;

-- Hiển thị tất cả các mặt hàng cùng với thông tin chi tiết của Category và Supplier
SELECT * FROM products JOIN categories 
on products.category_id = categories.category_id JOIN suppliers
on products.supplier_id = suppliers.supplier_id;

-- Hiển thị tất cả danh mục (Categories) với số lượng hàng hóa trong mỗi danh mục
SELECT *, count(products.category_id) FROM products JOIN categories 
on products.category_id = categories.category_id GROUP BY categories.category_id;

-- Hiển thị tất cả nhà cung cấp (Suppliers) với số lượng hàng hóa mỗi nhà cung cấp
SELECT *, count(products.supplier_id) FROM products JOIN suppliers 
on products.supplier_id = suppliers.supplier_id GROUP BY suppliers.supplier_id;

-- Hiển thị tất cả các khách hàng mua hàng trong khoảng từ ngày 2020-01-01, đến ngày 2020-04-30
SELECT * FROM customers JOIN orders
on customers.customer_id = orders.customer_id 
WHERE orders.date_order BETWEEN "2020-01-01" AND "2020-04-30";

-- Hiển thị tất cả các khách hàng mua hàng (với tổng số tiền) trong khoảng từ ngày, đến ngày
SELECT customers.*, orders.date_order, sum(products.price * orderdetail.quantity) as tong_tien FROM customers JOIN orders 
on customers.customer_id = orders.customer_id JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id
WHERE orders.date_order BETWEEN "2020-01-01" AND "2020-04-30" GROUP BY customers.customer_id;

-- Hiển thị tất cả đơn hàng với tổng số tiền
SELECT orders.*, sum(products.price * orderdetail.quantity) as tong_tien FROM orders JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id GROUP BY orders.order_id ORDER BY orders.order_id;

-- Hiển thị tất cả các nhân viên bán hàng với tổng số tiền bán được
SELECT employees.*, sum(products.price * orderdetail.quantity) as tong_tien FROM employees JOIN orders 
on employees.employee_id = orders.employee_id JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.status in ("done", "completed") GROUP BY employees.employee_id;

-- Hiển thị tất cả các mặt hàng không bán được
SELECT products.* FROM products LEFT JOIN orderdetail
on products.product_id = orderdetail.product_id 
WHERE orderdetail.product_id IS NULL;


-- Hiển thị tất cả các nhà cung cấp không bán được trong khoảng từ ngày 2020-01-01, đến ngày 2020-04-30
SELECT suppliers.* FROM suppliers left JOIN products 
on suppliers.supplier_id = products.supplier_id LEFT JOIN orderdetail
on products.product_id = orderdetail.product_id LEFT JOIN orders
on orders.order_id = orderdetail.order_id
WHERE suppliers.supplier_id not in (
SELECT suppliers.supplier_id FROM suppliers left JOIN products 
on suppliers.supplier_id = products.supplier_id LEFT JOIN orderdetail
on products.product_id = orderdetail.product_id LEFT JOIN orders
on orders.order_id = orderdetail.order_id
WHERE
orders.date_order BETWEEN '2020-01-01' AND '2020-04-30'
and orders.status <> "canceled"
GROUP BY suppliers.supplier_id 
) and
(not orders.date_order BETWEEN '2020-01-01' AND '2020-04-30')
or (orders.date_order is null) 
GROUP BY suppliers.supplier_id ;

-- Hiển thị top 3 các nhân viên bán hàng với tổng số tiền bán được từ cao đến thấp trong khoảng từ ngày
-- 2020-01-01, đến ngày 2020-12-31
SELECT employees.*, sum(products.price * orderdetail.quantity) as tong_tien FROM employees JOIN orders 
on employees.employee_id = orders.employee_id JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.status in ("done", "completed") and
orders.date_order BETWEEN '2020-01-01' AND '2020-12-31'
GROUP BY employees.employee_id 
ORDER BY tong_tien DESC
LIMIT 0, 3;

-- Hiển thị top 5 các khách hàng mua hàng với tổng số tiền mua được từ cao đến thấp trong khoảng
-- từ ngày 2020-01-01, đến ngày 2020-12-31
SELECT customers.*, orders.date_order, sum(products.price * orderdetail.quantity) as tong_tien FROM customers JOIN orders 
on customers.customer_id = orders.customer_id JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id
WHERE orders.date_order BETWEEN "2020-01-01" AND "2020-12-31" GROUP BY customers.customer_id
ORDER BY tong_tien DESC
LIMIT 0, 5;

-- Hiển thị danh sách các mức giảm giá của cửa hàng
SELECT DISTINCT discount FROM products;

-- Hiển thị tất cả danh mục (Categories) với tổng số tiền bán được trong mỗi danh mục
SELECT categories.*, sum(products.price * orderdetail.quantity) as tong_tien
FROM products JOIN categories
on products.category_id = categories.category_id  JOIN orderdetail
on products.product_id = orderdetail.product_id
GROUP BY categories.category_id;

-- Hiển thị tất cả đơn hàng với tổng số tiền mà đã được giao hàng thành công trong khoảng từ ngày
-- 2020-01-01, đến ngày 2020-04-30
SELECT orders.*, sum(products.price * orderdetail.quantity) as tong_tien FROM orders JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.status in ("done", "completed")
and orders.date_order BETWEEN '2020-01-01' AND '2020-04-30'
GROUP BY orders.order_id ORDER BY orders.order_id;

-- Hiển thị tất cả đơn hàng có tổng số tiền bán hàng nhiều nhất trong khoảng từ ngày 2020-01-01, 
-- đến ngày 2020-04-30
SELECT orders.*, sum(products.price * orderdetail.quantity) as tong_tien FROM orders JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.date_order BETWEEN '2020-01-01' AND '2020-04-30'
GROUP BY orders.order_id ORDER BY tong_tien DESC;

-- Hiển thị tất cả đơn hàng có tổng số tiền bán hàng ít nhất trong khoảng từ ngày 2020-01-01, 
-- đến ngày 2020-04-30
SELECT orders.*, sum(products.price * orderdetail.quantity) as tong_tien FROM orders JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.date_order BETWEEN '2020-01-01' AND '2020-04-30'
GROUP BY orders.order_id ORDER BY tong_tien;

SELECT orders.*, avg(products.price * orderdetail.quantity) as tong_tien FROM orders JOIN orderdetail
on orders.order_id = orderdetail.order_id JOIN products
on products.product_id = orderdetail.product_id 
WHERE orders.date_order BETWEEN '2020-01-01' AND '2020-04-30'
GROUP BY orders.order_id ORDER BY tong_tien;