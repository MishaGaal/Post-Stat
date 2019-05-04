package mike.galitsky.poststat;

public class Post {

    private int id;
    private String slug;
    private int type;
    private int comments_count;
    private int likes_count;
    private int reposts_count;
    private int bookmarks_count;
    private int views_count;

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public int getType() {
        return type;
    }

    public int getComments_count() {
        return comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public int getBookmarks_count() {
        return bookmarks_count;
    }

    public int getViews_count() {
        return views_count;
    }
}
