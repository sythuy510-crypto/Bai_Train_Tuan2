# Bai_Train_Tuan2

Project Java don gian de quan ly danh sach san pham theo mo hinh:

- `Model`
- `Repository`
- `Service`
- `Exception`

## Chuc nang

- Them san pham
- Tim san pham theo `id`
- Lay danh sach `n` san pham dat nhat
- Tinh tong gia tri kho
- Loc san pham theo danh muc
- Nem exception khi khong tim thay san pham

## Cau truc thu muc

```text
src/
  Main.java
  Model/Product.java
  Repository/ProductRepository.java
  Repository/ProductRepositoryImpl.java
  Service/ProductService.java
  Exception/ProductNotFoundException.java
```

## Cach chay

Compile:

```powershell
javac -d out src\Main.java src\Model\Product.java src\Repository\ProductRepository.java src\Repository\ProductRepositoryImpl.java src\Service\ProductService.java src\Exception\ProductNotFoundException.java
```

Run:

```powershell
java -cp out Main
```

## Du lieu mau

Chuong trinh hien tai tao san 4 san pham:

- Laptop - `25000000`
- iPhone - `20000000`
- iPad - `15000000`
- Chair - `2000000`

## Ket qua mau

```text
Top 3 san pham dat nhat:
Product{id='1', name='Laptop', price=25000000, category='Electronics'}
Product{id='2', name='iPhone', price=20000000, category='Electronics'}
Product{id='3', name='iPad', price=15000000, category='Electronics'}
Tong gia tri kho:
62000000
Electronics:
3 san pham
```

## Ghi chu

- Gia san pham dang duoc luu bang kieu so nguyen.
- Phan xu ly chinh nam trong `ProductService`.
- Du lieu hien tai duoc luu tam trong bo nho qua `ArrayList`.

## Stream: map() va filter()

- `filter()` dung de loc phan tu theo dieu kien.
- `map()` dung de bien doi moi phan tu sang dang khac.

Vi du `filter()`:

```java
List<Product> electronics = repo.findAll().stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Electronics"))
        .collect(Collectors.toList());
```

Vi du `map()`:

```java
List<String> productNames = repo.findAll().stream()
        .map(Product::getName)
        .collect(Collectors.toList());
```

## Demo debug trong IntelliJ

Co the demo breakpoint tai:

- `Main.java`: dong goi `service.getTopExpensive(3)`
- `ProductService.java`: method `getTopExpensive()`

Trinh tu demo:

1. Dat breakpoint trong IntelliJ.
2. Chon `Debug 'Main'`.
3. Dung `Step Into` de di vao method.
4. Kiem tra gia tri bien trong cua so `Variables`.
5. Xem ket qua sau khi `sorted()` va `limit(3)`.
