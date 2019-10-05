package com.bo.entity;

/**
 * @author nangon1234
 * @ClassName Book
 * @Description 图书实体类
 * @Date 2019/9/26
 * @Version 1.0
 **/
public class Book
{
    private Integer id;      //条形码
    private String name;     //书名
    private String cover;    //封面
    private String author;   //作者

    public Book(Integer id, String name, String cover, String author)
    {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.author = author;
    }
    public Book(Integer id,String name,String author)
    {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCover()
    {
        return cover;
    }

    public void setCover(String cover)
    {
        this.cover = cover;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    /**
     *
     * @param book
     * @return
     * @description 低级比较方法
     */
    public boolean lowerEquals(Book book)
    {
       if(this.id!=null&&this.id.equals(book.getId()))
         {
             return  true;
         }
       if(this.name!=null&&this.name.equals(book.getName()))
         {
             return  true;
         }
       if(book.getAuthor().equals(this.author))
         {
             return true;
         }
       return false;
    }

    /**
     *
     * @return
     * @description 判断图书是否存在
     */
    public boolean isEmpty()
    {
      return this.id==-1&&this.author==null&&this.name==null;
    }
}
