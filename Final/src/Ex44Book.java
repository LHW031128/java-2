public class Ex44Book {
    String title;
    String author;

    public Ex44Book(String t) { // 생성자
        title = t;
        author = "작자미상";
    }

    public Ex44Book(String t, String a) { // 생성자
        title = t;
        author = a;
    }

    public static void main(String[] args) {
        Ex44Book littlePrince = new Ex44Book("어린왕자", "생텍쥐페리");
        Ex44Book loveStory = new Ex44Book("춘향전");

        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
}
