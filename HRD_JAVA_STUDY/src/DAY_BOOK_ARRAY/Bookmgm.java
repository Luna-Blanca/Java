package DAY_BOOK_ARRAY;

/**
 * 수원도서관의 도서관리 프로그램을 담당하고 있는 A씨는 새 책이 입고되면,
 * 도서번호(ISBN),도서명,저자,가격을 입력하여 도서를 등록/검색/수정/삭제 한다.
 * 도서 등록 기능이 완료되면 등록된 도서전체리스트가 출력되도록 한다.
 * 도서가 저장되는 공간은 프로그램 실행 시 맨 먼저 정의하고 실행되도록 한다.
 */

import java.util.Scanner;

public class Bookmgm {
    //Field
    BookVO book;
    BookVO[] booklist;
    int count;
    Scanner scan = new Scanner(System.in);
    public static final int INSERT = 1;
    public static final int SEARCH = 2;
    public static final int UPDATE = 3;
    public static final int DELETE = 4;
    public static final int EXIT = 5;

    //Constructor
    //Method
    /**
     * 도서저장 공간 정의 : init
     */
    public void init() {
        System.out.print("저장할 도서수를 입력해주세요>>");
        int number = scan.nextInt();
        if(number !=0) {
            booklist = new BookVO[number];
            showMenu();
        }else {
            System.out.println("---------->> 다시 입력해주세요");
            init();
        }
    }

    /**
     * 도서관리 프로그램 메뉴 출력
     */
    public void showMenu() {
        System.out.println("=================================");
        System.out.println("\t  도서관리 프로그램");
        System.out.println("\t1. 도서등록");
        System.out.println("\t2. 도서검색");
        System.out.println("\t3. 도서수정");
        System.out.println("\t4. 도서삭제");
        System.out.println("\t5. 프로그램 종료");
        System.out.println("=================================");

        choiceMenu();
    }

    /**
     * 메뉴 선택
     */
    public void choiceMenu() {
        System.out.print("메뉴선택>");
        int menu = scan.nextInt();

        switch(menu) {
            case Bookmgm.INSERT:
                insert();
                break;
            case Bookmgm.SEARCH:
                search();
                break;
            case Bookmgm.UPDATE:
                update();
                break;
            case Bookmgm.DELETE:
                delete();
                break;
            case Bookmgm.EXIT:
                quit();
                break;
            default :
                System.out.println(" 메뉴 준비중 ~");
                showMenu();
        }
    }

    /**
     * 등록
     */
    public void insert() {
        if(count < booklist.length) {
            book = new BookVO();

            System.out.print("도서번호>");
            book.setIsbn(scan.next());
            System.out.print("도서명>");
            book.setName(scan.next());
            System.out.print("저자>");
            book.setAuthor(scan.next());
            System.out.print("가격>");
            book.setPrice(scan.nextInt());

            booklist[count] = book;
            count++;

            System.out.println("------------>> 도서갯수 : " + count +"권");
            select();

        }else {
            System.out.println("-- 저장 공간이 부족합니다 --");
        }

        choiceMenu();
    }

    /**
     * 도서리스트의 도서가 저장된 인덱스 반환 : 검색, 수정, 삭제에서 호출
     */
    public int searchIndex() {
        System.out.print("도서번호>>");
        String isbn = scan.next();
        int idx = -1;

        for(int i=0;i<count;i++) {
            BookVO book = booklist[i];
            if(isbn.equals(book.getIsbn())) {
                idx = i;
                i=booklist.length;
            }
        }

        return idx;
    }



    /**
     * 검색
     */
    public void search() {
        if(count !=0) {
            int idx = searchIndex();
            if(idx != -1) {
                BookVO book = booklist[idx];

                System.out.println("----------------------------------------------");
                System.out.println("도서번호\t도서명\t저자\t가격");
                System.out.println("----------------------------------------------");
                System.out.print(book.getIsbn() + "\t");
                System.out.print(book.getName() + "\t");
                System.out.print(book.getAuthor() + "\t");
                System.out.print(book.getPrice() + "\n");
                System.out.println("----------------------------------------------");
            }else {
                System.out.println("-- 검색한 데이터가 존재하지 않습니다 --");
            }

        }else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 -- ");
        }


        choiceMenu();
    }

    /**
     * 수정
     */
    public void update() {
        if(count !=0) {
            int idx = searchIndex();
            if(idx != -1) {
                BookVO book = booklist[idx];

                System.out.print("도서명>");
                book.setName(scan.next());
                System.out.print("저자>");
                book.setAuthor(scan.next());
                System.out.print("가격>");
                book.setPrice(scan.nextInt());

                System.out.println("-- 수정이 완료되었습니다 --");
                select();
            }else {
                System.out.println("-- 수정할 데이터가 존재하지 않습니다 --");
            }

        }else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 -- ");
        }

        choiceMenu();
    }

    /**
     * 삭제
     */
    public void delete() {
        if(count != 0) {
            int idx = searchIndex();
            if(idx != -1) {
                for(int i=idx;i<booklist.length;i++) {
                    if(i != (booklist.length-1)) {
                        booklist[i] = booklist[i+1];
                    }else {
                        booklist[i] = null;
                    }
                }
                count--;

                System.out.println("-- 삭제가 완료되었습니다 --");
                select();

            }else {
                System.out.println("-- 삭제할 데이터가 존재하지 않습니다 --");
            }
        }else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 -- ");
        }

        choiceMenu();
    }

    /**
     * 종료
     */
    public void quit() {
        System.out.println("종료");
        //choiceMenu();
        System.exit(0);
    }

    /**
     * 전체 도서리스트 출력
     */
    public void select() {
        if(count != 0) {
            System.out.println("=============================================");
            System.out.println("도서번호\t도서명\t저자\t가격");
            System.out.println("=============================================");
            for(BookVO book : booklist) {
                if(book != null) {
                    System.out.print(book.getIsbn()+"\t");
                    System.out.print(book.getName()+"\t");
                    System.out.print(book.getAuthor()+"\t");
                    System.out.print(book.getPrice()+"\n");
                }
            }
            System.out.println("=============================================");
        }else {
            System.out.println("-- 등록된 데이터가 존재하지 않습니다. 등록부터 진행해주세요 -- ");
        }
    }


}//class
