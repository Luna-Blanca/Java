package DAY_UI_BOOK;

import java.util.ArrayList;
import java.util.Iterator;

// BookManager / BookDatabase
// Book을 관리하는 클래스
public class Book {
    public ArrayList<BookVO> booklist;

    public Book() {
        booklist = new ArrayList<BookVO>();
    }

    public boolean insert(BookVO book) {
        return booklist.add(book);
    }

    public BookVO search(String name) {
        BookVO book = null;

        for (BookVO vo : booklist) {
            if (vo.getName().equals(name)) {
                book = vo;
            }
        }

        return book;
    }

    public boolean update(BookVO book) {
        boolean result = false;
        int idx = -1;
        for (int i = 0; i < booklist.size(); i++) {
            BookVO vo = booklist.get(i);
            if (vo.getName().equals(book.getName())) {
                idx = i;
            }
        }

        if (idx != -1) {
            booklist.set(idx, book);
            result = true;
        }

        return result;
    }

    public boolean delete(String name) {
        boolean result = false;

        Iterator<BookVO> ie = booklist.iterator();
        while (ie.hasNext()) {
            BookVO book = ie.next();
            if (book.getName().equals(name)) {
                ie.remove();
                result = true;
            }
        }

        return result;
    }
}
