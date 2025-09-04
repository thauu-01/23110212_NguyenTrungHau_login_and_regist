package chucnangdangnhap;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int cateId) {
        categoryDao.delete(cateId);
    }

    @Override
    public Category get(int cateId) {
        return categoryDao.get(cateId);
    }

    @Override
    public List<Category> getAllByUser(int userId) {
        return categoryDao.getAllByUser(userId);
    }
}