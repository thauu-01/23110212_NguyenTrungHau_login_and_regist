package chucnangdangnhap;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
    private int cateId;
    private String cateName;
    private int userId;

    public Category() {}

    public Category(String cateName, int userId) {
        this.cateName = cateName;
        this.userId = userId;
    }

    public int getCateId() { return cateId; }
    public void setCateId(int cateId) { this.cateId = cateId; }
    public String getCateName() { return cateName; }
    public void setCateName(String cateName) { this.cateName = cateName; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}