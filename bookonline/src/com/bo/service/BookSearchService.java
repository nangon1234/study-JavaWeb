package com.bo.service;

import com.bo.entity.Book;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName BookSearchService
 * @Description TODO
 * @Author nangon1234
 * @Date 2019/10/5
 * @Version 1.0
 **/
public class BookSearchService
{
     private List<Book> bookList;
     private Book search_book;
    /**
     *
     * @param bookList
     * @description 初始化bookList
     */
    public void setBookList(List<Book> bookList)
    {
        this.bookList = bookList;
    }

    /**
     *
     * @param 【id,name,author】
     * @return
     * @description 搜索
     */
    public List<Book> search(String book_search_name)
    {
        search_book= null;
        List<Book>search_bookList =null;
        //初始化带搜索的图书
        search_book=init_search_book(book_search_name);
        System.out.println("打印图书信息：");
        System.out.println(search_book.toString());
        //判断是否输入图书相关信息
        if(search_book.isEmpty())
          {
              return null;
          }
        //创建已搜索图书列表容器
        search_bookList = new ArrayList<Book>();
        //搜索图书
        for (Book book: bookList)
            {
                 if(search_book.lowerEquals(book))
                   {
                       search_bookList.add(book);
                   }
            }
        return search_bookList;
    }

    public Book init_search_book(String book_search_name)
    {

        Pattern pattern = Pattern.compile("[0-9]*");
        boolean result= pattern.matcher(book_search_name).matches();
        if(result)
        {
            return new Book(Integer.parseInt(book_search_name),null,null);
        }
        if (book_search_name.startsWith("《")&&book_search_name.endsWith("》"))
        {
            return new Book(-1,book_search_name,null);
        }
        return new Book(-1,null,book_search_name);
    }
}

    