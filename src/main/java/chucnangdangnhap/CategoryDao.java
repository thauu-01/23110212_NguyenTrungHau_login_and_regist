package chucnangdangnhap;

import java.util.List;

public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int cateId);
    Category get(int cateId);
    List<Category> getAllByUser(int userId);
}