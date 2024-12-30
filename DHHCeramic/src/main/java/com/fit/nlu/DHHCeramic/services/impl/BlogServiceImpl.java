package com.fit.nlu.DHHCeramic.services.impl;


import com.fit.nlu.DHHCeramic.dao.BlogDao;
import com.fit.nlu.DHHCeramic.dao.impl.BlogDaoImpl;
import com.fit.nlu.DHHCeramic.model.Blog;
import com.fit.nlu.DHHCeramic.services.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    BlogDao dao = new BlogDaoImpl();

    @Override
    public void insert(Blog blog) {
        dao.insert(blog);
    }

    @Override
    public void edit(Blog newBlog) {

        dao.edit(newBlog);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Blog get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Blog> getAll() {
        return dao.getAll();
    }

    @Override
    public int numOfBlogs() {
        return dao.getNumOfBlogs();
    }

    @Override
    public List<Blog> getBlogByPage(int currentPage, int blogsPerPage) {
        return dao.getBlogByPage(currentPage, blogsPerPage);
    }

}
