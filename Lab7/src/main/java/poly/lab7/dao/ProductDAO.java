package poly.lab7.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.lab7.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    // Bài 1: Tìm sản phẩm theo khoảng giá (JPQL)
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    // Bài 2: Tìm sản phẩm theo tên và phân trang (JPQL)
    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    // Bài 3: Thống kê tồn kho theo loại (JPQL)
    @Query("SELECT p.category AS group, SUM(p.price) AS sum, COUNT(p) AS count "
            + " FROM Product p "
            + " GROUP BY p.category"
            + " ORDER BY SUM(p.price) DESC")
    List<Report> getInventoryByCategory();

    // Bài 4: Tìm sản phẩm theo khoảng giá (DSL)
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Bài 5: Tìm sản phẩm theo tên và phân trang (DSL)
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}