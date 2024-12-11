package com.foodapp.dao;

import com.foodapp.model.Menu;
import java.util.List;

public interface MenuDAO {
    int addMenu(Menu menu);
    List<Menu> getAllMenus();
    Menu getMenuById(int mid);
    int updateMenu(Menu menu);
    int deleteMenu(int mid);
}

